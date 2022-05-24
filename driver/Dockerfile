FROM openjdk:8

WORKDIR /app
COPY ./target/driver.jar .
COPY ./src/main/resources/application*.properties ./


EXPOSE 8080

CMD java -Duser.timezone=UTC -Dspring.config.location=file:/app/ -Dapp.home.dir=/app -Dfile.encoding=UTF-8 -Xms64m -Xmx512m -server -jar /app/driver.jar
