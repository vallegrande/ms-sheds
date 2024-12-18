FROM maven:3.9.0-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml ./ 
COPY src ./src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Configuración de las variables de entorno con tus datos
ENV DATABASE_URL=r2dbc:postgresql://ep-icy-sunset-a578ej1o.us-east-2.aws.neon.tech/shed?sslmode=require \
    DATABASE_USERNAME=shed_owner \
    DATABASE_PASSWORD=LtCjN8zZmUa1

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# Comandos para el build y deploy (si se requiere)
# sdk install java 17.0.11-jbr
# mvn clean install -DskipTests
# mvn spring-boot:run
# docker build -t chumpitazkasandra/backsheds .
# docker push chumpitazkasandra/backsheds
# docker-compose up
# kubectl port-forward service/backsheds 8080:30001 -n 01-chumpitazkasandra
