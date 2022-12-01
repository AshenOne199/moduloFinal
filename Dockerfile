FROM openjdk:17
EXPOSE 8082
ADD target/proyecto-final-github-actions.jar proyecto-final-github-actions.jar
ENTRYPOINT ["java", "-jar", "/proyecto-final-github-actions.jar"]

