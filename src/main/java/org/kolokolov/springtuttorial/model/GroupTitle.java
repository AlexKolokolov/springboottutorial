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
}
