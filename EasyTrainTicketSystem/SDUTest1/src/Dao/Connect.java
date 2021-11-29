package Dao;
import java.sql.*;
public class Connect {
	private static Connection conn;
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost:3306/TrainTicketSystem";
    //private static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    // 数据库的用户名与密码，需要根据自己的设置
    private static final String USER = "root";
    private static final String PASS = "Qiong20202023";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        return conn; 
	}
	
	public static void setParams(PreparedStatement preStmt, Object... params)
			throws SQLException {
		if (params == null || params.length == 0)
			return;
		for (int i = 1; i <= params.length; i++) {
			Object param = params[i - 1];
			if (param == null) {
				preStmt.setNull(i, Types.NULL);
			} else if (param instanceof Integer) {
				preStmt.setInt(i, (Integer) param);
			} else if (param instanceof String) {
				preStmt.setString(i, (String) param);
			} else if (param instanceof Double) {
				preStmt.setDouble(i, (Double) param);
			} else if (param instanceof Long) {
				preStmt.setDouble(i, (Long) param);
			} else if (param instanceof Timestamp) {
				preStmt.setTimestamp(i, (Timestamp) param);
			} else if (param instanceof Boolean) {
				preStmt.setBoolean(i, (Boolean) param);
			} else if (param instanceof Date) {
				preStmt.setDate(i, (Date) param);
			}
		}
	}
 
	//执行sql
	public static int executeUpdate(String sql) throws SQLException, ClassNotFoundException {
		return executeUpdate(sql, new Object[] {});
	}
 
	//执行代参数的sql
	public static int executeUpdate(String sql, Object... params)
			throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = getConnection();
			preStmt = conn.prepareStatement(sql);
			setParams(preStmt, params);
			return preStmt.executeUpdate(); //执行SQL操作
		} finally {
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
	}

	

}
