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
    @JoinColumn(name = "stud_group_id")
    private Group group;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return String.format("#%d : %s [%s]", id, name, group);
    }
}
