FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8081

COPY --from=build /app/target/*.jar demo.jar

CMD ["java", "-jar", "demo.jar"]
