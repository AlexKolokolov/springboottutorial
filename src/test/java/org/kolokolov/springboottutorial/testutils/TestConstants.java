package org.kolokolov.springboottutorial.testutils;

import org.kolokolov.springboottuttorial.model.Group;
import org.kolokolov.springboottuttorial.model.GroupTitle;

import java.util.Collections;
import java.util.List;

public interface TestConstants {

    Group group = new Group(1L, GroupTitle.EPA, "01", Collections.EMPTY_LIST);

    List<Group> groups = Collections.singletonList(group);
}
