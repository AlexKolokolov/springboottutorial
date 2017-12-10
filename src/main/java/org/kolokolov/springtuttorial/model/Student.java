package org.kolokolov.springtuttorial.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JsonBackReference
    private StudGroup studGroup;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudGroup(StudGroup studGroup) {
        this.studGroup = studGroup;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StudGroup getStudGroup() {
        return studGroup;
    }

    @Override
    public String toString() {
        return String.format("#%d : %s [%s]", id, name, studGroup);
    }
}
