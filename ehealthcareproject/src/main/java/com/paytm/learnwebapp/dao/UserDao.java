package com.paytm.learnwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.paytm.learnwebapp.model.User;
import com.paytm.learnwebapp.service.UserService;

public class UserDao {

		String query;
		
		public List<String> SelectByJob(String jobrole)   
		{
			List<String> ls = new ArrayList<>();
			try	
			{
				String url = "jdbc:mysql://localhost:3306/db2";
				String uname = "root";
				String pass = "31081997kanishka,..";
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				String userData = "";
				query = "select * from user where jobrole = " + jobrole;
				ResultSet rs = st.executeQuery(query);
				while(rs.next())
				{
					userData = rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4) + " : " + rs.getString(5);
					ls.add(userData);				
				}
				st.close();
				con.close();
			}	catch(Exception ex)
			{
				String error="Not found.";
				ls.add(error);
			}
			return ls;
		}
		public List<String> SelectAll() 
		{
			List<String> ls = new ArrayList<>();
			try	
			{
				String url = "jdbc:mysql://localhost:3306/db2";
				String uname = "root";
				String pass = "31081997kanishka,..";
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				String userData = "";
				query = "select * from user";
				ResultSet rs = st.executeQuery(query);
				while(rs.next())
				{
					userData = rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4) + " : " + rs.getString(5);
					ls.add(userData);				
				}
				st.close();
				con.close();
			}	catch(Exception ex)
			{
				String error="Not found.";
				ls.add(error);
			}
			return ls;
		}
		public int Update(User user, String id) 
		{
			try	
			{
				String url = "jdbc:mysql://localhost:3306/db2";
				String uname = "root";
				String pass = "31081997kanishka,..";
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				
				Statement st = con.createStatement();
				query = "delete from user where id = "+ id;
				st.executeUpdate(query);
				st.close();
				
				query = "insert into user values (?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1,  id);
				pst.setString(2, user.getName());
				pst.setString(3, user.getJobrole());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getPhone());
				pst.executeUpdate();
				
				pst.close();
				con.close();
			}	catch(Exception ex)
			{
				return 0;
			}	
			return 1;
		}
		public int Insert(User user) 
		{
			try	
			{
				String url = "jdbc:mysql://localhost:3306/db2";
				String uname = "root";
				String pass = "31081997kanishka,..";
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				
				query = "insert into user values (?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				
				pst.setString(1, user.getId());
				pst.setString(2, user.getName());
				pst.setString(3, user.getJobrole());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getPhone());
				pst.executeUpdate();
				
				pst.close();
				con.close();
			}	catch(Exception ex)
			{
				return 0;
			}	
			return 1;
		}
		public String SelectById(String id) {
			
			String userData = "";
			try	
			{
				String url = "jdbc:mysql://localhost:3306/db2";
				String uname = "root";
				String pass = "31081997kanishka,..";
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				
				query = "select * from user where id = "+ id;
				ResultSet rs = st.executeQuery(query);
				while(rs.next())
				{
					userData = rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4) + " : " + rs.getString(5);
				}
				st.close();
				con.close();
			}	catch(Exception ex)
			{
				String error="Not found.";
				return error;
			}
			return userData;		
			}
		public int Delete(String id) {

			try	
			{
				String url = "jdbc:mysql://localhost:3306/db2";
				String uname = "root";
				String pass = "31081997kanishka,..";
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				
				query = "delete from user where id = "+ id;
				st.executeUpdate(query);
				st.close();
				con.close();
				return 1;
				
			}	catch(Exception ex)
			{
				return 0;
			}
		}
		public String findEmail(String id) {
			String userData = "";
			try	
			{
				String url = "jdbc:mysql://localhost:3306/db2";
				String uname = "root";
				String pass = "31081997kanishka,..";
				Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				
				query = "select email from user where id = "+ id;
				ResultSet rs = st.executeQuery(query);
				while(rs.next())
				{
					userData = rs.getString("email");
				}
				st.close();
				con.close();
			}	catch(Exception ex)
			{
				String error="Not found.";
				return error;
			}
			return userData;	
		}
}
