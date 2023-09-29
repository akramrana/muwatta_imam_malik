package com.akramhossain.muwattaimammalik.dao;

import com.akramhossain.muwattaimammalik.model.EngHadithModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

@androidx.room.Dao
public interface EngHadithDao {

    @Query("SELECT * FROM eng_hadiths ORDER BY hid DESC")
    LiveData<List<EngHadithModel>> getAllHadith();
}
