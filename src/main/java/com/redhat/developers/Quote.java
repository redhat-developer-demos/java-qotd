package com.redhat.developers;

import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;

@Entity
public class Quote extends PanacheEntity {

  public static final String CASE_INSENSITVE_VALUE_FORMAT = "%%%s%%";
  public String quotation;
  public String author;

  public static List<Quote> findQuotesOfAuthor(String author) {
    return find("lower(author) like :author",
        Parameters.with("author",
            String.format(CASE_INSENSITVE_VALUE_FORMAT, author.toLowerCase()))
            .map())
                .list();
  }
}
