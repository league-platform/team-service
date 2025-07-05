FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy only pom.xml first to leverage Docker cache
COPY pom.xml ./

# Install dependencies
RUN apk add --no-cache maven \
    && mvn dependency:go-offline

# Copy the rest of the source code
COPY . .

# Build the project using Maven installed in the image
RUN mvn clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/team-service-0.0.1-SNAPSHOT.jar"]
