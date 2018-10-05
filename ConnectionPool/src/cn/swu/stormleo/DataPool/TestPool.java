package cn.swu.stormleo.DataPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestPool
{	
	@Test
	public void testPool()
	{
		
		Connection conn=null;
		PreparedStatement ps=null;
		MyDataSource myDataSource=new MyDataSource();
		try
		{
			 conn =myDataSource.getConnection();
			
			String sql="insert into account values (null,'猪屁屁','100000')";
			 ps= conn.prepareStatement(sql);
			ps.executeUpdate();
			
			
			
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				ps.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			myDataSource.addBack(conn);
		}
	}
}
