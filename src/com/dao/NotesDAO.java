package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.domain.Note;
import com.utils.JDBCUtils;
public class NotesDAO {
	// 添加用户的操作
	public boolean insert(Note note) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		// 获得数据的连接
		conn = JDBCUtils.getConnection();
		// 获得Statement对象
		stmt = conn.createStatement();
		// 发送SQL语句
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createtime = sdf.format(note.getCreateTime());
	    String sql = "INSERT INTO notes(id, title, content, author, create_time) "+
					"VALUES("
					+ note.getId()
					+ ",'"
					+ note.getTitle()
					+ "','"
					+ note.getContent()
					+ "','"
					+ note.getAuthor()
					+ "','"
					+ createtime + "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	// 查询所有的User对象
	public ArrayList<Note> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Note> list = new ArrayList<Note>();
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM notes";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				Note note = new Note();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setAuthor(rs.getString("author"));
				note.setCreateTime(rs.getDate("create_time"));
				list.add(note);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	// 根据id查找指定的user
	public Note find(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM notes WHERE id=" + id;
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				Note note = new Note();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setAuthor(rs.getString("author"));
				note.setCreateTime(rs.getDate("create_time"));
				return note;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return null;
		}
		// 删除用户
		public boolean delete(int id) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// 获得数据的连接
				conn = JDBCUtils.getConnection();
				// 获得Statement对象
				stmt = conn.createStatement();
				// 发送SQL语句
				String sql = "DELETE FROM notes WHERE id=" + id;
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return false;
		}
		// 修改用户
		public boolean update(Note note) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// 获得数据的连接
				conn = JDBCUtils.getConnection();
				// 获得Statement对象
				stmt = conn.createStatement();
				// 发送SQL语句
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String createtime = sdf.format(note.getCreateTime());
				String sql = "UPDATE notes set title='" + note.getTitle()
						+ "',content='" + note.getContent() + "',author='"
						+ note.getAuthor() + "',create_time='" + createtime
						+ "' WHERE id=" + note.getId();
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return false;
		}
	}

