package com.JdbcTest;

import java.util.Date;

import com.dao.NotesDAO;
import com.domain.Note;

public class UpdateNoteTest {

	public static void main(String[] args) {
		NotesDAO notesDAO = new NotesDAO();
		Note note = new Note();
		note.setId(5);
		note.setTitle("hh");
		note.setAuthor("lala");
		note.setContent("content");
		note.setCreateTime(new Date());
		boolean b = notesDAO.update(note);
		System.out.println(b);
	}

}
