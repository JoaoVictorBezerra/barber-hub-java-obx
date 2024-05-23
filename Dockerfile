FROM openjdk:17-jdk-slim

COPY . /app

WORKDIR /app

RUN ./mvnw clean package

RUN mv target/barberhub-0.0.1-SNAPSHOT.jar.original /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]