# ETAPA 1: BUILD
# Se cambia la imagen base a un tag oficial y válido de Maven con JDK 17
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
# Descarga las dependencias primero para aprovechar el cache de Docker
RUN mvn dependency:go-offline
COPY src ./src
# Genera el JAR ejecutable
RUN mvn package -DskipTests

# ETAPA 2: RUNTIME
# Imagen ligera de Java Runtime Environment (JRE) para la ejecución final
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Expone el puerto por defecto de Spring Boot (u otra aplicación Java)
EXPOSE 8080
# Copia el JAR generado en la etapa 'build'
COPY --from=build /app/target/*.jar app.jar
# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]