package com.example.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name = "NOTE")
public class Note {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "TEXT")
    private String text;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
