import java.net.Socket;

public class Event {
	
	private String request;
	private Socket socket;

	public Event(String request, Socket socket) {
		super();
		this.request = request;
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
