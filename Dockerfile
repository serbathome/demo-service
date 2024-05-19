FROM --platform=AMD64 openjdk:11
LABEL authors="serb"
COPY target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]