package com.JaniceGuo.Dao;

import java.io.*;
import java.util.*;
import com.JaniceGuo.model.UserRecom;

public class ForRecom {
	public LinkedList<UserRecom> readCSV(String filePath) {
		File csv = new File(filePath); // CSV文件路径
		BufferedReader br = null;
		LinkedList<UserRecom> userRecoms = new LinkedList<UserRecom>();
		
		try {
			br = new BufferedReader(new FileReader(csv));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		String everyLine = "";
		try {
			List<String> allString = new ArrayList<String>();
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
				UserRecom userRecom = new UserRecom();
				everyLine = line;
				String[] cols = everyLine.split(",");
				// System.out.println(cols.length);
				userRecom.setUserid(cols[0]);
				userRecom.setScore(cols[2]);
				userRecom.setItemid(cols[1]);
				userRecoms.add(userRecom);

			}
			System.out.println("csv表格中所有行数：" + allString.size());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userRecoms;

	}
	
	public LinkedList<UserRecom> selectedForUser(LinkedList<UserRecom> userRecoms,String userid){
		LinkedList<UserRecom> newUserRecom=new LinkedList<UserRecom>();
		for (UserRecom userRecom:userRecoms) {
			if (userRecom.getUserid()==userid) {
				newUserRecom.add(userRecom);
			}
		}
		return newUserRecom;
		
		
	}
}
