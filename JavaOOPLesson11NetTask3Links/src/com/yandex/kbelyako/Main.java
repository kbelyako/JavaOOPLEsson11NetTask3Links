package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	public static void main(String[] args) {

		String urlAddress = "https://prog.kiev.ua/forum/index.php/board,2.0.html";

	
		LinksFromURL testClas1s = new LinksFromURL(urlAddress, "result1.html");

	}

}
