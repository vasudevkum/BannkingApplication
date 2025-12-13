
FROM eclipse-temurin:17-jdk-alpin
# Stage 1: Build the JAR
FROM eclipse-temurin:17-jdk-alpine AS builder


WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn


RUN chmod +x mvnw
RUN ./mvnw -q dependency:go-offline

COPY src src

RUN ./mvnw -q -DskipTests package

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]
COPY src src

RUN chmod +x mvnw
RUN ./mvnw -DskipTests package

# Stage 2: Run the JAR
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

