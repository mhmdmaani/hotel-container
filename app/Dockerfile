FROM openjdk:18
COPY ./target/HotelBooking-app-0.0.1-SNAPSHOT.jar /usr/src/HotelBooking/
WORKDIR /usr/src/HotelBooking
EXPOSE 8080
ENTRYPOINT ["java","-jar", "HotelBooking-app-0.0.1-SNAPSHOT.jar"]