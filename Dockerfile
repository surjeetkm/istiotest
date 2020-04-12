FROM openjdk:8
EXPOSE 8080
ADD target/istio-service.jar istio-service.jar
ENTRYPOINT ["java","-jar","istio-service.jar"]