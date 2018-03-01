package ru.mirea;

public class Tag {

    private String mnemo;
    private String name;

    Tag(String mnemo, String name) {
        this.mnemo = mnemo;
        this.name = name;
    }

    public String getMnemo() {
        return mnemo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}