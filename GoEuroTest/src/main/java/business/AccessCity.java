package business;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

import useful.Constants;

/**
 * Class that is duty to get the data of a city given
 * 
 * @author Hermann Gruber
 *
 */
public class AccessCity {
	
	/**
	 * Method that builds a URL to access a city given.
	 * 
	 * @param city
	 * @return
	 */
	public static JsonArray findCity (String city) {
		URL url = null;
		
		try {
			url = new URL(Constants.CITY_WEB_PATH + city);
		} catch (MalformedURLException e) {
			System.out.println("It was not possible to write the URL");
			e.printStackTrace();
		}
		
		return readJson(url);
	}

	/**
	 * Method that access' on the internet any Json code  
	 * and returns its array
	 * 
	 * @param url
	 * @return
	 */
	private static JsonArray readJson(URL url) {
		JsonArray results = null;
		
		try (InputStream is = url.openStream(); 
			JsonReader rdr = Json.createReader(is)) {
				
				results = rdr.readArray();
				
		} catch (IOException e) {
			System.out.println("It were not possible to access or read this source");
			e.printStackTrace();
		}
		return results;
	}

}
