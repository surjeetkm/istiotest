FROM openjdk:8
RUN mkdir -p /opt/to-do-app/ 
COPY ./target/istio-service.jar /opt/to-do-app/
WORKDIR /opt/to-do-app/
EXPOSE 8080
CMD ["java", "-jar", "istio-service.jar"]




