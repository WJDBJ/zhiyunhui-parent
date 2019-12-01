package com.entity;

/**
 * @author XJ
 */
public class TextsEntity {
    int id;
    String textdosc;
    String textanswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextdosc() {
        return textdosc;
    }

    public void setTextdosc(String textdosc) {
        this.textdosc = textdosc;
    }

    public String getTextanswer() {
        return textanswer;
    }

    public void setTextanswer(String textanswer) {
        this.textanswer = textanswer;
    }

    @Override
    public String toString() {
        return "TextsEntity{" +
                "id=" + id +
                ", textdosc='" + textdosc + '\'' +
                ", textanswer='" + textanswer + '\'' +
                '}';
    }
}
