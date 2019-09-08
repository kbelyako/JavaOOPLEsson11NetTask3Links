package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class LinksFromURL {
	
	private String url;
	private String filename;
	private int e;
	
	
	
	
	public LinksFromURL(String url, String filename) {
		super();
		this.url = url;
		this.filename = filename;
		
		stringToFile(getLinksFromURL(url), this.filename);		
		
	}

	private static void stringToFile(String txt, String fileName) {

		try (PrintWriter a = new PrintWriter(fileName)) {
			a.println(txt);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			// System.out.println("ERROR FILE WRITE");
		}

	}
	
	private static String getStringFromURL(String urlAddress) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlAddress);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb.toString();
	}
	
	private static String getLinksFromURL(String urlAddress) {
		String text=getStringFromURL(urlAddress);
		int start = 0;
		String tmp = "";
		int end = 0;
		String result = "";
		while (start != -1) {
			start = text.indexOf("<a", start);
			end = text.indexOf("</a", start);
			//System.out.println(text.indexOf("<a"));
			//System.out.println(text.indexOf("</a"));
			if (end==-1 || start==-1) break;
		//	System.out.println(text.substring(start, end));
			tmp = text.substring(start, end);
			result += tmp+"\n";
			int length=end-start;
			start += length;
			
		}

		return result;

	}

}


