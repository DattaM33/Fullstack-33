
# Use a lightweight base image with OpenJDK 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/CURDOpration-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on (optional but helpful)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
