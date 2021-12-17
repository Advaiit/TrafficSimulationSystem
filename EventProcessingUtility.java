import java.util.Random;

public class EventProcessingUtility {
	public static String requestToResponse(String request, EventQueue q) {
		Random random = new Random();
		
		boolean result = random.nextBoolean(); //TODO: Get from mongodb, @Hyun
		
		String response = request+", result: "+result+", queue_size: "+q.getSize();
		
		return response;
	}
}
