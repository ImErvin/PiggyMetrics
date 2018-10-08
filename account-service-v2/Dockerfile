FROM java:8-jre
MAINTAINER Ervin Mamutov <ervin.manutov@ericsson.com>

VOLUME /tmp
ARG JAR_FILE
COPY ./${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar", "-Djava.net.preferIPv4Stack=true", "-Djboss.socket.binding.port-offset=100"]

EXPOSE 8080