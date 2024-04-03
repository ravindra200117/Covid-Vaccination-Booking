package com.vaccination.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vaccination.model.Admin;
import com.vaccination.model.User;
import com.vaccination.model.Vaccination;

public class UserDao 
{
	private static final String dbUrl="jdbc:mysql://localhost:3306/covidvaccination";
	private static final String dbUser="root";
	private static final String dbPass="Ravi@1234";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stm = null;
	private static ResultSet rs = null;
	
	private static final String insertQry = "insert into signup(name, email,password, mobile, aadhar) values (?,?,?,?,?)";
	private static final String insertVaccine = "insert into vaccinationcenter(cvcno, supervisor, vaccinecenter, vaccinename, dose, namePerson, mobile, workinghour) values (?,?,?,?,?,?,?,?)";
	private static final String remove = "delete from vaccinationcenter where cvcno = ?";
	private static final String search = "select * from vaccinationcenter where vaccinecenter = ?";

	
	public static void insertUserDao(User u)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			
			ps = con.prepareStatement(insertQry);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setLong(4, u.getMobileNo());
			ps.setLong(5, u.getAadharNo());
			ps.executeUpdate();
			
		    }
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public String checkLogin(Admin a)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from admin");
			
			while(rs.next())
			{
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				if(email.equals(a.getEmail()) && password.equals(a.getPassword()))
				{
					return "success";
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(stm != null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "failure";
		
	}
	
	public static void insertVaccineCenterDao(Vaccination v)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			
			ps = con.prepareStatement(insertVaccine);
			ps.setInt(1, v.getCvcno());
			ps.setString(2, v.getSupervisor());
			ps.setString(3, v.getVaccinecenter());
			ps.setString(4, v.getVaccinename());
			ps.setString(5, v.getDose());
			ps.setString(6, v.getNamePerson());
			ps.setLong(7, v.getMobile());
			ps.setString(8, v.getWorkinghour());
			ps.executeUpdate();
			
		    }
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public static ArrayList<Vaccination> getAllDoseDetailsDao()
	{
		ArrayList<Vaccination> alVac = new ArrayList<Vaccination>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			stm = con.createStatement();
			rs = stm.executeQuery("select * from vaccinationcenter");
			while(rs.next())
			{
				//below code reads single row at a time
				int cn = rs.getInt("cvcno");
				String s = rs.getString("supervisor");
				String vc = rs.getString("vaccinecenter");
				String vn = rs.getString("vaccinename");
				String d = rs.getString("dose");
				String n = rs.getString("namePerson");
				long m = rs.getLong("mobile");
				String dt = rs.getString("workinghour");
				
				
				
				//store the above data in student object
				Vaccination vac = new Vaccination(cn,s,vc,vn,d,n,m,dt);
				
				//store the above object in arraylist
				alVac.add(vac);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return alVac;
		
	}
	
	public static void delete(int cvcno)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			ps = con.prepareStatement(remove);
			ps.setInt(1,cvcno);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

	public static ArrayList<Vaccination> getAllCenterDeatilDao(String vaccineCenter)
	{
		ArrayList<Vaccination> alVac = new ArrayList<Vaccination>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			ps = con.prepareStatement(search);
			ps.setString(1, vaccineCenter);
			//ps.setString(2, workingHour);

	        rs = ps.executeQuery();
			
			while(rs.next())
			{
				//below code reads single row at a time
				int cn = rs.getInt("cvcno");
				String s = rs.getString("supervisor");
				String vc = rs.getString("vaccinecenter");
				String vn = rs.getString("vaccinename");
				String d = rs.getString("dose");
				String n = rs.getString("namePerson");
				long m = rs.getLong("mobile");
				String dt = rs.getString("workinghour");
				
				
				//store the above data in student object
				Vaccination vac = new Vaccination(cn,s,vc,vn,d,n,m,dt);
				
				//store the above object in arraylist
				alVac.add(vac);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return alVac;
		
	}
	
}
