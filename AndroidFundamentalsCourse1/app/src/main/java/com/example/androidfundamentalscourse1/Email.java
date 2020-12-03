package com.example.androidfundamentalscourse1;

public class Email {
    private int id;
    private String fromName;
    private String title;
    private String shortBody;

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", fromName='" + fromName + '\'' +
                ", title='" + title + '\'' +
                ", shortBody='" + shortBody + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortBody() {
        return shortBody;
    }

    public void setShortBody(String shortBody) {
        this.shortBody = shortBody;
    }

    public Email(int id, String fromName, String title, String shortBody) {
        this.id = id;
        this.fromName = fromName;
        this.title = title;
        this.shortBody = shortBody;
    }
}
