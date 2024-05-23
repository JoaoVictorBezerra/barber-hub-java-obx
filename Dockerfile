#FROM openjdk:17-jdk-slim
#
#COPY . /app
#
#WORKDIR /app
#
#RUN ./mvnw clean package
#
#RUN mv target/barberhub-0.0.1-SNAPSHOT.jar /app/app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]


#
##
## Build stage
##
#FROM openjdk:17-jdk-slim
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
##
## Package stage
##
#FROM openjdk:17-jdk-slim
#COPY --from=build /home/app/target/barberhub-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]