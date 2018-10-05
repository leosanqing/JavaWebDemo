package cn.swu.stormleo.c3p0;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.swu.stormleo.domain.Account;

/**
 * 使用 DBUtil 完成数据库增删改操作
 * @author stormleo
 *
 */

public class Test03
{
	
	//增加操作
	@Test
	public void test() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		
		queryRunner.update("insert into  account values(null,?,?)", "Woz",3000);
		
	}
	
	@Test
	public void test02() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		
		Account account =queryRunner.query("select * from account where id=?", new ResultSetHandler<Account>() {

			@Override
			public Account handle(ResultSet rs) throws SQLException
			{
				Account account = new Account();
				while(rs.next()) {
					String name =rs.getString("name");
					int money = rs.getInt("money");
					account.setName(name);
					account.setMoney(money);
				}
				return account;
			}
			
		},3);
		System.out.println(account);
	}
	@Test
	public void test04() throws SQLException
	{
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		Account account = queryRunner.query("select * from account where id =2", new BeanHandler<Account>(Account.class));
		System.out.println(account.toString());
	}
	
	@Test
	public void test03() throws SQLException
	{
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		List<Account> list = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
		for (Account account : list)
		{
			System.out.println(account.toString());
		}
	}

}	
