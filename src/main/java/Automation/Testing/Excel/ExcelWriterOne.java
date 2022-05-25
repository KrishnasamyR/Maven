package Automation.Testing.Excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterOne {

	FileReader fileReader;

	ArrayList<String> fileReader() {

		BufferedReader bufferedReader = new BufferedReader(fileReader);

		ArrayList<String> arrayList = new ArrayList<>();

		String input = " ";

		try {
			while ((input = bufferedReader.readLine()) != null) {

				arrayList.add(input);
			}
		} catch (IOException exception) {
			System.out.println("" + exception);
			exception.printStackTrace();
		}
		return arrayList;

	}

	void writeToXlsxfile() throws Exception {

		ArrayList<String> listOfHeader = new ArrayList<String>();

		listOfHeader.add("Roll No");
		listOfHeader.add("Name");
		listOfHeader.add("Mark");
		listOfHeader.add("Result");

		Scanner scan = new Scanner(System.in);

		String path = System.getProperty("user.dir");

		String filePath = path + File.separator + "src" + File.separator + "main" + File.separator + "java"
				+ File.separator;

		System.out.println("Enter text File One : ");
		String fileOne = filePath + scan.nextLine();

		System.out.println("Enter text File Two : ");
		String fileTwo = filePath + scan.nextLine();

		System.out.println("Enter text File Three : ");
		String fileThree = filePath + scan.nextLine();

		fileReader = new FileReader(fileOne);
		ArrayList<String> arrayListOne = fileReader();
		System.out.println("StudentOne" + arrayListOne);

		fileReader = new FileReader(fileTwo);
		ArrayList<String> arrayListTwo = fileReader();
		System.out.println("StudentTwo" + arrayListTwo);

		fileReader = new FileReader(fileThree);
		ArrayList<String> arrayListThree = fileReader();
		System.out.println("StudentThree" + arrayListThree);

		System.out.println("Enter Excel File name ");
		String excelFile = scan.nextLine();
		scan.close();

		String filePathExcel = filePath + excelFile;

		System.out.println("ExcelFile path" + path);

		File file = new File(filePathExcel);

		FileInputStream fileInputStream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow row;

		Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

		map.put(filePath, listOfHeader);
		map.put("1", arrayListOne);
		map.put("2", arrayListTwo);
		map.put("3", arrayListThree);

		Set<String> set = map.keySet();

		int rowOne = 0;

		for (String string : set) {

			row = sheet.createRow(rowOne++);

			ArrayList<String> list = map.get(string);

			int cellOne = 0;

			for (Object object : list) {

				XSSFCell cell = row.createCell(cellOne++);
				cell.setCellValue((String) object);
			}

		}

		FileOutputStream fileOutputStream = new FileOutputStream(excelFile);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();

		System.out.println("XLsheet was writed Successfully");

	}

}
