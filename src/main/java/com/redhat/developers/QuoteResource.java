package com.redhat.developers;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.quarkus.panache.common.Sort;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api")
public class QuoteResource {

    Random random = new Random();

    @GET
    @Path("/index")
    public String index() {
        return "qotd";
    }

    @GET
    @Path("/quotes")
    public Response all() {
        return Response.ok(Quote.listAll(Sort.by(
                "author")))
                .build();
    }

    @GET
    @Path("/quotes/random")
    public Response random() {
        List<Quote> quotes = Quote.listAll();
        return Response.ok(quotes.get(random.nextInt(quotes.size())))
                .build();
    }

    @GET
    @Path("/quotes/{quoteId}")
    public Response oneQuote(@PathParam("quoteId") long quoteId) {
        return Response.ok(Quote.findById(quoteId)).build();
    }

    @GET
    @Path("/quotes/author/{author}")
    public Response quoteByAuthor(@PathParam("author") String author) {
        return Response.ok(Quote.findQuotesOfAuthor(author)).build();
    }

    @GET
    @Path("/version")
    public String version() {
        return "v1";
    }

    @GET
    @Path("/writtenin")
    public String writtenIn() {
        return "Java";
    }

    @Transactional
    @POST
    @Path("/quotes/add")
    public Response addQuote(Quote quote) {
        quote.persist();
        return Response.accepted().build();
    }
}
