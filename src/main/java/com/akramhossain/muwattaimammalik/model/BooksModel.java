package com.akramhossain.muwattaimammalik.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")

public class BooksModel {

    @PrimaryKey(autoGenerate = false)
    private int bid;
    private String name_en;
    private String name_bn;
    private String name_ar;
    private String reference_book;

    public BooksModel(String name_en, String name_bn, String name_ar, String reference_book) {
        this.name_en = name_en;
        this.name_bn = name_bn;
        this.name_ar = name_ar;
        this.reference_book = reference_book;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
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

}
