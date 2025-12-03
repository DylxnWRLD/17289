FROM rrojano/spring-boot
WORKDIR /app
CMD ["java","-jar", "target/SaludarDatos-0.0.1-SNAPSHOT.jar"]
COPY SaludarDatos/SaludarDatos/pom.xml .
COPY SaludarDatos/SaludarDatos/src ./src
RUN mvn package -DskipTests