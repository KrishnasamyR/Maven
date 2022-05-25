package json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFile {
	
	Scanner scanner = new Scanner(System.in);
	
	String filePath;
	String id;
	String name;
	String role;

	JSONObject jsonObject;

	@SuppressWarnings("unchecked")
	void writeJson() throws Exception {
		
		System.out.println("Enter the file Name:");
		
		String fileName = scanner.next();

		String path = System.getProperty("user.dir");

		filePath = path + File.separator + fileName;
		
		System.out.println(filePath);

		jsonObject = new JSONObject();

		System.out.println("Enter emp id : ");

		jsonObject.put("employeeId", scanner.next());

		System.out.println("Enter text emp name : ");

		jsonObject.put("employeeName", scanner.next());

		System.out.println("Enter emp role : ");

		jsonObject.put("employeeRole", scanner.next());

		// System.out.println("Enter Json File : ");

		FileWriter fileWriter = new FileWriter(filePath);

		fileWriter.write(jsonObject.toString());

		fileWriter.flush();
		fileWriter.close();

		// scanner.close();

		System.out.println("file created successfully");
	}

	void readJson() throws Exception, ParseException {

		JSONParser jsonParser = new JSONParser();

		FileReader fileReader = new FileReader(filePath);

		System.out.println(fileReader);

		Object parsedObject = jsonParser.parse(fileReader);

		jsonObject = (JSONObject) parsedObject;

		id = (String) jsonObject.get("employeeId");

		name = (String) jsonObject.get("employeeName");

		role = (String) jsonObject.get("employeeRole");

		System.out.println("EmployeeID : " + id);
		System.out.println("EmployeeName : " + name);
		System.out.println("EmployeeRole : " + role);

	}

	void writeExcel() throws IOException {
		List<String> listOne = new ArrayList<String>();
		listOne.add("EmployeeId");
		listOne.add("EmployeeName");
		listOne.add("EmployeeRole");
		System.out.println(listOne);

		List<String> listTwo = new ArrayList<String>();
		listTwo.add(id);
		listTwo.add(name);
		listTwo.add(role);
		System.out.println(listTwo);

		String filenameOne;

		System.out.println("Enter the Excel File Name ");

		filenameOne = scanner.next();

		String userWorkingDirectory = System.getProperty("user.dir");

		filePath = userWorkingDirectory + File.separator + filenameOne;

		FileInputStream out = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("EmployeeData");

		XSSFRow row;

		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		map.put("1", listOne);
		map.put("2", listTwo);

		Set<String> keyid = map.keySet();
		int rowid = 0;

		for (String key : keyid) {

			row = sheet.createRow(rowid++);
			List<String> objectArr = map.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				XSSFCell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}

			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

		}
		
		System.out.println("Excel created");
	}
}
