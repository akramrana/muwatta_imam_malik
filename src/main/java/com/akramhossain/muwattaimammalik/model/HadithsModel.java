package com.akramhossain.muwattaimammalik.model;

import androidx.room.DatabaseView;

@DatabaseView(
        "select \n" +
                "eng_hadiths.hid,\n" +
                "eng_hadiths.hadithnumber,\n" +
                "eng_hadiths.arabicnumber,\n" +
                "eng_hadiths.grades,\n" +
                "eng_hadiths.reference_book,\n" +
                "eng_hadiths.reference_hadith,\n" +
                "ben_hadiths.text as text_bn,\n" +
                "ara_hadiths.text as text_ar,\n" +
                "eng_hadiths.text as text_en,\n" +
                "books.name_en as book_en," +
                "books.name_ar as book_ar," +
                "books.name_bn as book_bn," +
                "books.bid  as bid,\n" +
                "(select count(favorite_id) from favorites where favorites.hadithnumber = eng_hadiths.hadithnumber) as is_favorite\n" +
                "from eng_hadiths\n" +
                "left join ara_hadiths on eng_hadiths.hadithnumber = ara_hadiths.hadithnumber\n" +
                "left join ben_hadiths on eng_hadiths.hadithnumber = ben_hadiths.hadithnumber\n" +
                "left join books on eng_hadiths.reference_book = books.reference_book\n" +
                "where (text_bn !=\"\" or text_ar !=\"\" or text_en !=\"\")"
)

public class HadithsModel {

    private int hid;
    private int hadithnumber;
    private int arabicnumber;
    private String text;
    private String grades;
    private String reference_book;
    private String reference_hadith;
    private String text_bn;
    private String text_en;
    private String text_ar;

    private String book_bn;
    private String book_en;
    private String book_ar;

    private int is_favorite;
    private int bid;

    public HadithsModel(int hadithnumber, int arabicnumber, String text, String grades, String reference_book, String reference_hadith, String text_bn, String text_en, String text_ar, String book_bn, String book_en, String book_ar, int is_favorite, int bid) {
        this.hadithnumber = hadithnumber;
        this.arabicnumber = arabicnumber;
        this.text = text;
        this.grades = grades;
        this.reference_book = reference_book;
        this.reference_hadith = reference_hadith;
        this.text_bn = text_bn;
        this.text_en = text_en;
        this.text_ar = text_ar;
        this.book_bn = book_bn;
        this.book_en = book_en;
        this.book_ar = book_ar;
        this.is_favorite = is_favorite;
        this.bid = bid;
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

    public String getText_bn() {
        return text_bn;
    }

    public void setText_bn(String text_bn) {
        this.text_bn = text_bn;
    }

    public String getText_en() {
        return text_en;
    }

    public void setText_en(String text_en) {
        this.text_en = text_en;
    }

    public String getText_ar() {
        return text_ar;
    }

    public void setText_ar(String text_ar) {
        this.text_ar = text_ar;
    }

    public String getBook_bn() {
        return book_bn;
    }

    public void setBook_bn(String book_bn) {
        this.book_bn = book_bn;
    }

    public String getBook_en() {
        return book_en;
    }

    public void setBook_en(String book_en) {
        this.book_en = book_en;
    }

    public String getBook_ar() {
        return book_ar;
    }

    public void setBook_ar(String book_ar) {
        this.book_ar = book_ar;
    }

    public int getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(int is_favorite) {
        this.is_favorite = is_favorite;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
