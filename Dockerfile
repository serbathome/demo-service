FROM --platform=AMD64 openjdk:17
LABEL authors="serb"
COPY target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]