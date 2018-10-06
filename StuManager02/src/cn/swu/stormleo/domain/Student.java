package cn.swu.stormleo.domain;

import java.util.Date;

/**
 * 封装的Student 对象
 */
public class Student
{
	private int sid;
	private String sname;
	private String gender;
	private String info;
	private String phone;
	private String hobby;
	private Date birthday;
	public Student(String sname, String gender,  String phone,Date birthday, String hobby, String info)
	{
		super();
		this.sname = sname;
		this.gender = gender;
		this.info = info;
		this.phone = phone;
		this.hobby = hobby;
		this.birthday = birthday;
	}
	public int getSid()
	{
		return sid;
	}
	public void setSid(int sid)
	{
		this.sid = sid;
	}
	public String getSname()
	{
		return sname;
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getHobby()
	{
		return hobby;
	}
	public void setHobby(String hobby)
	{
		this.hobby = hobby;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public Student(int sid, String sname, String gender, String info, String phone, String hobby, Date birthday)
	{
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.info = info;
		this.phone = phone;
		this.hobby = hobby;
		this.birthday = birthday;
	}
	public Student()
	{
		super();
	}
	
}
