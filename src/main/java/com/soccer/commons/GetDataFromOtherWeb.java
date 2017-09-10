package com.soccer.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetDataFromOtherWeb {
	public static JSONArray readJsonFromUrl(String url) throws IOException {
		// String s = URLEncoder.encode(url, "UTF-8");
		// URL url = new URL(s);
		InputStream is = new URL(url).openStream();
		JSONArray json = null;
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			json = new JSONArray(jsonText);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			is.close();
		}
		return json;
	}
	
	public static JSONObject readJsonObjectFromUrl(String url) throws IOException {
		// String s = URLEncoder.encode(url, "UTF-8");
		// URL url = new URL(s);
		InputStream is = new URL(url).openStream();
		JSONObject json = null;
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			json = new JSONObject(jsonText);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			is.close();
		}
		return json;
	}

	public static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
}
