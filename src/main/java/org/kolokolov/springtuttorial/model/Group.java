package org.kolokolov.springtuttorial.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stud_group")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private GroupTitle title;

    @Column(name = "group_year")
    private String year;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stud_group_id")
    @JsonManagedReference
    private List<Student> students;

    public Group() {}

    public Group(GroupTitle title, String year, List<Student> students) {
        this.title = title;
        this.year = year;
        this.students = students;
    }

    public Group(Long id, GroupTitle title, String year, List<Student> students) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.students = students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public GroupTitle getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("#%d : %s-%s", id, title.getTitle(), year);
    }
}
