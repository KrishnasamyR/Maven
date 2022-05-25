package json;

public class TopperFinderRunner {
	
	public static void main(String[] args) {
		
		TopperFinder finder = new TopperFinder();
		
		try {
			
			finder.writeToJsonFile();
			
			finder.readJsonFile();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}
