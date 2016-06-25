package ir.serajsamaneh.lms.model.barcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JSonUtility {

	public static String readFromJson(String cityCode) {
		JSONParser parser = new JSONParser();
		String city = "";
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\salari\\Desktop\\city.json"));
			JSONObject jsonObject = (JSONObject) obj;
			city = (String) jsonObject.get(cityCode);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			System.out.println("The City Is not Found!");
		}
		return city;
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
