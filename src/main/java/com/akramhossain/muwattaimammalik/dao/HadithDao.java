package com.akramhossain.muwattaimammalik.dao;

import com.akramhossain.muwattaimammalik.model.HadithsModel;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

@androidx.room.Dao
public interface HadithDao {

    @RawQuery(observedEntities = HadithsModel.class)
    List<HadithsModel> getAllHadiths(SupportSQLiteQuery query);

    @RawQuery(observedEntities = HadithsModel.class)
    LiveData<HadithsModel> getHadithById(SupportSQLiteQuery query);

    @RawQuery(observedEntities = HadithsModel.class)
    LiveData<List<HadithsModel>> getFavoriteHadiths(SupportSQLiteQuery query);

    @RawQuery(observedEntities = HadithsModel.class)
    List<HadithsModel> searchAllHadiths(SupportSQLiteQuery query);

    @RawQuery(observedEntities = HadithsModel.class)
    HadithsModel getHadithByIdV2(SupportSQLiteQuery query);

    @RawQuery(observedEntities = HadithsModel.class)
    List<HadithsModel> globalSearchAllHadiths(SupportSQLiteQuery query);
}