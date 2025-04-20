#Étape 1 : Build du projet avec Maven
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
# DskipTests : évite d’exécuter les tests pour accélérer le build.

# Étape 2 : Image finale
FROM eclipse-temurin:17-jdk
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]

