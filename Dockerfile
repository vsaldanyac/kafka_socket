FROM openjdk:8

COPY . /app
COPY src/main/resources/application*.properties ./app
WORKDIR /app

EXPOSE 8080

CMD ["java", "-Duser.timezone=UTC", "-Dspring.config.location=file:/usr/src/app/", "-Dfile.encoding=UTF-8", "-Xms64m", "-Xmx512m", "-jar /app/driver.jar"]
