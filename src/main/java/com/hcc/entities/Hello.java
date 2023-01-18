package com.hcc.entities;

import javax.persistence.*;

// this is an example entity feel free to delete this once you have created your own.
@Entity
@Table(name = "greetings")
public class Hello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "greeting_message")
    private String message;

    public Hello(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Hello(String message) {
        this.message = message;
    }

    public Hello() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
