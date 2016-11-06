package com.example.service;

import com.example.model.Note;
import com.example.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }


    @Override
    public void create(Note note){
        noteRepository.save(note);
    }

    @Override
    public void delete(Note note){
        if(noteRepository.exists(note.getId())){
            noteRepository.delete(note);
        }
    }

    @Override
    public void update(Note note){
        Note updatedNote = getNote(note);
        if(updatedNote.isStatus() != note.isStatus()){
            updatedNote.setStatus(note.isStatus());
        }else if(updatedNote.getText() != note.getText() && note.getText() != null){
            updatedNote.setText(note.getText());
        }
        noteRepository.save(updatedNote);
    }

    @Override
    public Note getNote(Note note){
        return noteRepository.findOne(note.getId());
    }

    @Override
    public Note getNoteById(Long noteId){
        return noteRepository.findOne(noteId);
    }

    @Override
    public List<Note> getAll(){
        return noteRepository.findAll();
    }




}
