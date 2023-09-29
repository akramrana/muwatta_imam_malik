package com.akramhossain.muwattaimammalik.viewmodel;

import android.app.Application;

import com.akramhossain.muwattaimammalik.model.LastReadingPositionModel;
import com.akramhossain.muwattaimammalik.model.LastReadingPositionWithBookModel;
import com.akramhossain.muwattaimammalik.repo.LastReadingPositionRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class LastReadingPositionViewModel extends AndroidViewModel {

    private LastReadingPositionRepo repository;

    public LastReadingPositionViewModel(@NonNull Application application) {
        super(application);
        repository = new LastReadingPositionRepo(application);
    }

    public LiveData<List<LastReadingPositionModel>> getAllReadingPosition() {
        return repository.getAllLastReadingPosition();
    }

    public void insert(LastReadingPositionModel model) {

        repository.insert(model);
    }

    public void delete() {

        repository.delete();
    }

    public LiveData<LastReadingPositionWithBookModel> getLastReadingData(){
        return repository.getLastReadingData();
    }

    public LastReadingPositionWithBookModel getLastReadingDataV2(){
        return repository.getLastReadingDataV2();
    }

}
