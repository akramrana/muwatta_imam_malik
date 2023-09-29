package com.akramhossain.muwattaimammalik.dao;

import com.akramhossain.muwattaimammalik.model.FavoritesModel;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@androidx.room.Dao
public interface FavoriteDao {

    @Query("SELECT * FROM favorites ORDER BY favorite_id DESC")
    LiveData<List<FavoritesModel>> getAllFavorites();

    @Query("SELECT * FROM favorites WHERE hadithnumber = :hadithNumber")
    LiveData<FavoritesModel> getHadithByNumber(int hadithNumber);

    @Query("DELETE FROM favorites WHERE hadithnumber = :hadithNumber")
    void deleteById(int hadithNumber);

    @Insert
    void insert(FavoritesModel model);

    @Delete
    void delete(FavoritesModel model);

    @Query("SELECT EXISTS(SELECT * FROM favorites WHERE hadithnumber = :hadithNumber)")
    boolean bookmarkExist(int hadithNumber);
}
