package ua.org.gdg.cherkasy.hackathon.askme.translation

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;

public class GoogleTranslator implements Translator {

	@Override
	public TextEntry translate(String toLanguage, TextEntry origin) {
		HttpURLConnection connection = null;
		try {
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder
					.append("http://translate.google.ru/translate_a/t?client=x&text=");
			urlBuilder.append(URLEncoder.encode(origin.getText(), "UTF-8"));
			urlBuilder.append("&hl=en&sl=");
			urlBuilder.append(origin.getLanguage());
			urlBuilder.append("&tl=");
			urlBuilder.append(toLanguage);

			//System.out.println("Request: " + urlBuilder.toString());
			URL url = new URL(urlBuilder.toString());

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection
					.setRequestProperty(
							"User-Agent",
							"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.202 Safari/535.1");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setRequestProperty("Content-Type",
					"text/plain; charset=UTF-8");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;

			StringBuilder jsonBuilder = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				jsonBuilder.append(line);
			}
			reader.close();

			//System.out.println("Response: " + jsonBuilder.toString());

			Gson gson = new Gson();
			Map<String, Object> data = (Map<String, Object>) gson.fromJson(
					jsonBuilder.toString(), Map.class);
			String src = (String) data.get("src");
			ArrayList sentences = (ArrayList) data.get("sentences");
			StringBuilder transBuilder = new StringBuilder();
			StringBuilder origBuilder = new StringBuilder();
			StringBuilder translitBuilder = new StringBuilder();
			for (int i = 0; i < sentences.size(); i++) {
				if (i > 0) {
					transBuilder.append(" ");
					origBuilder.append(" ");
					translitBuilder.append(" ");
				}
				Map<String, String> sentence = (Map<String, String>) sentences
						.get(i);
				transBuilder.append(sentence.get("trans").trim());
				origBuilder.append(sentence.get("orig").trim());
				translitBuilder.append(sentence.get("translit").trim());
			}
			return new TextEntry(src, toLanguage, origBuilder.toString(),
					transBuilder.toString(), translitBuilder.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		}
		return origin;
	}

}
