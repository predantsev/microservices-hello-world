# hello-service/Dockerfile
FROM maven:3.9-eclipse-temurin-21 as builder
WORKDIR /app

# Copy the entire project so the parent POM is available
COPY . .

# Build the hello-service module using its own pom.xml
RUN mvn -f hello-service/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar for hello-service
COPY --from=builder /app/hello-service/target/hello-service-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]