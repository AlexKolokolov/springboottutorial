package org.kolokolov.springtuttorial.service;

import org.kolokolov.springtuttorial.model.Group;
import org.kolokolov.springtuttorial.model.GroupTitle;

import java.util.List;

public interface StudentService {
    List<Group> getAllGroups();

    Group getGroupById(long id);

    List<Group> getGroupsByTitle(GroupTitle title);
}
