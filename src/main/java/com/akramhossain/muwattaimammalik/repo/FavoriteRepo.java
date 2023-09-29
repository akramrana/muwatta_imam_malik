package com.akramhossain.muwattaimammalik.repo;

import android.app.Application;
import android.os.AsyncTask;

import com.akramhossain.muwattaimammalik.HadithDatabase;
import com.akramhossain.muwattaimammalik.dao.FavoriteDao;
import com.akramhossain.muwattaimammalik.model.FavoritesModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;

public class FavoriteRepo {

    private FavoriteDao favoriteDao;

    public FavoriteRepo(Application application) {
        HadithDatabase database = HadithDatabase.getInstance(application);
        favoriteDao = database.FavoriteDao();
    }

    public LiveData<List<FavoritesModel>> getAllFavorite() {
        return favoriteDao.getAllFavorites();
    }

    public LiveData<FavoritesModel> getHadithByNumber(int id) {
        return favoriteDao.getHadithByNumber(id);
    }

    public void insert(FavoritesModel model) {
        new InsertAsyncTask(favoriteDao).execute(model);
    }

    private static class InsertAsyncTask extends AsyncTask<FavoritesModel, Void, Void> {
        private FavoriteDao dao;

        private InsertAsyncTask(FavoriteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(FavoritesModel... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    public void delete(FavoritesModel model) {
        new DeleteAsyncTask(favoriteDao).execute(model);
    }

    private static class DeleteAsyncTask extends AsyncTask<FavoritesModel, Void, Void> {
        private FavoriteDao dao;

        private DeleteAsyncTask(FavoriteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(FavoritesModel... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    public void deleteById(int id) {
        favoriteDao.deleteById(id);
    }

    public boolean bookmarkExist(int id){
        return favoriteDao.bookmarkExist(id);
    }
}
