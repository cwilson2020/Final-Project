package pkg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;






public class JParser {

	public JParser() {

	}


	public void writeRecord() {

		JSONObject record1 = new JSONObject();
		JSONObject record2 = new JSONObject();
		JSONObject holder1 = new JSONObject();
		JSONObject holder2 = new JSONObject();
		record1.put("firstname", "mike");
		record1.put("LastName", "Manes");
		record2.put("firstname", "Jessica");
		record2.put("LastName", "Welkes");

		//	order.put("no", "66");

		//JSONArray list = new JSONArray();
		//list.put(record);
		//	list.put(order);
		holder1.put("person", record1);
		holder2.put("person", record2);
		try {
			FileWriter file = new FileWriter("C://Users//user//Desktop//database.txt");
			//file.write(list.toString());

			//file.append(holder1.toJSONString());
			JSONArray ja = new JSONArray();
			ja.put(record1);
			//ja.put(holder2);
Gson gson;

			file.write(record1.toJSONString());
			file.append(record2.toJSONString());
			file.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	public void readRecord() {
		String location = "C://Users//user//Desktop//database.txt";
		Gson gson = new Gson();
		
		String contents = null;
		Files f;
		try {
			contents = new String ((Files.readAllBytes(Paths.get(location))));
			System.out.println(contents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(contents);
		
		JsonElement e = gson.fromJson(contents, JsonElement.class);
	JsonObject jo = e.getAsJsonObject();
	String result = jo.get("firstname").toString();
	
System.out.println(result);

	}
	
	public void readLine() {
		int linecount=0;
		try {
			FileReader fr = new FileReader("C://Users//user//Desktop//database.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) !=null){
				++linecount;
				System.out.println(linecount + " "+ line);
				
			}
				
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		}
		
	
	
		public void readbychar() {
		int charCount=0;
		try {
			FileReader fr = new FileReader("C://Users//user//Desktop//database.txt");
			int ch;
			while((ch=fr.read()) !=-1){
				System.out.println(++charCount +": " + (char)ch);
				
			
				
			}
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}