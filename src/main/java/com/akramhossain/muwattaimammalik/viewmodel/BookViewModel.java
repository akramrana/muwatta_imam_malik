package com.akramhossain.muwattaimammalik.viewmodel;

import android.app.Application;

import com.akramhossain.muwattaimammalik.model.BooksModel;
import com.akramhossain.muwattaimammalik.repo.BooksRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class BookViewModel extends AndroidViewModel {

    private BooksRepo repository;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BooksRepo(application);
    }

    public LiveData<List<BooksModel>> getAllBooks() {
        return repository.getAllBooks();
    }

    public LiveData<List<BooksModel>> searchAllBooks(String searchTxt) {
        return repository.searchAllBooks(searchTxt);
    }
}
