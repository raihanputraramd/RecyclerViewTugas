package com.example.recyclerviewtugas;

public class EmailData {
    private String sender;
    private String email;
    private String caption;
    private String time;

    public EmailData(String sender, String title, String caption, String time) {
        this.sender = sender;
        this.email = title;
        this.caption = caption;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public String getEmail() {
        return email;
    }

    public String getCaption() {
        return caption;
    }

    public String getTime() {
        return time;
    }

}
