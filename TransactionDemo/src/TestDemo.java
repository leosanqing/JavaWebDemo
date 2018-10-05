import com.mysql.jdbc.Connection;

import cn.swu.stormleo.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class TestDemo
{
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	
	@Test
	public void transactionDemo() {
		try
		{
			conn=(Connection) JDBCUtil.getConn();
			conn.setAutoCommit(false);
			
			// 查询
			String sql="update account set money =money-? where id=?";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			// 执行SQL语句
			
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			int a=10/0;
			
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			conn.commit();
		} catch (SQLException e)
		{
			try
			{
				conn.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);
		}
	}
}
