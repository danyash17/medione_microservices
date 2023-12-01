# Stage 1: Build stage
FROM mysql:latest as mysql

# Stage 2: Final stage
FROM openjdk:17.0.1-jdk-slim

MAINTAINER danyashes

COPY target/MedioneMicroservices_Visits-0.0.1-SNAPSHOT.jar MM_Visits.jar
# Copy the MySQL client library from the mysql stage
COPY --from=mysql /usr/bin/mysql /usr/bin/mysql

# Set environment variables
ENV SPRING_DATASOURCE_URL jdbc:mysql://host.docker.internal:3306/medione?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Moscow&useLegacyDatetimeCode=false
ENV SPRING_DATASOURCE_USERNAME root
ENV SPRING_DATASOURCE_PASSWORD root

ENTRYPOINT ["java","-jar","/MM_Visits.jar"]