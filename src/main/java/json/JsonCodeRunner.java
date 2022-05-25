package json;

public class JsonCodeRunner {

	public static void main(String[] args) throws Exception {

			JsonFile jasonFile = new JsonFile();
			
			jasonFile.writeJson();
			jasonFile.readJson();
			jasonFile.writeExcel();

	}

}
