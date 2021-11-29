package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Train;
import Dao.Connect;
 
public class TrainDao {
	
	//插入车次
	public static int insert(Train train) throws Exception {
		String sql = "insert into Train (trainid,departPlace,arrivePlace,departTime) " +
				"values ('" + train.getTrainid() +"','"+ train.getDepartPlace() +"','"+ train.getArrivePlace() +
				"','"+ train.getDepartTime() +"');";
		System.out.println(sql);
		return Connect.executeUpdate(sql);
	
	}
	
	//更新车次
	public static int update(Train train) throws Exception {
		String sql = "update Train set departPlace = ?, arrivePlace = ?, departTime = ? where trainid = ? ";
		return Connect.executeUpdate(sql, train.getDepartPlace(), train.getArrivePlace(), train.getDepartTime(), train.getTrainid());
	}
	
	//删除
		public static int delete(String id) throws Exception {
			String sql = "delete from Train where trainid = ? ";
			return Connect.executeUpdate(sql, id);
		}

//	//删除操作
//	public static int delete(String id) throws Exception {
//		String sql = "delete from Train where trainid = ? ";
//		return Connect.executeUpdate(sql, id);
//	}
		//查找车次
		public static Train find(String id) throws Exception {
			String sql = "select * from Train where trainid = ? ";
			Connection conn = null;
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			try {
				
				conn = Connect.getConnection(); 
				preStmt = conn.prepareStatement(sql);
				preStmt.setString(1, id);
				rs = preStmt.executeQuery();
				
				if (rs.next()) {
					Train train = new Train();
					train.setTrainid(rs.getString("trainid"));
					train.setDepartPlace(rs.getString("departPlace"));
					train.setArrivePlace(rs.getString("arrivePlace"));
					train.setDepartTime(rs.getString("departTime"));
					
					return train;
				} else {
					return null;
				}
			} finally { //依次关闭 记录集 声明 连接对象
				if (rs != null)
					rs.close();
				if (preStmt != null)
					preStmt.close();
				if (conn != null)
					conn.close();
			}
		}

	
	//查询所有车次信息
	public static List<Train> listTrain() throws Exception {
		List<Train> list = new ArrayList<Train>();
		String sql = "select * from Train";
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = Connect.getConnection();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				
				Train train = new Train();
				train.setTrainid(rs.getString("trainid"));      
				train.setDepartPlace(rs.getString("departPlace"));
				train.setArrivePlace(rs.getString("arrivePlace"));
				train.setDepartTime(rs.getString("departTime"));
				list.add(train);
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

