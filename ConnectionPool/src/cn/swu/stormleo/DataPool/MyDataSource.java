package cn.swu.stormleo.DataPool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyDataSource implements DataSource
{
	
	List<Connection> list=new ArrayList<>();

	public MyDataSource () 
	{
		
		for (int i = 0; i < 10; i++)
		{
			Connection conn= JDBCUtil.getConn();
			list.add(conn);
			
		}
		 
		
	}
	
	@Override
	public Connection getConnection() throws SQLException
	{
		
		if(list.size()==0) 
		{
			for (int i = 0; i < 10; i++)
			{
				Connection conn= JDBCUtil.getConn();
				list.add(conn);
				
			}
		}
		Connection conn=list.remove(0);
		return conn;
	}
	
	public void addBack(Connection conn)
	{
		list.add(conn);
	}
	
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
