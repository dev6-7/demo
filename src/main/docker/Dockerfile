FROM bellsoft/liberica-openjdk-alpine:17.0.4
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]