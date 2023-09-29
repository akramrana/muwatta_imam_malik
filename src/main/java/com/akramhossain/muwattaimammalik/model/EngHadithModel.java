package com.akramhossain.muwattaimammalik.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "eng_hadiths")

public class EngHadithModel {

    @PrimaryKey(autoGenerate = false)
    private int hid;
    private int hadithnumber;
    private int arabicnumber;
    private String text;
    private String grades;
    private String reference_book;
    private String reference_hadith;

    public EngHadithModel(int hadithnumber, int arabicnumber, String text, String grades, String reference_book, String reference_hadith) {
        this.hadithnumber = hadithnumber;
        this.arabicnumber = arabicnumber;
        this.text = text;
        this.grades = grades;
        this.reference_book = reference_book;
        this.reference_hadith = reference_hadith;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getHadithnumber() {
        return hadithnumber;
    }

    public void setHadithnumber(int hadithnumber) {
        this.hadithnumber = hadithnumber;
    }

    public int getArabicnumber() {
        return arabicnumber;
    }

    public void setArabicnumber(int arabicnumber) {
        this.arabicnumber = arabicnumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getReference_book() {
        return reference_book;
    }

    public void setReference_book(String reference_book) {
        this.reference_book = reference_book;
    }

    public String getReference_hadith() {
        return reference_hadith;
    }

    public void setReference_hadith(String reference_hadith) {
        this.reference_hadith = reference_hadith;
    }

}
