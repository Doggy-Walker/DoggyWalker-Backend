FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY build/libs/*.jar pawkey-dev.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "pawkey-dev.jar"]
