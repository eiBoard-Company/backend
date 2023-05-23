# Verwenden des offiziellen Maven-Images als Basis
FROM maven:3.8.4-openjdk-11-slim

# Setzen von Umgebungsvariablen
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64
ENV MAVEN_HOME /usr/share/maven

# Hinzufügen des Maven-Binärverzeichnisses zum Pfad
ENV PATH $MAVEN_HOME/bin:$PATH

# Aktualisieren der Paketliste und Installation von OpenJDK 11
RUN apt-get update && apt-get install -y openjdk-11-jdk

# Kopieren des aktuellen Verzeichnisses in den Container und Setzen des Arbeitsverzeichnisses
COPY . /usr/src/app
WORKDIR /usr/src/app

# Kompilieren des Maven-Projekts
RUN mvn clean install

# Starten der Anwendung
CMD ["java", "-jar", "eiBoard.jar"]
