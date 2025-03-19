FROM maven:3.9-eclipse-temurin-21 as builder
WORKDIR /app

# Copy the entire project so that parent POM is available
COPY . .

# Build the counter-service module using its own pom.xml
RUN mvn -f counter-service/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/counter-service/target/counter-service-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]