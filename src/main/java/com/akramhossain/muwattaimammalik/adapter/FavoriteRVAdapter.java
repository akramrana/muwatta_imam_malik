package com.akramhossain.muwattaimammalik.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.akramhossain.muwattaimammalik.R;
//import com.akramhossain.muwattaimammalik.ShareVerseFragment;
import com.akramhossain.muwattaimammalik.model.HadithsModel;
import com.akramhossain.muwattaimammalik.viewmodel.FavoriteViewModel;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class FavoriteRVAdapter extends ListAdapter<HadithsModel, FavoriteRVAdapter.ViewHolder> {

    Typeface fontUthmani, fontKalpurush;

    private OnItemClickListener listener;

    FragmentActivity c;

    private FavoriteViewModel favoriteViewModel;

    SharedPreferences mPrefs;

    public FavoriteRVAdapter(FragmentActivity c, FavoriteViewModel favoriteViewModel) {
        super(DIFF_CALLBACK);
        fontUthmani = Typeface.createFromAsset(c.getAssets(), "fonts/KFGQPC_Uthmanic_Script_HAFS_Regular.ttf");
        fontKalpurush = Typeface.createFromAsset(c.getAssets(), "fonts/kalpurush.ttf");

        this.c = c;
        this.favoriteViewModel = favoriteViewModel;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(c);
    }

    private static final DiffUtil.ItemCallback<HadithsModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<HadithsModel>() {
        @Override
        public boolean areItemsTheSame(HadithsModel oldItem, HadithsModel newItem) {
            return oldItem.getHid() == newItem.getHid();
        }

        @Override
        public boolean areContentsTheSame(HadithsModel oldItem, HadithsModel newItem) {
            //return oldItem.getText_bn().equals(newItem.getText_bn()) && oldItem.getText_en().equals(newItem.getText_en());
            if (oldItem.getText_bn() != null && !oldItem.getText_bn().equals("") && newItem.getText_bn() != null && !newItem.getText_bn().equals("") && oldItem.getText_en() != null && !oldItem.getText_en().equals("") && newItem.getText_en() != null && !newItem.getText_en().equals("")) {
                return oldItem.getText_bn().equals(newItem.getText_bn()) && oldItem.getText_en().equals(newItem.getText_en());
            } else {
                return true;
            }
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_hadith_list, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HadithsModel model = getSectionAt(position);

        String nameEn = "";
        if (model.getText_en() != null && !model.getText_en().equals("")) {
            String textEn = HtmlCompat.fromHtml(model.getText_en(), HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
            nameEn = HtmlCompat.fromHtml(textEn, HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
        }
        holder.text_en.setText(nameEn);

        String nameBn = "";
        if (model.getText_bn() != null && !model.getText_bn().equals("")) {
            String textBn = HtmlCompat.fromHtml(model.getText_bn(), HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
            nameBn = HtmlCompat.fromHtml(textBn, HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
        }
        holder.text_bn.setText(nameBn);

        String nameAr = "";
        if (model.getText_ar() != null && !model.getText_ar().equals("")) {
            String textAr = HtmlCompat.fromHtml(model.getText_ar(), HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
            nameAr = HtmlCompat.fromHtml(textAr, HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
        }
        holder.text_ar.setText(nameAr);

        holder.ref.setText("Reference Book: " + model.getBook_en() + "\nHadith: " + model.getHadithnumber());

        String grades = "";
        if (model.getGrades() != null && !model.getGrades().equals("")) {
            grades = "Grades: "+model.getGrades();
        }
        holder.grades.setText(grades);

        holder.copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nameEn = "";
                    if (model.getText_en() != null && !model.getText_en().equals("")) {
                        String textEn = HtmlCompat.fromHtml(model.getText_en(), HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
                        nameEn = HtmlCompat.fromHtml(textEn, HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
                    }

                    String nameBn = "";
                    if (model.getText_bn() != null && !model.getText_bn().equals("")) {
                        String textBn = HtmlCompat.fromHtml(model.getText_bn(), HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
                        nameBn = HtmlCompat.fromHtml(textBn, HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
                    }

                    String nameAr = "";
                    if (model.getText_ar() != null && !model.getText_ar().equals("")) {
                        String textAr = HtmlCompat.fromHtml(model.getText_ar(), HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
                        nameAr = HtmlCompat.fromHtml(textAr, HtmlCompat.FROM_HTML_MODE_COMPACT).toString();
                    }

                    String grades = "";
                    if (model.getGrades() != null && !model.getGrades().equals("")) {
                        grades = "Grades: "+model.getGrades();
                    }

                    String fullHadith = nameAr + "\n\n" + nameBn + "\n\n" + "\nঅধ্যায়: " + model.getBook_bn() + "\n\n" + nameEn + "\n\n" + "\nReference Book: " + model.getBook_en()+"\n\n"+grades;
                    String label = "Reference Book: " + model.getBook_en() + ", Hadith Number: " + model.getHadithnumber();

                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) c.getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText(label, fullHadith);
                    clipboard.setPrimaryClip(clip);

                    Toast.makeText(c.getApplicationContext(), "Copied.", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e("copy error", e.getMessage());
                }
            }
        });

        /*holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("hadith_id", Integer.toString(model.getHid()));
                    bundle.putString("kitab_id", Integer.toString(model.getKitab_id()));

                    ShareVerseFragment shareVerseFragment = new ShareVerseFragment();
                    shareVerseFragment.setArguments(bundle);

                    c.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.appFragment, shareVerseFragment)
                            .addToBackStack(null)
                            .commit();

                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
            }
        });*/

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    favoriteViewModel.deleteById(model.getHadithnumber());
                    Toast.makeText(c.getApplicationContext(), "Hadith removed from your favorite", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
            }
        });
    }

    public HadithsModel getSectionAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_en, text_bn, text_ar, ref, grades;
        Button deleteBtn, copyButton, shareButton;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_en = itemView.findViewById(R.id.text_en);
            text_bn = itemView.findViewById(R.id.text_bn);
            text_bn.setTypeface(fontKalpurush);
            text_ar = itemView.findViewById(R.id.text_ar);
            text_ar.setTypeface(fontUthmani);

            ref = itemView.findViewById(R.id.ref);
            grades = itemView.findViewById(R.id.grades);

            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            copyButton = itemView.findViewById(R.id.copyButton);
            shareButton = itemView.findViewById(R.id.shareButton);

            String mp_arFz = mPrefs.getString("arFontSize", "15");
            String mp_enFz = mPrefs.getString("enFontSize", "15");
            String mp_bnFz = mPrefs.getString("bnFontSize", "15");

            if (!mp_arFz.equals("")) {
                text_ar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_arFz));
            }
            if (!mp_enFz.equals("")) {
                text_en.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_enFz));
                ref.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_enFz));
            }
            if (!mp_bnFz.equals("")) {
                text_bn.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Integer.parseInt(mp_bnFz));
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
        void onItemClick(HadithsModel model);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
