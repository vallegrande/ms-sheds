FROM openjdk:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

ENV R2DBC_URL=${R2DBC_URL}

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "app.jar"]
