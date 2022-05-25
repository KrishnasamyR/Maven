package json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class TopperFinder {

	Scanner scanner = new Scanner(System.in);

	String filePath;
	
	String rollNumber, name, mark, result;

	void writeToJsonFile() throws Exception {

		String path = System.getProperty("user.dir");

		System.out.println("Enter the file name");

		String jsonfile = scanner.next();

		filePath = path + File.separator + jsonfile;

		JSONObject jsonObjectOne = new JSONObject();

		System.out.println("Student one Details");

		System.out.println("Enter RollNumber : ");

		jsonObjectOne.put("rollNumber", scanner.next());

		System.out.println("Enter student  name : ");

		jsonObjectOne.put("studentName", scanner.next());

		System.out.println("Enter total mark : ");

		jsonObjectOne.put("totalMark", scanner.next());

		System.out.println("Enter result : ");

		jsonObjectOne.put("result", scanner.next());
		
		

		JSONObject jsonObjectTwo = new JSONObject();

		System.out.println("Student two Details");

		System.out.println("Enter RollNumber : ");

		jsonObjectTwo.put("rollNumber", scanner.next());

		System.out.println("Enter student  name : ");

		jsonObjectTwo.put("studentName", scanner.next());

		System.out.println("Enter total mark : ");

		jsonObjectTwo.put("totalMark", scanner.next());

		System.out.println("Enter result : ");

		jsonObjectTwo.put("result", scanner.next());
		
		

		JSONObject jsonObjectThree = new JSONObject();

		System.out.println("Student three Details");

		System.out.println("Enter RollNumber : ");

		jsonObjectThree.put("rollNumber", scanner.next());

		System.out.println("Enter student  name : ");

		jsonObjectThree.put("studentName", scanner.next());

		System.out.println("Enter total mark : ");

		jsonObjectThree.put("totalMark", scanner.next());

		System.out.println("Enter result : ");

		jsonObjectThree.put("result", scanner.next());
		
		

		JSONObject jsonObjectFour = new JSONObject();

		System.out.println("Student four Details");

		System.out.println("Enter RollNumber : ");

		jsonObjectFour.put("rollNumber", scanner.next());

		System.out.println("Enter student  name : ");

		jsonObjectFour.put("studentName", scanner.next());

		System.out.println("Enter total mark : ");

		jsonObjectFour.put("totalMark", scanner.next());

		System.out.println("Enter result : ");

		jsonObjectFour.put("result", scanner.next());

		JSONObject jsonObjectFive = new JSONObject();

		System.out.println("Student five Details");

		System.out.println("Enter RollNumber : ");

		jsonObjectFive.put("rollNumber", scanner.next());

		System.out.println("Enter student  name : ");

		jsonObjectFive.put("studentName", scanner.next());

		System.out.println("Enter total mark : ");

		jsonObjectFive.put("totalMark", scanner.next());

		System.out.println("Enter result : ");

		jsonObjectFive.put("result", scanner.next());

		JSONArray jArray = new JSONArray();

		jArray.put(jsonObjectOne);
		jArray.put(jsonObjectTwo);
		jArray.put(jsonObjectThree);
		jArray.put(jsonObjectFour);
		jArray.put(jsonObjectFive);

		FileWriter fileWriter = new FileWriter(filePath);

		fileWriter.write(jArray.toString());

		fileWriter.flush();
		fileWriter.close();

		scanner.close();

		System.out.println("file created successfully");
	}

	@SuppressWarnings("null")
	void readJsonFile() throws Exception, ParseException {

		JSONParser jsonParser = new JSONParser();

		FileReader fileReader = new FileReader(filePath);

		System.out.println(fileReader);

		Object parsedObject = jsonParser.parse(fileReader);

		JSONObject jsonObject = (JSONObject) parsedObject;

		rollNumber = (String) jsonObject.get("RollNumber");

		name = (String) jsonObject.get("studentName");

		mark = (String) jsonObject.get("studentMark");

		result = (String) jsonObject.get("studentResult");

		System.out.println("EmployeeID : " + rollNumber);
		System.out.println("EmployeeName : " + name);
		System.out.println("EmployeeRole : " + mark);
		System.out.println("EmployeeRole : " + result);
		
		ArrayList<String> list = null;
		list.add(rollNumber);
		list.add(name);
		list.add(mark);
		list.add(result);
		System.out.println(list);
		
	}
	
}