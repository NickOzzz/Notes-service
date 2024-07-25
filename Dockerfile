FROM arm32v7/openjdk:11.0.3-jdk-slim

ADD /target/demo-0.0.1-SNAPSHOT.jar /out/demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/out/demo-0.0.1-SNAPSHOT.jar"]