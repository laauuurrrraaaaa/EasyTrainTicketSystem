package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.BuyTicket;
import models.Ticket;
import models.Train;
import Dao.Connect;
 
public class BuyTicketDao {
	
	//插入
		public static int insert(BuyTicket buy) throws Exception {
			Ticket ticket = new Ticket();

			String sql = "insert into BuyTicket (userid, ticketid, trainid, price ) " +
					"values ('" + buy.getUserid() +"','"+ buy.getTicketid() +"','"+ buy.getTrainid() +
					"','"+ buy.getPrice()+"')";
			System.out.println(sql);
			return Connect.executeUpdate(sql);
		
		}
//	//插入购买车票
//		public static int insert(BuyTicket buy) throws Exception {
//			String sql = "INSERT INTO BuyTicket (userid, ticketid, trainid, departPlace, arrivePlace, price ) " +
//					"VALUES ('" + buy.getUserid() +"','"+ buy.getTicketid() +"','"+ buy.getTrainid() +
//					"','"+ buy.getDepartPlace()+"','"+ buy.getArrivePlace() +"','"+ buy.getPrice()+"') select User.userid,Ticket.ticketid,Train.trainid,departPlace,arrivePlace,price from User,Ticket,Train where Train.trainid = Ticket.trainid";
//			System.out.println(sql);
//			return Connect.executeUpdate(sql);
//		
//		}
	
//	//插入购买车票
//	public static int insert(BuyTicket buy) throws Exception {
//		String sql = "INSERT INTO BuyTicket (userid, ticketid, trainid, departPlace, arrivePlace, price ) " +
//				"VALUES ('" + buy.getUserid() +"','"+ buy.getTicketid() +"','"+ buy.getTrainid() +
//				"','"+ buy.getDepartPlace()+"','"+ buy.getArrivePlace() +"','"+ buy.getPrice()+"') where BuyTicket.ticketid = Ticket.ticketid.";
//		System.out.println(sql);
//		return Connect.executeUpdate(sql);
//	
//	}
	
	//更新
	public static int update(Ticket ticket) throws Exception {
		String sql = "UPDATE Ticket SET available = '无' WHERE ticketid = ? ";
		return Connect.executeUpdate(sql, ticket.getAvailable(), ticket.getTicketid());
	}
//	
//
	//删除
	public static int delete(String id) throws Exception {
		String sql = "delete from BuyTicket where ticketid = ? ";
		return Connect.executeUpdate(sql, id);
	}
	
	//查找
	public static Ticket find(String id) throws Exception {
		String sql = "select * from Ticket where ticketid = ?";
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {

			conn = Connect.getConnection(); //连接默认数据库
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, id);
			rs = preStmt.executeQuery();
			
			if (rs.next()) {
				Ticket ticket = new Ticket();

				ticket.setTicketid(rs.getString("ticketid"));
				ticket.setTrainid(rs.getString("trainid"));
				ticket.setCarNo(rs.getString("carNo"));
				ticket.setSeatNo(rs.getString("seatNo"));
				ticket.setAvailable(rs.getString("available"));
				
				return ticket;
			} else {
				return null;
			}
		} finally { 
			if (rs != null)
				rs.close();
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
	}
	
	//按火车车次查找
	public static List<Ticket> findByTrain(String trainid) throws Exception {
		List<Ticket> list = new ArrayList<Ticket>();
		String sql = null; 
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		//sql
		if(trainid == "") {
			sql = "select * from Ticket;";
		}else {
			sql = "select * from Ticket where trainid = '" 
					+ trainid + "' ;"; 
		}
		
		try {
			
			conn = Connect.getConnection(); 
			statement = conn.createStatement();
			System.out.println(trainid);
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Ticket ticket = new Ticket();

				ticket.setTicketid(rs.getString("ticketid"));
				ticket.setTrainid(rs.getString("trainid"));
				ticket.setCarNo(rs.getString("carNo"));
				ticket.setSeatNo(rs.getString("seatNo"));
				ticket.setAvailable(rs.getString("available"));
				list.add(ticket);
			}
		} catch (Exception e) {
			System.out.println("错误："+e.getMessage());  
		}
		finally { 
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}
	
	//查询所有车次信息
	public static List<BuyTicket> listbuying() throws Exception {
		List<BuyTicket> list = new ArrayList<BuyTicket>();
		String sql = "SELECT * FROM BuyTicket";
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = Connect.getConnection();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				
				BuyTicket buy = new BuyTicket();
				buy.setUserid(rs.getString("userid")); 
				buy.setTicketid(rs.getString("ticketid")); 
				buy.setTrainid(rs.getString("trainid"));      
//				buy.setDepartPlace(rs.getString("departPlace"));
//				buy.setArrivePlace(rs.getString("arrivePlace"));
				buy.setPrice(rs.getString("price"));
				list.add(buy);
			}	
		} finally {
			if (rs != null)
				rs.close();
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}
}

