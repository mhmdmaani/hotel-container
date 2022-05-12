FROM openjdk:18
COPY ./target/app-0.0.1-SNAPSHOT.jar /usr/src/HotelBookingReciever/
WORKDIR /usr/src/HotelBookingReciever

EXPOSE 8080
ENTRYPOINT ["java","-jar", "app-0.0.1-SNAPSHOT.jar"]
