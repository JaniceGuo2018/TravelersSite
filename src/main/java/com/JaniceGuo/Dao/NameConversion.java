package com.JaniceGuo.Dao;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class NameConversion {
	public static int convertName(String name) {
		int s = 0;
		char[] c = name.toCharArray();
		for (int i = 0; i < c.length; i++) {
			s = s + (int) c[i];
		}
		return s;
	}
}
