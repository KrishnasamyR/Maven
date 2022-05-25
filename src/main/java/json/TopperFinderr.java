package json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TopperFinderr {

	String jsonFile;

	Scanner scanner = new Scanner(System.in);

	FileReader fileReader;

	String path;

	JSONObject jsonObjectOne;

	JSONArray jsonArray = new JSONArray();

	String rollNoOne, nameOne, MarkOne, ResultOne;

	ArrayList<String> list;

	ArrayList<String> stringStore;

	@SuppressWarnings("unchecked")
	public void writeToJsonFile() {

		System.out.println("Enter the File Name");
		jsonFile = scanner.next();

		String userPath = System.getProperty("user.dir");

		path = userPath + File.separator + jsonFile;

		FileWriter file = null;

		try {

			file = new FileWriter(path);

		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Enter total Student Count");

		int studentCount = scanner.nextInt();

		for (int index = 0; index < studentCount; index++) {

			jsonObjectOne = new JSONObject();

			System.out.println("Enter the rollNo: ");

			jsonObjectOne.put("student rollNo", scanner.next());

			System.out.println("Enter the name: ");

			jsonObjectOne.put("student name", scanner.next());

			System.out.println("Enter the mark: ");

			jsonObjectOne.put("student Mark", scanner.next());

			System.out.println("Enter the result: ");

			jsonObjectOne.put("student Result", scanner.next());

			System.out.println("Student MarkSheet: " + jsonObjectOne);

			jsonArray.add(jsonObjectOne);
		}

		try {

			file.write(jsonArray.toJSONString());
			file.close();

		} catch (IOException exp) {

			exp.printStackTrace();
		}

		System.out.println("JSON1 file created..... ");
	}

	public ArrayList<String> readJsonFile(int num) {

		JSONObject jsonObjectOne = new JSONObject();

		JSONParser jsonParser = new JSONParser();

		JSONArray jsonArray = new JSONArray();

		try {
			list = new ArrayList<String>();

			fileReader = new FileReader(path);

			jsonArray = (JSONArray) jsonParser.parse(fileReader);

			System.out.println(jsonArray);

			JSONObject jsonObjectTwo = (JSONObject) jsonArray.get(num);

			rollNoOne = (String) jsonObjectTwo.get("student rollNo");

			System.out.println("Student RollNo " + rollNoOne);

			nameOne = (String) jsonObjectTwo.get("student name");

			System.out.println("Student Name " + nameOne);

			MarkOne = (String) jsonObjectTwo.get("student Mark");

			System.out.println("Student Mark " + MarkOne);

			ResultOne = (String) jsonObjectTwo.get("student Result");

			System.out.println("Student Result " + ResultOne);

			list.add(rollNoOne);
			list.add(nameOne);
			list.add(MarkOne);
			list.add(ResultOne);
			System.out.println(list);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return list;
	}

	public void findTheTopperStudent() {

		ArrayList<String> arrayListOne = readJsonFile(0);

		String markOne = arrayListOne.get(2);

		int stringOne = Integer.parseInt(markOne);

		ArrayList<String> arrayListTwo = readJsonFile(1);

		String markTwo = arrayListTwo.get(2);

		int stringTwo = Integer.parseInt(markTwo);

		ArrayList<String> arrayListThree = readJsonFile(2);

		String markThree = arrayListThree.get(2);

		int stringThree = Integer.parseInt(markThree);

		ArrayList<String> arrayListFour = readJsonFile(3);

		String markFour = arrayListFour.get(2);

		int stringFour = Integer.parseInt(markFour);

		ArrayList<String> arrayListFive = readJsonFile(4);

		String markFive = arrayListFive.get(2);

		int stringFive = Integer.parseInt(markFive);

		TreeSet<String> set = new TreeSet<String>();

		set.add(markOne);
		set.add(markTwo);
		set.add(markThree);
		set.add(markFour);
		set.add(markFive);

		String compare = set.last();

		int string = Integer.parseInt(compare);

		System.out.println(set.last());

		stringStore = new ArrayList<String>();

		if (string == stringOne) {
			stringStore = arrayListOne;

		} else if (string == stringTwo) {
			stringStore = arrayListTwo;

		} else if (string == stringThree) {
			stringStore = arrayListThree;

		} else if (string == stringFour) {
			stringStore = arrayListFour;

		} else if (string == stringFive) {
			stringStore = arrayListFive;
		}

		System.out.println("Topper Mark " + stringStore);
	}

	public void writeToXlsxFile() {

		System.out.println("Enter Your File Name:");

		String exlfile = scanner.next();

		String filePath = System.getProperty("user.dir");

		System.out.println(filePath);

		path = filePath + File.separator + exlfile;

		System.out.println(path);

		File file = new File(path);

		try {

			FileInputStream fileInputStream = new FileInputStream(path);

			try {

				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

				XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet2");

				XSSFRow xssfRow;

				XSSFCell xssfCell;

				ArrayList<String> list = new ArrayList<String>();

				list.add("Roll Number");

				list.add("Name");

				list.add("Total Marks");

				list.add("Result");

				Map<String, ArrayList> map = new TreeMap<String, ArrayList>();

				map.put("0", list);

				map.put("1", stringStore);

				Set<String> set = map.keySet();

				int row = 0;

				for (String str : set) {

					xssfRow = xssfSheet.createRow(row++);

					ArrayList objArray = map.get(str);

					int cell = 0;

					for (Object obj : objArray) {

						xssfCell = xssfRow.createCell(cell++);

						xssfCell.setCellValue((String) obj);
					}
				}

				FileOutputStream fileOutputStream = new FileOutputStream(path);

				xssfWorkbook.write(fileOutputStream);

				fileOutputStream.close();

				System.out.println("File Successfully Created");

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}