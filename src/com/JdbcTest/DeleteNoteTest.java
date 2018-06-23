package com.JdbcTest;

import com.dao.NotesDAO;

public class DeleteNoteTest {

	public static void main(String[] args) {
		NotesDAO notesDAO = new NotesDAO();
		boolean b = notesDAO.delete(4);
		System.out.println(b);

	}

}
