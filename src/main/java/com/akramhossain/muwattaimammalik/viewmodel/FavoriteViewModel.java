package com.akramhossain.muwattaimammalik.viewmodel;

import android.app.Application;

import com.akramhossain.muwattaimammalik.model.FavoritesModel;
import com.akramhossain.muwattaimammalik.repo.FavoriteRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class FavoriteViewModel extends AndroidViewModel {

    private FavoriteRepo repository;

    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        repository = new FavoriteRepo(application);
    }

    public LiveData<List<FavoritesModel>> getAllFavorite() {
        return repository.getAllFavorite();
    }

    public LiveData<FavoritesModel> getHadithByNumber(int id){
        return repository.getHadithByNumber(id);
    }

    public void insert(FavoritesModel model) {
        repository.insert(model);
    }

    public void delete(FavoritesModel model) {
        repository.delete(model);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public boolean bookmarkExist(int id){
       return repository.bookmarkExist(id);
    }
}
