package com.trafalgarcp.crm.controllers;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trafalgarcp.crm.domain.Note;


import com.trafalgarcp.crm.repository.NoteRepository;

@Controller
//@RequestMapping("/company/{companyId}")
public class NoteController {
	
	@Autowired
	NoteRepository noteRepository;
	
	
	
	/*
	 * Show form to create note
	 */
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/note/new")
	public String initCreationForm(Model model) {
		Note note = new Note();
		model.addAttribute("note",note);
		return "note/note-index";
	}
	
	/*
	 * Process form that crate new note  
	 */
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/note/new")
	public String processCreationForm(Note note) {
		this.noteRepository.save(note);
		return "note/notes";
	}
	
	
    /*
     * Show notes
     */
	@GetMapping("/notes")
	public String showNotes() {
		return "";
	}
	
	/*
	 * Show the list of notes
	 */
	
	@GetMapping("/note")
	public String newNotes() {
		Note note =  new Note();
		return "note/note-index";
	}
	
//	@GetMapping("/getnote")
//	public String getNotesForm(Notes note) {
//		//model.addAttribute("notes", new Notes());
//		return "notes-frm";
//	}
	
//	@PostMapping("/newnote") 
//	public String saveNotes(@Valid  Notes note,BindingResult bindingResult) {
//
//		if(bindingResult.hasErrors()) {
//			return "notes-frm";
//		}
		
//		Notes notes= new Notes();
//		notes.setNote(note.getNote());
//		notes.setTitle("title");
//		notes.setDate(  new Date(2000, 11, 21) );
//		notesRepository.save(notes);
		
	//	return "company";
	//}

}
