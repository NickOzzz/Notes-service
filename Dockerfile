FROM hypriot/rpi-java

ADD /out/artifacts/demo_jar/demo.jar /out/demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/out/.jar"]