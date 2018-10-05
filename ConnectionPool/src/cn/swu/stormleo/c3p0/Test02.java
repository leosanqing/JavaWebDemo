package cn.swu.stormleo.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 *	使用配置文件配置c3p0
 *	 
 * @author stormleo
 *
 */


public class Test02
{
	@Test
	public void test() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try
		{
			// 1.创建DataSource
			ComboPooledDataSource comboPooledDataSource =new ComboPooledDataSource();
		
			
			// 3.得到连接对象
			conn = comboPooledDataSource.getConnection();
			
			// SQL语句
			String sql = "insert into account values (null , ?, ?)"; 
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, "Bill");
			ps.setInt(2, 200000);
			ps.executeUpdate();
			
			
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
