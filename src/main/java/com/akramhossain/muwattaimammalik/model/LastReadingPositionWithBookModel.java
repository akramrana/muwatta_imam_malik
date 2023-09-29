package com.akramhossain.muwattaimammalik.model;

public class LastReadingPositionWithBookModel {

    private String name_en;
    private String name_bn;
    private String name_ar;
    private String reference_book;
    private int position;
    private int last_reading_id;
    private int bid;

    public LastReadingPositionWithBookModel(String name_en, String name_bn, String name_ar, String reference_book, int position, int last_reading_id, int bid) {
        this.name_en = name_en;
        this.name_bn = name_bn;
        this.name_ar = name_ar;
        this.reference_book = reference_book;
        this.position = position;
        this.last_reading_id = last_reading_id;
        this.bid = bid;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_bn() {
        return name_bn;
    }

    public void setName_bn(String name_bn) {
        this.name_bn = name_bn;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getReference_book() {
        return reference_book;
    }

    public void setReference_book(String reference_book) {
        this.reference_book = reference_book;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLast_reading_id() {
        return last_reading_id;
    }

    public void setLast_reading_id(int last_reading_id) {
        this.last_reading_id = last_reading_id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
