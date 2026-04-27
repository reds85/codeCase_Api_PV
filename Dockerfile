# Etape 1 : Build (Construction du JAR
FROM maven:3.9.6-eclipse-temurin-25-alpine

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

# Commande pour exécuter le fichier jar
ENTRYPOINT ["java", "-jar", "/app/codecaseapi.jar"]