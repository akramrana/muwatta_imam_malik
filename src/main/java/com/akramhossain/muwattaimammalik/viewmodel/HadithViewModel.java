package com.akramhossain.muwattaimammalik.viewmodel;

import android.app.Application;

import com.akramhossain.muwattaimammalik.model.HadithsModel;
import com.akramhossain.muwattaimammalik.repo.HadithRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class HadithViewModel extends AndroidViewModel {

    private HadithRepo repository;

    private int hadithId;

    public HadithViewModel(@NonNull Application application) {
        super(application);
        repository = new HadithRepo(application);
    }

    public List<HadithsModel> getAllHadiths(String id) {
        return repository.getAllHadiths(id);
    }

    public LiveData<HadithsModel> getHadithById(int id){
        return repository.getHadithById(id);
    }

    public LiveData<List<HadithsModel>> getFavoriteHadithByKitab() {
        return repository.getFavoriteHadithByKitab();
    }

    public LiveData<List<HadithsModel>> getFavoriteHadiths() {
        return repository.getFavoriteHadiths();
    }

    public List<HadithsModel> searchAllHadiths(String id, String searchTxt) {
        return repository.searchAllHadiths(id, searchTxt);
    }

    public HadithsModel getPrevHadithById(int id){
        return repository.getPrevHadithById(id);
    }

    public HadithsModel getNextHadithById(int id){
        return repository.getNextHadithById(id);
    }

    public HadithsModel getHadithByIdV2(int id){
        return repository.getHadithByIdV2(id);
    }

    public List<HadithsModel> searchInAllHadiths(String searchTxt) {
        return repository.searchInAllHadiths(searchTxt);
    }

    public List<HadithsModel> globalSearchInAllHadiths(String searchTxt) {
        return repository.globalSearchInAllHadiths(searchTxt);
    }

}
