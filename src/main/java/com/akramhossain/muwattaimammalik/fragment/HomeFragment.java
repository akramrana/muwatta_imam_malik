package com.akramhossain.muwattaimammalik.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.akramhossain.muwattaimammalik.R;
import com.akramhossain.muwattaimammalik.adapter.BookRVAdapter;
import com.akramhossain.muwattaimammalik.model.BooksModel;
import com.akramhossain.muwattaimammalik.repo.BooksRepo;
import com.akramhossain.muwattaimammalik.viewmodel.BookViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements SearchView.OnQueryTextListener{

    private RecyclerView recyclerview;

    private BookViewModel bookViewModel;

    private ArrayList<BooksModel> books;

    BookRVAdapter adapter;

    private BooksRepo repository;
    private LiveData<List<BooksModel>> allBooks;

    TextView title;

    SearchView search;

    String searchTxt = "";
    Handler mHandler = new Handler();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contentView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerview = (RecyclerView) contentView.findViewById(R.id.book_list);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setHasFixedSize(true);
        //setRecyclerViewAdapter();
        adapter = new BookRVAdapter(getActivity());
        recyclerview.setAdapter(adapter);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        getData("");

        return contentView;
    }

    public void getData(String searchTxt){
        if(searchTxt.equals("")) {
            bookViewModel.getAllBooks().observe(getActivity(), new Observer<List<BooksModel>>() {
                @Override
                public void onChanged(List<BooksModel> models) {
                    //Log.d("DATA",models.toString());
                    adapter.submitList(models);
                }
            });
        }else{
            bookViewModel.searchAllBooks(searchTxt).observe(getActivity(), new Observer<List<BooksModel>>() {
                @Override
                public void onChanged(List<BooksModel> models) {
                    //Log.d("DATA",models.toString());
                    adapter.submitList(models);
                }
            });
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        searchTxt = query;
        mHandler.removeCallbacksAndMessages(null);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int length = searchTxt.length();
                if(length > 0) {
                    getData(searchTxt.trim());
                }else{
                    getData("");
                }
            }
        }, 100);

        return true;
    }
}