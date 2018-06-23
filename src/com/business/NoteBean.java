package com.business;

import java.util.ArrayList;
import java.util.List;

import com.dao.NoteDao;
import com.domain.Note;

public class NoteBean {
	public List<Note> findAllNotes(){
		try {
			NoteDao noteDao = new NoteDao();
			return noteDao.findAll();
		}catch(Exception e) {
			System.out.println("could not find all notes");
			e.printStackTrace();
		}
		return new ArrayList<Note>();
	}
}
