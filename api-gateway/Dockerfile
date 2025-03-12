# api-gateway/Dockerfile
FROM maven:3.9-eclipse-temurin-21 as builder
WORKDIR /app

# Copy the parent pom (from the project root)
COPY . .

# Build the api-gateway module using its pom file
RUN mvn -f api-gateway/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/api-gateway/target/api-gateway-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]