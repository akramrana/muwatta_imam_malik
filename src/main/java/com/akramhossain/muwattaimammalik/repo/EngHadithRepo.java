package com.akramhossain.muwattaimammalik.repo;

import android.app.Application;

import com.akramhossain.muwattaimammalik.HadithDatabase;
import com.akramhossain.muwattaimammalik.dao.EngHadithDao;
import com.akramhossain.muwattaimammalik.model.EngHadithModel;

import java.util.List;

import androidx.lifecycle.LiveData;

public class EngHadithRepo {
    private EngHadithDao engHadithDao;

    public EngHadithRepo(Application application) {
        HadithDatabase database = HadithDatabase.getInstance(application);
        engHadithDao = database.EngHadithDao();
    }

    public LiveData<List<EngHadithModel>> getAllHadith() {
        return engHadithDao.getAllHadith();
    }
}
