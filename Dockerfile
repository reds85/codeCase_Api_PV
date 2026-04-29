# Etape 2 : Exécution
FROM eclipse-temurin:25-jdk

# Exposer le port 9002
EXPOSE 9002

# Répertoire de travail dans le conteneur pour stocker le jar
WORKDIR /app

# Correction du chemin et du nom du fichier :
# 1. On cherche dans 'target/' (où Maven dépose le jar)
# 2. On utilise le nom correct 'codecasesite' vu dans vos logs
# 3. On le renomme en 'app.jar' pour simplifier l'ENTRYPOINT
COPY target/codecasesite-0.0.1-SNAPSHOT.jar app.jar

# Commande pour exécuter le fichier jar
ENTRYPOINT ["java", "-jar", "app.jar"]