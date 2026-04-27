# Etape 2 : Exécution
FROM eclipse-temurin:25-jdk

# Exposer le port 9001
EXPOSE 9001

# Répertoire de travail dans le conteneur pour stocker le jar
WORKDIR /app

#On copie tout le projet
COPY codecaseapi-0.0.1-SNAPSHOT.jar /app/codecaseapi-0.0.1-SNAPSHOT.jar

# Commande pour exécuter le fichier jar
ENTRYPOINT ["java", "-jar", "/app/codecaseapi-0.0.1-SNAPSHOT.jar"]