package com.akramhossain.muwattaimammalik.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akramhossain.muwattaimammalik.R;
import com.akramhossain.muwattaimammalik.model.BooksModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BookRVAdapter extends ListAdapter<BooksModel,BookRVAdapter.ViewHolder>{

    Typeface fontUthmani, fontKalpurush;

    private OnItemClickListener listener;

    SharedPreferences mPrefs;

    public BookRVAdapter(Context c) {
        super(DIFF_CALLBACK);
        fontUthmani = Typeface.createFromAsset(c.getAssets(),"fonts/KFGQPC_Uthmanic_Script_HAFS_Regular.ttf");
        fontKalpurush = Typeface.createFromAsset(c.getAssets(),"fonts/kalpurush.ttf");

        mPrefs = PreferenceManager.getDefaultSharedPreferences(c);
    }

    private static final DiffUtil.ItemCallback<BooksModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<BooksModel>() {
        @Override
        public boolean areItemsTheSame(BooksModel oldItem, BooksModel newItem) {
            return oldItem.getBid() == newItem.getBid();
        }

        @Override
        public boolean areContentsTheSame(BooksModel oldItem, BooksModel newItem) {
            return oldItem.getName_bn().equals(newItem.getName_bn()) && oldItem.getName_en().equals(newItem.getName_en());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BooksModel model = getSectionAt(position);

        String nameEn = Html.fromHtml(model.getName_en()).toString();
        holder.name_en.setText(nameEn);

        String nameBn = Html.fromHtml(model.getName_bn()).toString();
        holder.name_bn.setText(nameBn);

        String nameAr = Html.fromHtml(model.getName_ar()).toString();
        holder.name_ar.setText(nameAr);

        holder.ref_book.setText("Reference Book: "+model.getReference_book());

    }

    public BooksModel getSectionAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name_en,name_bn, name_ar, ref_book;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_en = itemView.findViewById(R.id.name_en);
            name_bn = itemView.findViewById(R.id.name_bn);
            name_bn.setTypeface(fontKalpurush);
            name_ar = itemView.findViewById(R.id.name_ar);
            name_ar.setTypeface(fontUthmani);
            ref_book = itemView.findViewById(R.id.ref_book);

            String mp_arFz = mPrefs.getString("arFontSize", "15");
            String mp_enFz = mPrefs.getString("enFontSize", "15");
            String mp_bnFz = mPrefs.getString("bnFontSize", "15");

            if(!mp_arFz.equals("")){
                name_ar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_arFz));
            }
            if(!mp_enFz.equals("")){
                name_en.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_enFz));
                ref_book.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_enFz));
            }
            if(!mp_bnFz.equals("")){
                name_bn.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_bnFz));
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(BooksModel model);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
