package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Admin;

public class AdminDao {
    private  static Connection conn=null;
    private  static Statement  stmt=null;
    
	public AdminDao() throws ClassNotFoundException, SQLException
	{
		 conn=Connect.getConnection();
	}
	
	//通过id查询管理员
	public static Admin getAdminById(String id)
	{
		String sql="select * from admin where adminid='"+id+"'";
		Admin admin = null;
		try {
			stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);    
	
	        while(rs.next()){
	           
	        	admin=new Admin();
	            admin.setAdminid(rs.getString("adminid"));
	            admin.setAdminname(rs.getString("adminname"));
	            admin.setAdminpassword(rs.getString("adminpassword"));
	        }
	     
	        rs.close();
	        stmt.close();
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        return admin;
		
	}
	
}
