FROM openjdk:17-jdk-alpine as builder

WORKDIR /app

COPY ./target/reserva-salas-0.0.1-SNAPSHOT.jar /app/

FROM builder

WORKDIR /application

COPY --from=builder /app/*jar /application/

EXPOSE 9191

ENTRYPOINT ["java","-jar","/application/reserva-salas-0.0.1-SNAPSHOT.jar"]

