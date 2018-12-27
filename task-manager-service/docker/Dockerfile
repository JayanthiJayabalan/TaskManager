FROM openjdk:8
ADD /task-manager-service.jar task-manager-service.jar
EXPOSE 8092
RUN bash -c 'touch /task-manager-service.jar'
ENTRYPOINT ["java","-jar","task-manager-service.jar"]
