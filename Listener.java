import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener  implements Runnable{
	
	 private EventQueue q;
	 private boolean isRunning;
	
	 public Listener(EventQueue q)
	 {
		this.q = q;
		isRunning = false;
	 }
	
	public void run() {

    ServerSocket serverSocket;
	try {
			serverSocket = new ServerSocket(9999);
			BufferedReader bufferedReader;
			String request;
		
			isRunning = true;
			
			System.out.println("Starting Listener...");
   
			while (serverSocket.isClosed() == false && isRunning == true) {
				Socket socket=serverSocket.accept();
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				request=bufferedReader.readLine();		
				Event e=new Event(request,socket);
				
				int count = 10;
				boolean success = false;
				synchronized(q) {
					success = q.pushEvent(e);
				}
				while(success == true && count > 0) {
					try {
						synchronized(q) {
							success = q.pushEvent(e);
						}
						Thread.sleep(10);
						count--;
						//Fails silently after 10 attempts
						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
//			serverSocket.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	public void stopListener()
	 {
		isRunning = false;
	 }
}
