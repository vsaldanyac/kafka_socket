FROM openjdk:8

WORKDIR /app
COPY ./target/camera.jar .
COPY ./src/main/resources/application*.properties ./


EXPOSE 8090


CMD java -Duser.timezone=UTC -Dspring.config.location=file:/app/ -Dapp.home.dir=/app -Dfile.encoding=UTF-8 -Xms64m -Xmx512m -server -jar /app/camera.jar