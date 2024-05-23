FROM openjdk:17-jdk-slim

COPY . /app

RUN mvn clean package

RUN mv target/barberhub-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
