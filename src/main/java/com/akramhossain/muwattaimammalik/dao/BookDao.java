package com.akramhossain.muwattaimammalik.dao;

import com.akramhossain.muwattaimammalik.model.BooksModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

@androidx.room.Dao
public interface BookDao {

    @Query("SELECT * FROM books ORDER BY CAST(reference_book as INTEGER) ASC")
    LiveData<List<BooksModel>> getAllBooks();

    @Query("SELECT * FROM books WHERE (name_ar LIKE '%' || :search || '%' OR name_bn LIKE '%' || :search || '%' OR name_en LIKE '%' || :search || '%') ORDER BY CAST(reference_book as INTEGER) ASC")
    LiveData<List<BooksModel>> searchAllBooks(String search);
}
