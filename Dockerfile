# Etape 1 : Build (Construction du JAR
FROM maven:3.99.9-eclopse-temurin-25-alpine AS build

WORKDIR /app

#On copie tout le projet
COPY . .

#On compile le projet en ignorant les tests (pour gagner du temps au build)
RUN mvn clean package -DskipTests


# Etape 2 : Exécution
FROM eclipse-temurin:25-jdk

# Exposer le port 9002
EXPOSE 9002

# Répertoire de travail dans le conteneur pour stocker le jar
WORKDIR /app


# On récupère le JAR généré lors de l'étape précédente (AS build)
COPY --from=build /app/target/*.jar /app/codecaseapi.jar

# Commande pour exécuter le fichier jar
ENTRYPOINT ["java", "-jar", "/app/codecaseapi.jar"]