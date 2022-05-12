FROM openjdk:18 as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN ./mvnw -B clean

RUN ./mvnw -B package

FROM openjdk:18

COPY --from=build target/HotelBooking-app-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "HotelBooking-app-0.0.1-SNAPSHOT.jar"]