package main;

import javax.json.JsonArray;

import business.AccessCity;
import business.BuildCVSFile;

public class CreateCVSFile {

	public static void main(String[] args) {
		String city = args[0];
		JsonArray results = AccessCity.findCity(city);
		if(results.isEmpty())
			System.out.println("There is not any location with this name");
		else			
			BuildCVSFile.WriteCVS(results, city);
	}
}
