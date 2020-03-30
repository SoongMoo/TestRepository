package DTO;

public class FileDTO {
	String year;
	String model;
	String price;
	String mileage;
	String color;
	String transmission;
	
	public FileDTO(String year, String model, String price, String mileage, String color, String transmission) {
		this.year = year;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.color = color;
		this.transmission = transmission;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
}
