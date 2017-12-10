package org.kolokolov.springtuttorial.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudGroup {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private GroupTitle title;
    private String groupYear;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    @JoinColumn(name = "stud_group_id")
    private List<Student> students;

    public StudGroup() {}

    public StudGroup(GroupTitle title, String groupYear, List<Student> students) {
        this.title = title;
        this.groupYear = groupYear;
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

    public String getGroupYear() {
        return groupYear;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("[%d] : %s - %s", id, title.getTitle(), groupYear);
    }
}
