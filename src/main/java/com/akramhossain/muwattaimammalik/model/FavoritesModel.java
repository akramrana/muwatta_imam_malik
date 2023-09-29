package com.akramhossain.muwattaimammalik.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")

public class FavoritesModel {

    @PrimaryKey(autoGenerate = true)
    private int favorite_id;
    private int hadithnumber;

    public FavoritesModel(int hadithnumber) {
        this.hadithnumber = hadithnumber;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getHadithnumber() {
        return hadithnumber;
    }

    public void setHadithnumber(int hadithnumber) {
        this.hadithnumber = hadithnumber;
    }
}
