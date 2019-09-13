package com.trafalgarcp.crm.controllers;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trafalgarcp.crm.domain.Notes;
import com.trafalgarcp.crm.domain.NotesRepository;

@Controller
public class NoteController {
	
	@Autowired
	NotesRepository notesRepository;
	
	@GetMapping("/getnote")
	public String getNotesForm(Notes note) {
		//model.addAttribute("notes", new Notes());
		return "notes-frm";
	}
	
	@PostMapping("/newnote") 
	public String saveNotes(@Valid  Notes note,BindingResult bindingResult) {
//		System.out.println("******************"+note.getNote());
		if(bindingResult.hasErrors()) {
			return "notes-frm";
		}
		
//		Notes notes= new Notes();
//		notes.setNote(note.getNote());
//		notes.setTitle("title");
//		notes.setDate(  new Date(2000, 11, 21) );
//		notesRepository.save(notes);
		
		return "company";
	}

}
