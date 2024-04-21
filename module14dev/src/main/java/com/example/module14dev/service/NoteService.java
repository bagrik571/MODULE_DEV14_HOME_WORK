package com.example.module14dev.service;

import com.example.module14dev.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
@Slf4j
@Service
public class NoteService {
    private final List<Note> notes= new ArrayList<>();

    public List<Note> listAll(){
        return this.notes;
    }

    public Note ad(Note note){
        note.setId(new Random().nextLong());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        Note noteToRemove = notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " was not found or does not exist"));
        notes.remove(noteToRemove);
    }

    public void update(Note note) {
        long id = note.getId();
        Note existingNote = notes.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " was not found or does not exist"));
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id){
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " was not found or does not exist"));
    }
}
