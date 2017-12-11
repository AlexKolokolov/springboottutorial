package org.kolokolov.springtuttorial.repository;

import org.kolokolov.springtuttorial.model.Group;
import org.kolokolov.springtuttorial.model.GroupTitle;
import org.kolokolov.springtuttorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {
    List<Group> findGroupsByTitle(GroupTitle title);
}
