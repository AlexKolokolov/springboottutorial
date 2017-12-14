package org.kolokolov.springboottuttorial.service;

import org.kolokolov.springboottuttorial.model.Group;
import org.kolokolov.springboottuttorial.model.GroupTitle;

import java.util.List;

public interface StudentService {
    List<Group> getAllGroups();

    Group getGroupById(long id);

    List<Group> getGroupsByTitle(GroupTitle title);
}
