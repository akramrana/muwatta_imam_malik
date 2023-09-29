package com.akramhossain.muwattaimammalik;

import android.content.Context;
import android.os.AsyncTask;

import com.akramhossain.muwattaimammalik.dao.AraHadithDao;
import com.akramhossain.muwattaimammalik.dao.BenHadithDao;
import com.akramhossain.muwattaimammalik.dao.BookDao;
import com.akramhossain.muwattaimammalik.dao.EngHadithDao;
import com.akramhossain.muwattaimammalik.dao.FavoriteDao;
import com.akramhossain.muwattaimammalik.dao.HadithDao;
import com.akramhossain.muwattaimammalik.dao.LastReadingPositionDao;
import com.akramhossain.muwattaimammalik.model.AraHadithModel;
import com.akramhossain.muwattaimammalik.model.BenHadithModel;
import com.akramhossain.muwattaimammalik.model.BooksModel;
import com.akramhossain.muwattaimammalik.model.EngHadithModel;
import com.akramhossain.muwattaimammalik.model.FavoritesModel;
import com.akramhossain.muwattaimammalik.model.HadithsModel;
import com.akramhossain.muwattaimammalik.model.LastReadingPositionModel;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
        entities = {
                FavoritesModel.class,
                LastReadingPositionModel.class,
                BooksModel.class,
                AraHadithModel.class,
                EngHadithModel.class,
                BenHadithModel.class,
        },
        views = {
                HadithsModel.class,
        },
        version = 1)
public abstract class HadithDatabase extends RoomDatabase {

    private static HadithDatabase instance;

    public static synchronized HadithDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    HadithDatabase.class, "muwatta_malik.db")
                    .createFromAsset("databases/muwatta_malik.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract BookDao BookDao();

    public abstract FavoriteDao FavoriteDao();

    public abstract LastReadingPositionDao LastReadingPositionDao();

    public abstract EngHadithDao EngHadithDao();

    public abstract AraHadithDao AraHadithDao();

    public abstract BenHadithDao BenHadithDao();

    public abstract HadithDao HadithDao();
}
