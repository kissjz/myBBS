package com.JdbcTest;

import com.dao.NotesDAO;
import com.domain.Note;

public class FindNoteByIdTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotesDAO notesDAO = new NotesDAO();
		Note note = notesDAO.find(1);
		System.out.println("id 1:"+note.getAuthor());
	}

}
