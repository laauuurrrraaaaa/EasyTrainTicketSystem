package models;

public class Ticket {
	private String ticketid;
	private String trainid;
	private String carNo;
	private String seatNo;
	private String price;
	private String available;
	
	//ticket id
	public String getTicketid() {
		return ticketid;
	}
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}
	
	//train id
	public String getTrainid() {
		return trainid;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	
	
	//car number
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	//seat number
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	
	//price
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
		
	
	//availablity
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	

}
