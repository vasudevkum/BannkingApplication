FROM eclipse-temurin:17-jdk-alpine

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
