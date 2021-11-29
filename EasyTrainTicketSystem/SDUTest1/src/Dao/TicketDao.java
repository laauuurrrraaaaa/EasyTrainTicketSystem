package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Ticket;

public class TicketDao {
	//插入车票
		public static int insert(Ticket ticket) throws Exception {
			String sql = "insert into Ticket (ticketid, trainid, carNo, seatNo, price, available) " +
					"values ('" + ticket.getTicketid() +"','"+ ticket.getTrainid() +"','"+ ticket.getCarNo() +
					"','"+  ticket.getSeatNo() + "','" + ticket.getPrice() + "','" + ticket.getAvailable() +"');";
			System.out.println(sql);
			return Connect.executeUpdate(sql);
		
		}
		
		//更新车票
		public static int update(Ticket ticket) throws Exception {
			String sql = "update Ticket set trainid = ?, carNo = ?, seatNo = ?, price = ?, available = ? where ticketid = ? ";
			return Connect.executeUpdate(sql, ticket.getTrainid(), ticket.getCarNo(), ticket.getSeatNo(), ticket.getPrice(), ticket.getAvailable(), ticket.getTicketid());
		}
		

		//删除
		public static int delete(String id) throws Exception {
			String sql = "delete from Ticket where ticketid = ? ";
			return Connect.executeUpdate(sql, id);
		}
		
		//查找车票
		public static Ticket find(String id) throws Exception {
			String sql = "select * from Ticket where ticketid = ? ";
			Connection conn = null;
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			try {
				
				conn = Connect.getConnection(); 
				preStmt = conn.prepareStatement(sql);
				preStmt.setString(1, id);
				rs = preStmt.executeQuery();
				
				if (rs.next()) {
					Ticket ticket = new Ticket();
					ticket.setTicketid(rs.getString("ticketid"));
					ticket.setTrainid(rs.getString("trainid"));
					ticket.setCarNo(rs.getString("carNo"));
					ticket.setSeatNo(rs.getString("seatNo"));
					ticket.setPrice(rs.getString("price"));
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
		
		public static List<Ticket> findByTrain(String trainid) throws Exception {
			List<Ticket> list = new ArrayList<Ticket>();
			String sql = null; 
			Connection conn = null;
			Statement statement = null;
			ResultSet rs = null;
		
			if(trainid == "") {
				sql = "select * from Ticket;";
			}else {
				sql = "select * from Ticket where trainid = '" 
						+ trainid + "' ;"; 
			}
			//执行
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
					ticket.setPrice(rs.getString("price"));
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
		public static List<Ticket> listTicket() throws Exception {
			List<Ticket> list = new ArrayList<Ticket>();
			String sql = "select * from Ticket";
			Connection conn = null;
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			try {
				conn = Connect.getConnection();
				preStmt = conn.prepareStatement(sql);
				rs = preStmt.executeQuery();
				while (rs.next()) {
					
					Ticket ticket = new Ticket();
					ticket.setTicketid(rs.getString("ticketid"));
					ticket.setTrainid(rs.getString("trainid"));
					ticket.setCarNo(rs.getString("carNo"));
					ticket.setSeatNo(rs.getString("seatNo"));
					ticket.setPrice(rs.getString("price"));
					ticket.setAvailable(rs.getString("available"));
					list.add(ticket);
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

