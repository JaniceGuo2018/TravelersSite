package com.JaniceGuo.Dao;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.JaniceGuo.model.UserRecom;


public class appTest {
	public static void main(String[] args) {
		ForRecom forRecom=new ForRecom();
		LinkedList<UserRecom> userRecoms=forRecom.readCSV("d://writers.csv");
		ListIterator<UserRecom> it=(ListIterator<UserRecom>) userRecoms.listIterator();
		while(it.hasNext()) {
			UserRecom userRecom=it.next();
			System.out.println(userRecom.getScore());
			
		}
//		for (String i:allString) {
//			System.out.println(i);
//		}
	}
}
