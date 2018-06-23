package com.JdbcTest;

import java.util.Date;
import com.dao.NotesDAO;
import com.domain.Note;

public class InsertTest {

	public static void main(String[] args) {
		NotesDAO nd = new NotesDAO();
		Note note = new Note();
		note.setAuthor("kiss");
		note.setContent("this is content");
		note.setCreateTime(new Date());
		note.setTitle("this is title");
		boolean b = nd.insert(note);
		System.out.println(b);
	}

}
