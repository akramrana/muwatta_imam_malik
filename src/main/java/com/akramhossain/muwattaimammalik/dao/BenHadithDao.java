package com.akramhossain.muwattaimammalik.dao;

import com.akramhossain.muwattaimammalik.model.BenHadithModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

@androidx.room.Dao
public interface BenHadithDao {

    @Query("SELECT * FROM ben_hadiths ORDER BY hid DESC")
    LiveData<List<BenHadithModel>> getAllHadith();
}
