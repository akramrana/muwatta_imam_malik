package com.akramhossain.muwattaimammalik.repo;

import android.app.Application;
import android.util.Log;

import com.akramhossain.muwattaimammalik.HadithDatabase;
import com.akramhossain.muwattaimammalik.dao.HadithDao;
import com.akramhossain.muwattaimammalik.model.HadithsModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;

public class HadithRepo {

    private HadithDao hadithDao;

    public HadithRepo(Application application) {
        HadithDatabase database = HadithDatabase.getInstance(application);
        hadithDao = database.HadithDao();
    }

    public List<HadithsModel> getAllHadiths(String id) {
        String query = "SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE hadiths.reference_book = "+id+" and (hadiths.text_bn !=\"\" or hadiths.text_ar !=\"\" or hadiths.text_en !=\"\") " +
                "ORDER BY hid ASC";
        Log.d("SQL",query);
        return hadithDao.getAllHadiths( new SimpleSQLiteQuery(query));
    }

    public LiveData<HadithsModel> getHadithById(int id) {
        return hadithDao.getHadithById(new SimpleSQLiteQuery("SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE hadiths.hid = "+id));
    }

    public LiveData<List<HadithsModel>> getFavoriteHadithByKitab() {
        String sql = "SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE hadiths.hadithnumber IN(SELECT hadithnumber FROM favorites) " +
                "ORDER BY hid ASC";
        Log.d("bookmark Terms",sql);
        return hadithDao.getFavoriteHadiths( new SimpleSQLiteQuery(sql));
    }

    public LiveData<List<HadithsModel>> getFavoriteHadiths() {
        String sql = "SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "INNER join favorites ON favorites.hadithnumber = hadiths.hadithnumber and favorites.kitab_id = hadiths.kitab_id " +
                "ORDER BY favorites.favorite_id DESC";
        Log.d("bookmark Terms",sql);
        return hadithDao.getFavoriteHadiths( new SimpleSQLiteQuery(sql));
    }

    public List<HadithsModel> searchAllHadiths(String id, String searchTxt) {
        String sql = "SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE hadiths.reference_book = "+id+" and (hadiths.text_bn !=\"\" or hadiths.text_ar !=\"\" or hadiths.text_en !=\"\") and (hadiths.text_bn like \"%"+searchTxt+"%\" or hadiths.text_en like \"%"+searchTxt+"%\" or hadiths.text_ar like \"%"+searchTxt+"%\" or hadiths.hadithnumber like \"%"+searchTxt+"%\" or hadiths.reference_hadith like \"%"+searchTxt+"%\") " +
                "ORDER BY hid ASC";
        Log.d("SQL",sql);
        return hadithDao.searchAllHadiths( new SimpleSQLiteQuery(sql));
    }

    public HadithsModel getPrevHadithById(int id) {
        return hadithDao.getHadithByIdV2(new SimpleSQLiteQuery("SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE hadiths.hid < "+id+" " +
                "ORDER BY hid DESC " +
                "limit 1"));
    }

    public HadithsModel getNextHadithById(int id) {
        return hadithDao.getHadithByIdV2(new SimpleSQLiteQuery("SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE hadiths.hid > "+id+" " +
                "ORDER BY hid ASC " +
                "limit 1"));
    }

    public HadithsModel getHadithByIdV2(int id) {
        return hadithDao.getHadithByIdV2(new SimpleSQLiteQuery("SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE hadiths.hid = "+id));
    }

    public List<HadithsModel> searchInAllHadiths(String terms) {
        String searchSql = "SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE (hadiths.text_bn !=\"\" or hadiths.text_ar !=\"\" or hadiths.text_en !=\"\") and ((hadiths.text_bn like \"%"+terms+"%\" or hadiths.text_en like \"%"+terms+"%\" or hadiths.text_ar like \"%"+terms+"%\" or hadiths.hadithnumber like \"%"+terms+"%\" or hadiths.reference_hadith like \"%"+terms+"%\")) " +
                "ORDER BY hid ASC";
        Log.d("Search Terms",searchSql);
        return hadithDao.searchAllHadiths(new SimpleSQLiteQuery(searchSql));
    }

    public List<HadithsModel> globalSearchInAllHadiths(String terms) {
        String searchSql = "SELECT hadiths.*,books.name_ar as book_ar,books.name_en as book_en,books.name_bn as book_bn,(select count(favorite_id) from favorites where favorites.hadithnumber = hadiths.hadithnumber) as is_favorite " +
                "FROM hadiths " +
                "INNER join books ON books.reference_book = hadiths.reference_book and books.kitab_id = hadiths.kitab_id " +
                "WHERE (hadiths.text_bn !=\"\" or hadiths.text_ar !=\"\" or hadiths.text_en !=\"\") and ((hadiths.text_bn like \"%"+terms+"%\" or hadiths.text_en like \"%"+terms+"%\" or hadiths.text_ar like \"%"+terms+"%\" or hadiths.hadithnumber like \"%"+terms+"%\" or hadiths.reference_hadith like \"%"+terms+"%\")) " +
                "ORDER BY hid ASC " +
                "limit 500";
        Log.d("Search Terms",searchSql);
        return hadithDao.globalSearchAllHadiths(new SimpleSQLiteQuery(searchSql));
    }
}
