package com.akramhossain.muwattaimammalik.dao;

import com.akramhossain.muwattaimammalik.model.LastReadingPositionModel;
import com.akramhossain.muwattaimammalik.model.LastReadingPositionWithBookModel;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

@androidx.room.Dao
public interface LastReadingPositionDao {

    @Query("SELECT * FROM last_reading_position ORDER BY last_reading_id DESC")
    LiveData<List<LastReadingPositionModel>> getAllLastReadingPosition();

    @Insert
    void insert(LastReadingPositionModel model);

    @Query("DELETE FROM last_reading_position")
    void deleteAll();

    @Query("SELECT last_reading_position.last_reading_id,last_reading_position.position,last_reading_position.reference_book,books.name_ar,books.name_en,books.name_bn, books.bid\n" +
            "FROM last_reading_position \n" +
            "INNER JOIN books ON books.reference_book = last_reading_position.reference_book \n" +
            "ORDER BY last_reading_id DESC LIMIT 1")
    LiveData<LastReadingPositionWithBookModel> getLastReadingData();

    @Query("SELECT last_reading_position.last_reading_id,last_reading_position.position,last_reading_position.reference_book,books.name_ar,books.name_en,books.name_bn, books.bid\n" +
            "FROM last_reading_position \n" +
            "INNER JOIN books ON books.reference_book = last_reading_position.reference_book \n" +
            "ORDER BY last_reading_id DESC LIMIT 1")
    LastReadingPositionWithBookModel getLastReadingDataV2();
}
