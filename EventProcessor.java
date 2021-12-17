import java.io.PrintWriter;
import java.net.Socket;

public class EventProcessor implements Runnable{
	
	private EventQueue q;
	private boolean isRunning;
	
	EventProcessor(EventQueue q) {
		this.q = q;
		isRunning = false;
	}
	
	public void run() {
		isRunning = true;
		
		System.out.println("Starting Event Processor...");
		
		while(isRunning) {
			//you are accessing queue
			Event e = null;
			synchronized (q) {
				e = q.popEvent();
			}
			
			if(e == null) {
				//sleep for 10ms
				try {
					Thread.sleep(10);
					continue;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//leaving access to the queue
			
			String request = e.getRequest();
			Socket socket = e.getSocket();
			
			String response = EventProcessingUtility.requestToResponse(request, q);
			
			try {				
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println(response);
//				out.close();
//				socket.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void stop() {
		isRunning = false;
	}
}
