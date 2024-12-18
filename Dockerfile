FROM maven:3.9.0-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

ENV R2DBC_URL=${R2DBC_URL} \
    R2DBC_USERNAME=${R2DBC_USERNAME} \
    R2DBC_PASSWORD=${R2DBC_PASSWORD}

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
