FROM --platform=AMD64 maven:3.6.3-jdk-11 as build
LABEL authors="serb"
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
COPY target/*.jar myapp.jar

FROM --platform=AMD64 openjdk:11-oraclelinux8 as runtime
COPY --from=build ./app/myapp.jar .
CMD ["java", "-jar", "myapp.jar"]