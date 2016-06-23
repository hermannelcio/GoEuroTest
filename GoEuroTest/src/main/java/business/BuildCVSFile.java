package business;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.JsonArray;
import javax.json.JsonObject;

import useful.Constants;

public class BuildCVSFile {
	
	public static void WriteCVS (JsonArray results, String city){
		
		FileWriter cvsWriter = null;
		
		try {
	
			cvsWriter = new FileWriter( Constants.PATH_FILE + Constants.FILE_SEPARATOR + "GoEuro_" + city + ".cvs");
			cvsWriter.append(Constants.CVS_HEAD.toString());
			
			for (JsonObject result : results.getValuesAs(JsonObject.class)) {
				cvsWriter.append(Constants.NEW_LINE);
				cvsWriter.append(String.valueOf(result.getInt("_id")));
				cvsWriter.append(Constants.COMMA);
				cvsWriter.append(result.getString("name"));
				cvsWriter.append(Constants.COMMA);
				cvsWriter.append(result.getString("type"));
				cvsWriter.append(Constants.COMMA);
				cvsWriter.append(String.valueOf(result.getJsonObject("geo_position").getJsonNumber("latitude")));
				cvsWriter.append(Constants.COMMA);
				cvsWriter.append(String.valueOf(result.getJsonObject("geo_position").getJsonNumber("longitude")));
			}
			
			System.out.println("CSV file was created successfully.");
			
		} catch (IOException e) {
			System.out.println("Error in WriteCVS.");
			e.printStackTrace();
		} finally {
			try {
				cvsWriter.flush();
				cvsWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter.");
				e.printStackTrace();
			}
	      
		}
	
	}

}
