FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/TakemeHome0_0-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} TakemeHome0_0.jar
ENTRYPOINT ["java","-jar","/TakemeHome0_0.jar"]