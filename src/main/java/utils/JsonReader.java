package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.FileReader;
import java.io.IOException;

public class JsonReader implements ReadData{

	@Override
	public Object[][] readData(String fileName) throws IOException {
		// TODO Auto-generated method stub

		FileReader reader = new FileReader("./data/"+fileName+".json");
		JSONTokener tokener = new JSONTokener(reader);
		org.json.JSONArray jsonArray = new JSONArray(tokener);
		int rows = jsonArray.length();
		int columns = jsonArray.getJSONObject(0).keySet().size();
		Object[][] data = new Object[rows][columns];
		int j=0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			for (String key : jsonObject.keySet())
				if(j<columns) data[i][j++] = jsonObject.get(key);
		}
		return data;
	}

}
