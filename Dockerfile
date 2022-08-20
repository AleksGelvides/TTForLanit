FROM openjdk:17
ENV APP_HOME=usr/app
COPY /target/*.jar test_task.jar
EXPOSE 8080
CMD ["java", "-jar", "test_task.jar"]