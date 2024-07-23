FROM arm32v7/openjdk:17-jdk-slim

ADD /out/artifacts/demo_jar/demo.jar /out/demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/out/demo.jar"]