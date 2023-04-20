package com.example.CurrencyDemo;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class CoindeskAPI {
	public CoindeskAPI() {
		
	}
	
	public JSONObject callCoindeskAPI() {
		OkHttpClient client = new OkHttpClient();
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		Request request = new Request.Builder().url(url).build();
		Call call = client.newCall(request);
		
		JSONObject json = new JSONObject();
		try (Response response = call.execute()) { 
			String strResponseBody = response.body().string();
			json = new JSONObject(strResponseBody);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
