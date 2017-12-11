package org.kolokolov.springtuttorial.model;

public enum GroupTitle {
    EPA("ЭПА"),
    TGPV("ТГПВ");

    private String title;

    GroupTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static GroupTitle parseStringTitle(String sTitle) {
        for (GroupTitle title: GroupTitle.values()) {
            if (title.getTitle().equals(sTitle)) return title;
        }
        throw new IllegalArgumentException(String.format("No title for string [%s] found",sTitle));
    }
}
