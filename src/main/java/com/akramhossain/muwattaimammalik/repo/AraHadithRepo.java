package com.akramhossain.muwattaimammalik.repo;

import android.app.Application;

import com.akramhossain.muwattaimammalik.HadithDatabase;
import com.akramhossain.muwattaimammalik.dao.AraHadithDao;
import com.akramhossain.muwattaimammalik.model.AraHadithModel;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AraHadithRepo {

    private AraHadithDao araHadithDao;

    public AraHadithRepo(Application application) {
        HadithDatabase database = HadithDatabase.getInstance(application);
        araHadithDao = database.AraHadithDao();
    }

    public LiveData<List<AraHadithModel>> getAllHadith() {
        return araHadithDao.getAllHadith();
    }

}
