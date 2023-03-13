package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiHandler {

	String apiKey = "130541cf0c72d66e30719ae7d981f794";
	
	public String getTodaysWeather(String cityInput, String countryInput) {

		String response;
		String city = cityInput;
		String country = countryInput;
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units=metric" + "&appid="
				+ apiKey;

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuilder builder = new StringBuilder();

			while ((output = br.readLine()) != null) {
				builder.append(output);
			}

			br.close();
			conn.disconnect();

			JSONObject jsonObj = new JSONObject(builder.toString());
			double temp = jsonObj.getJSONObject("main").getDouble("temp");
			String description = jsonObj.getJSONArray("weather").getJSONObject(0).getString("description");

			return response = "Current temperature in " + city + " is " + temp + " °C with " + description;

		} catch (Exception e) {

			return response = "Exception in OpenWeatherAPI: " + e;
		}
	}

	public String getTomorrowsWeather(String cityInput, String countryInput) {

		String response;
		String city = cityInput;
		String country = countryInput;
		String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city +","+ country + "&units=metric" +  "&appid=" + apiKey;

		try {
			
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;
			StringBuilder builder = new StringBuilder();
			
			while ((output = br.readLine()) != null) {
				builder.append(output);
			}
			
			br.close();
			conn.disconnect();
			
			JSONObject jsonObject = new JSONObject(builder.toString());
			JSONArray forecastList = jsonObject.getJSONArray("list");

			JSONObject tomorrowForecast = forecastList.getJSONObject(0);
			JSONObject main = tomorrowForecast.getJSONObject("main");
			double temperature = main.getDouble("temp");
			
			return response = "Tomorrow's temperature in " + city + " will be " + temperature + "°C";

		} catch (Exception e) {
			
			return response = "Exception in OpenWeatherAPI: " + e;
		}
	}

}
