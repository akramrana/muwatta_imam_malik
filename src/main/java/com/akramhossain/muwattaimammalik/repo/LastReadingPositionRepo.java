package com.akramhossain.muwattaimammalik.repo;

import android.app.Application;
import android.os.AsyncTask;

import com.akramhossain.muwattaimammalik.HadithDatabase;
import com.akramhossain.muwattaimammalik.dao.LastReadingPositionDao;
import com.akramhossain.muwattaimammalik.model.LastReadingPositionModel;
import com.akramhossain.muwattaimammalik.model.LastReadingPositionWithBookModel;

import java.util.List;

import androidx.lifecycle.LiveData;

public class LastReadingPositionRepo {

    private LastReadingPositionDao lastReadingPositionDao;

    public LastReadingPositionRepo(Application application) {
        HadithDatabase database = HadithDatabase.getInstance(application);
        lastReadingPositionDao = database.LastReadingPositionDao();
    }

    public LiveData<List<LastReadingPositionModel>> getAllLastReadingPosition() {
        return lastReadingPositionDao.getAllLastReadingPosition();
    }

    public void insert(LastReadingPositionModel model) {
        new InsertAsyncTask(lastReadingPositionDao).execute(model);
    }

    public void delete() {

        new DeleteAllAsyncTask(lastReadingPositionDao).execute();
    }

    private static class InsertAsyncTask extends AsyncTask<LastReadingPositionModel, Void, Void> {
        private LastReadingPositionDao dao;

        private InsertAsyncTask(LastReadingPositionDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(LastReadingPositionModel... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private LastReadingPositionDao dao;
        private DeleteAllAsyncTask(LastReadingPositionDao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            // on below line calling method
            // to delete all courses.
            dao.deleteAll();
            return null;
        }
    }

    public LiveData<LastReadingPositionWithBookModel> getLastReadingData() {
        return lastReadingPositionDao.getLastReadingData();
    }

    public LastReadingPositionWithBookModel getLastReadingDataV2() {
        return lastReadingPositionDao.getLastReadingDataV2();
    }
}
