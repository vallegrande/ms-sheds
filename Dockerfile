FROM openjdk:17-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en el contenedor
COPY target/*.jar app.jar

# Variables de entorno necesarias para tu aplicación
ENV R2DBC_URL=${R2DBC_URL}
ENV R2DBC_USERNAME=${R2DBC_USERNAME}
ENV R2DBC_PASSWORD=${R2DBC_PASSWORD}

# Expone el puerto 9000 que usa tu aplicación
EXPOSE 9000

# Comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]