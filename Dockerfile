#base image
FROM openjdk:11
COPY . /src/java
WORKDIR /src/java
RUN ["javac", "*.java"]
ENTRYPOINT ["java", "TicketingServer"]
