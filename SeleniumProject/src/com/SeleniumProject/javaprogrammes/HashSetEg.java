package com.SeleniumProject.javaprogrammes;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEg {

	public static void main(String[] args) {
		
		HashSet<String> h = new HashSet<>();
		
		h.add("Selenium");
		h.add("boll");
		h.add("Apple");
		h.add("uft");
		h.add("Manual");
		h.add("boll");
		
		h.clear();
//		h.remove("Apple");
		
		Iterator<String> it = h.iterator();
		
		while(it.hasNext())
		{
			String data = it.next();
			System.out.println(data);
		}
		
//		for (String data : h)
//		{
//			System.out.println(data);
//		}

	}

}
