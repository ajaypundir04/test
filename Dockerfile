FROM openjdk:17
COPY test.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
