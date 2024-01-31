# Usa la imagen base de Amazon Corretto 17 en Alpine 3.17 con el JDK
FROM amazoncorretto:17-alpine3.17-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR del backend al directorio de trabajo
COPY build/libs/hoteles-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación Spring Boot se ejecutará
EXPOSE 8080

# Comando para iniciar la aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]
