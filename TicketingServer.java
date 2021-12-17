public class TicketingServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue eq = new EventQueue();
		new Thread(new Listener(eq)).start();
		new Thread(new EventProcessor(eq)).start();
		System.out.println("Ticketing server started");
	}

}
