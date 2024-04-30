FROM maven:3.8.6-openjdk-18-slim AS build

WORKDIR /home/app

COPY code/ianua.api.gateway/pom.xml .

COPY code/ianua.api.gateway/src ./src

RUN mvn clean package
RUN mvn install

FROM openjdk:18.0-slim

EXPOSE 7080

COPY --from=build /home/app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
