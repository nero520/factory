package com.msds.km;

import com.google.gson.JsonArray;


public class Test {
	public static void main(String[] args) {
		JsonArray json = new JsonArray();
		String[] str = {"a","b","c"};
		System.out.println(json.getAsString());
	}
}
