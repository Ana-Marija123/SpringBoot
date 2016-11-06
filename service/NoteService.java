package com.example.service;

import com.example.model.Note;

import java.util.List;

public interface NoteService {
    void create(Note note);

    void delete(Note note);

    void update(Note note);

    Note getNote(Note note);

    Note getNoteById(Long noteId);

    List<Note> getAll();

}
