FROM openjdk:17-oracle

WORKDIR /app

EXPOSE 8080

COPY target/nagp-0.0.1-SNAPSHOT.jar /app/nagp.jar

# Define environment variables
#ENV MONGO_DB_HOST=mongo
#ENV MONGO_DB_PORT=27017
#ENV MONGO_DB_DATABASE=movie_db

ENTRYPOINT ["java", "-jar", "/app/nagp.jar"]