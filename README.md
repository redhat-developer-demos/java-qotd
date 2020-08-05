# Java variant of quotd application

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## API Methods

- `/api/index` - returns String 'qotd'
- `/api/quotes` - returns all available Quotes as JSON
- `/api/quotes/random` - returns random quote from available list
- `/api/quotes/{quoteId}` - returns Quote by quoteId
- `/api/quotes/author/{author}` - returns Quotes by author
- `/api/quotes/add` - adds a new quote
- `/api/quotes/writtenin` - returns the programming language "Java"
- `/api/quotes/version` - returns version of the API "v1"

## Liveness and Readiness 

- `/health/ready` - shows the readiness of the application
- `/health/live` - shows the liveness of the application

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `java-qotd-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/java-qotd-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/java-qotd-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.