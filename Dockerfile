#base image
FROM openjdk:11
COPY . /home/dsdoptimize/TrafficViolationSystem
WORKDIR /home/dsdoptimize/TrafficViolationSystem
RUN ["javac", "*.java"]
ENTRYPOINT ["java", "TicketingServer"]
