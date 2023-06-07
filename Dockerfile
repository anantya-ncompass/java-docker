FROM maven AS build
WORKDIR /app/anantya
COPY . .
RUN mvn clean package
FROM openjdk:18-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/anantya/target/java-docker*.jar app.jar
ENTRYPOINT ["jadva", "-jar", "app.jar"]