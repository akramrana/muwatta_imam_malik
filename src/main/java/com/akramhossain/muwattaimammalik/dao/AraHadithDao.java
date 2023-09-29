package com.akramhossain.muwattaimammalik.dao;

import com.akramhossain.muwattaimammalik.model.AraHadithModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

@androidx.room.Dao
public interface AraHadithDao {

    @Query("SELECT * FROM ara_hadiths ORDER BY hid DESC")
    LiveData<List<AraHadithModel>> getAllHadith();

}
