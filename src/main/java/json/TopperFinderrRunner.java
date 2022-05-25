package json;

public class TopperFinderrRunner {

	public static void main(String[] args) {

		TopperFinderr topperFinder = new TopperFinderr();

		topperFinder.writeToJsonFile();
		topperFinder.findTheTopperStudent();
		topperFinder.writeToXlsxFile();
	}

}
