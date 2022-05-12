package com.HotelBooking.app.model;


import javax.persistence.*;
import java.util.List;


@Entity

public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String tel;
	private String address;
	private String email;
	private String website;
	private double lng;
	private double lat;
	private String image;

	@OneToMany
	private List<Room> rooms;

	@OneToMany
	private List<Staff> staffs;

	@OneToMany
	private  List<Extra> extras;

	@ManyToMany
	private List<HotelCategory> categories;

	@OneToMany
	private  List<Payment> payments;

	public Hotel() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public double getLng() {
		return lng;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}



}

