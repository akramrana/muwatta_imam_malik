package com.akramhossain.muwattaimammalik.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity(tableName = "last_reading_position")

public class LastReadingPositionModel {

    @PrimaryKey(autoGenerate = true)
    private int last_reading_id;
    private int reference_book;
    private int position;

    public LastReadingPositionModel(int reference_book, int position) {
        this.reference_book = reference_book;
        this.position = position;
    }

    public int getLast_reading_id() {
        return last_reading_id;
    }

    public void setLast_reading_id(int last_reading_id) {
        this.last_reading_id = last_reading_id;
    }

    public int getReference_book() {
        return reference_book;
    }

    public void setReference_book(int reference_book) {
        this.reference_book = reference_book;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
