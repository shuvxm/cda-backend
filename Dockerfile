# Use official JDK 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy everything to the container
COPY . .

# Package the application using Maven wrapper
RUN ./mvnw clean package -DskipTests

# Run the generated jar file
CMD ["java", "-jar", "target/cda-backend-0.0.1-SNAPSHOT.jar"]
