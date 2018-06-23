package com.JdbcTest;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.NotesDAO;
import com.domain.Note;

public class FindAllNotesTest {

	public static void main(String[] args) {
		NotesDAO notesDAO = new NotesDAO();
		ArrayList<Note> list = notesDAO.findAll();
		Iterator<Note> noteIt = list.iterator();
		while(noteIt.hasNext()) {
			Note note = noteIt.next();
			System.out.println(note.getAuthor());
		}

}
}
