FROM maven:3.3.9-jdk-8
RUN mvn -f ./app/pom.xml install

WORKDIR /app
RUN  mvn clean package

WORkDIR /hotel-receiver
RUN mvn clean package
