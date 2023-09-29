package com.akramhossain.muwattaimammalik.repo;

import android.app.Application;

import com.akramhossain.muwattaimammalik.HadithDatabase;
import com.akramhossain.muwattaimammalik.dao.BookDao;
import com.akramhossain.muwattaimammalik.model.BooksModel;

import java.util.List;
import androidx.lifecycle.LiveData;

public class BooksRepo {

    private BookDao bookDao;

    public BooksRepo(Application application) {
        HadithDatabase database = HadithDatabase.getInstance(application);
        bookDao = database.BookDao();
    }

    public LiveData<List<BooksModel>> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public LiveData<List<BooksModel>> searchAllBooks(String search) {
        return bookDao.searchAllBooks(search);
    }
}
