package ir.serajsamaneh.lms.model.barcode;

import java.io.FileWriter;
import java.io.IOException;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class JSonUtility {

	public static void main(String[] args) {
		//insertToJSon();
		readFromJson();
	}
	
	public static void readFromJson(){
		
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("C:\\Users\\salari\\Desktop\\test.json"));

			JSONObject jsonObject = (JSONObject) obj;

			Integer code = (Integer) jsonObject.get("code");
			System.out.println(code);

			String city = (String) jsonObject.get("city");
			System.out.println(city);

			// loop array
		/*	JSONArray msg = (JSONArray) jsonObject.get("messages");
			Iterator<Object> iterator = msg.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}*/

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void insertToJSon() {
		JSONObject obj = new JSONObject();
		obj.put("name", "mkyong.com");
		obj.put("age", new Integer(100));

		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");

		obj.put("messages", list);

		try {

			FileWriter file = new FileWriter("C:\\Users\\salari\\Desktop\\test.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);
	}

}
