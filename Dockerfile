FROM openjdk:8
RUN mkdir -p /opt/store/
COPY ./target/istio-service.jar /opt/store/
WORKDIR /opt/store/
EXPOSE 9090:9090
CMD ["java", "-jar", "istio-service.jar"]