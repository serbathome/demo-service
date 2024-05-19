FROM --platform=AMD64 openjdk:11
LABEL authors="serb"
EXPOSE 8080
COPY target/*.jar myapp.jar
CMD ["java", "-jar", "myapp.jar"]