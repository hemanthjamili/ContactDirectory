FROM adoptopenjdk/maven-openjdk11
RUN mkdir -p /app

WORKDIR /app
ADD ./target/contact-directory.jar contact-directory.jar

RUN mkdir -p /app/static
COPY ./src/main/webapp /app/static

ENTRYPOINT ["java", "-jar", "contact-directory.jar"]
EXPOSE 8080