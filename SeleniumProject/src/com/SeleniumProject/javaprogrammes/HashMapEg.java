package com.SeleniumProject.javaprogrammes;

import java.util.HashMap;
import java.util.Map;

public class HashMapEg {

	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new HashMap<>();
		
		hm.put(1, "January");
		hm.put(2, "February");
		hm.put(3, "March");
		hm.put(4, "April");
		hm.put(5, "May");
		hm.put(6, "June");
		
		System.out.println(hm.size());
		
		System.out.println(hm);
		
//		System.out.println(hm.get(3));
		
//		for (int i = 1; i <= hm.size(); i++) {
//			System.out.println(hm.get(i));
//			
//		}
		
//		System.out.println(hm.containsValue("Mayuskg"));
//		System.out.println(hm.containsKey(3));
		
		for (Map.Entry data : hm.entrySet()) {
			System.out.println(data);
			System.out.println(data.getKey() +"---"+ data.getValue());
		}
	}

}
