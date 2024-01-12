FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/institute_app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar institute_app.jar