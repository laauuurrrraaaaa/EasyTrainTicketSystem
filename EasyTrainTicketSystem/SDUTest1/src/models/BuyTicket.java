package models;

public class BuyTicket {
	private String orderNo;
	private String ticketid;
	private String trainid;
	private String departPlace;
	private String arrivePlace;
	private String price;
	private String userid;
	
//	//order number
//	public String getOrderNo() {
//		return orderNo;
//	}
//	public void setOrderNo(String orderNo) {
//		this.orderNo = orderNo;
//	}
	
	//user id
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	//ticket ID
	public String getTicketid() {
		return ticketid;
	}
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}
	
	//train ID
	public String getTrainid() {
		return trainid;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	
//	//depart place
//	public String getDepartPlace() {
//		return departPlace;
//	}
//	public void setDepartPlace(String departPlace) {
//		this.departPlace = departPlace;
//	}
//	
//	//arrive place
//	public String getArrivePlace() {
//		return arrivePlace;
//	}
//	public void setArrivePlace(String arrivePlace) {
//		this.arrivePlace = arrivePlace;
//	}
//	
	//ticket price
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
