package cn.swu.stormleo.c3p0;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBCPTest
{
	/**
	 * C3P0 demo（不使用配置文件）
	 */
	
	@Test
	public void test() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try
		{
			// 1.创建DataSource
			ComboPooledDataSource comboPooledDataSource =new ComboPooledDataSource();
		
			// 2.建立连接
			comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
			comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/bank");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("root");
			
			// 3.得到连接对象
			conn = comboPooledDataSource.getConnection();
			
			// SQL语句
			String sql = "insert into account values (null , ?, ?)"; 
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, "Jobs");
			ps.setInt(2, 20000);
			ps.executeUpdate();
			
			
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
