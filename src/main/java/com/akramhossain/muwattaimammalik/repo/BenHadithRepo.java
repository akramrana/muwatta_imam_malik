package com.akramhossain.muwattaimammalik.repo;

import android.app.Application;

import com.akramhossain.muwattaimammalik.HadithDatabase;
import com.akramhossain.muwattaimammalik.dao.BenHadithDao;
import com.akramhossain.muwattaimammalik.model.BenHadithModel;

import java.util.List;

import androidx.lifecycle.LiveData;

public class BenHadithRepo {

    private BenHadithDao benHadithDao;

    public BenHadithRepo(Application application) {
        HadithDatabase database = HadithDatabase.getInstance(application);
        benHadithDao = database.BenHadithDao();
    }

    public LiveData<List<BenHadithModel>> getAllHadith() {
        return benHadithDao.getAllHadith();
    }
}
