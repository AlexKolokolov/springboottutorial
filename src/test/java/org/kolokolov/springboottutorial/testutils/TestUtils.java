package org.kolokolov.springboottutorial.testutils;

import org.kolokolov.springboottuttorial.model.Group;
import org.kolokolov.springboottuttorial.model.GroupTitle;

import java.util.Collections;
import java.util.List;

public class TestUtils {

    protected final Group group = new Group(1L, GroupTitle.EPA, "01", null);

    protected final List<Group> groups = Collections.singletonList(group);
}
