# Usa la imagen base oficial de OpenJDK 17
FROM openjdk:17

# Establece el directorio de trabajo en /app
VOLUME /app

# Copia el archivo JAR compilado de tu proyecto Spring Boot al contenedor
COPY target/cuentamovimientos-1.0.0.jar  cuentamovimientos-api.jar

# Expone el puerto en el que se ejecutará tu aplicación
EXPOSE 8080

# Ejecuta la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/cuentamovimientos-api.jar"]