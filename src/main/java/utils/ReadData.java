package utils;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface ReadData {
	
	public Object[][] readData(String fileName) throws IOException, ParseException;

}
