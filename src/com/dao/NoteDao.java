package com.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.domain.Note;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class NoteDao {
	public Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = 
				(Connection) DriverManager.getConnection("jdbc:mysql://47.95.10.97:3306/forumdemo_notes", "root", "***");
		
		return connection;
	}
	
	public List<Note> findAll() throws Exception{
		Connection con = getConnection();
		String sql = "select id, title, content, author, create_time from notes";
		
		Statement sta = (Statement) con.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		List<Note> notes = new ArrayList<Note>();
		
//		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); 
		
		while(rs.next()) {
			Note tn = new Note();
			tn.setId(rs.getInt("id"));
			tn.setTitle(rs.getString("title"));
			tn.setContent(rs.getString("content"));
			tn.setAuthor(rs.getString("author"));
			tn.setCreateTime(rs.getTimestamp("create_time"));
//			String timeStamp = fmt.format(rs.getTimestamp("create_time"));
//			tn.setCreateTime(timeStamp);
//			notes.add(tn);
			
		}
		con.close();
		return notes;
	}
}
