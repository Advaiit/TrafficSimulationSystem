import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class EventQueue {

	private Queue<Event> eventQueue;
	private int maxSize;
	
	EventQueue() {
		maxSize = 100;
		eventQueue = new LinkedList<Event>();
	}
	
	EventQueue(int maxSize) {
		this.maxSize = maxSize; 
	}
	
	public boolean pushEvent(Event e)
	{
		if(eventQueue.size() > maxSize)
			return false;
		
		return eventQueue.add(e);
	}
	
	public Event popEvent()
	{
		if(eventQueue.size() == 0)
			return null;
		
		Event e = null;
		try {
			e = eventQueue.remove(); 
		}
		catch(Exception ex) {
			return null;
		} 
		
		return e;
	}
	
	public int getSize() {
		return eventQueue.size();
	}
	
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}
