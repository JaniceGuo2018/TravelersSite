package com.JaniceGuo.model;

public class Site {
	
	
	private String name;
	//int s=0;
	/*char[] c=name.toCharArray();
	for (int i=0;i<c.length;i++) {
		s=s+(int)c[i];
	}
	System.out.println(s);*/
	private String price;
	private String image;
	private float rating;
	private String description;
	private String location;
	
	private String username;
	private String cat;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}

	
	
	
	
	
}
