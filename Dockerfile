#base image
FROM openjdk:11
COPY . /home/dsdoptimize/TrafficViolationSystem
WORKDIR /home/dsdoptimize/TrafficViolationSystem
RUN ["javac", "Event.java"]
RUN ["javac", "EventQueue.java"]
RUN ["javac", "EventProcessingUtility.java"]
RUN ["javac", "EventProcessor.java"]
RUN ["javac", "Listener.java"]
RUN ["javac", "TicketingServer.java"]
ENTRYPOINT ["java", "TicketingServer"]
