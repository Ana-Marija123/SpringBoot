package com.example.controller;

import com.example.model.Note;
import com.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoteController_ListNotes {

    @Autowired
    private NoteService noteService;

    @ModelAttribute("notes")
    public List<Note> allNotes(){
        return noteService.getAll();
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String listAllNotes() {
        return "notes";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteNote(@RequestParam(value = "id", required = true) Long id, Note note){
        ModelAndView modelAndView = new ModelAndView("delete");
        note = noteService.getNoteById(id);
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView messages(@RequestParam(value = "id", required=true) Long id, Note note) {
        ModelAndView modelAndView = new ModelAndView("edit");
        note = noteService.getNoteById(id);
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @ModelAttribute("note")
    public Note newNote() {
        return new Note();
    }

    @RequestMapping(value="/notes", method=RequestMethod.POST)
    public String saveNote(@ModelAttribute("note") Note note) {
        noteService.create(note);
        return "redirect:/notes";
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST, params="action=edit")
    public String updateNote(@ModelAttribute("note") Note note){
        noteService.update(note);
        return "redirect:/notes";
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST, params="action=cancel")
    public String cancelEdit(@ModelAttribute("note") Note note){
        return "redirect:/notes";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, params = "action=delete")
    public String deleteNote(@ModelAttribute("note") Note note){
        noteService.delete(note);
        return "redirect:/notes";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, params = "action=cancel")
    public String cancelDelete(@ModelAttribute("note") Note note){
        return "redirect:/notes";
    }

}
