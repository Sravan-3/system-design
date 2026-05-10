# Build stage (Java 21)
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage (Java 21)
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-Xms128m", "-Xmx200m", "-XX:+UseContainerSupport", "-jar", "app.jar"]