FROM  eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY target/taskmanager-0.0.1-SNAPSHOT.jar app.jar
COPY serviceAccountKey.json serviceAccountKey.json
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]