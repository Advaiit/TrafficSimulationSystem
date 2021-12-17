#base image
FROM openjdk:11
COPY . /home/dsdoptimize/TrafficViolationSystem
WORKDIR /home/dsdoptimize/TrafficViolationSystem
RUN ["javac", "Event.java EventQueue.java EventProcessingUtility.java EventProcessor.java Listener.java TicketingServer.java"]
ENTRYPOINT ["java", "TicketingServer"]
