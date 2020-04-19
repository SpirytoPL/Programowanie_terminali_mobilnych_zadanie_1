package com.example.zadanie_domowe;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zadanie_domowe.Kontakty.KontaktyListContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class KontaktyInfoFragment extends Fragment {

    public KontaktyInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kontakty_info, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        if(intent !=null){
            KontaktyListContent.KontatktItem received_Kontakt = intent.getParcelableExtra(MainActivity.taskExtra);
            if(received_Kontakt != null){
                displayKontakty(received_Kontakt);
            }
        }
    }
    public void displayKontakty(KontaktyListContent.KontatktItem kontatktItem)
    {
        FragmentActivity activity = getActivity();
        TextView KontaktName = activity.findViewById(R.id.KontaktInfoName);
        TextView KontaktBirthday = activity.findViewById(R.id.KontaktInfoBirthday);
        TextView KontaktPhone = activity.findViewById(R.id.KontaktInfoPhone);
        ImageView KontaktImage = activity.findViewById(R.id.KontaktInfoImage);

        KontaktName.setText(kontatktItem.name+" " +kontatktItem.surname);
        KontaktPhone.setText("Numer: "+kontatktItem.phone);
        KontaktBirthday.setText("Urodziny: "+kontatktItem.birthday);
        Drawable kontaktDrawable;
        switch(kontatktItem.picPath){
            case 2:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_2);
                break;
            case 3:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_3);
                break;
            case 4:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_4);
                break;
            case 5:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_5);
                break;
            case 6:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_6);
                break;
            case 7:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_7);
                break;
            case 8:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_8);
                break;
            case 9:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_9);
                break;
            case 10:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_10);
                break;
            case 11:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_11);
                break;
            case 12:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_12);
                break;
            case 13:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_13);
                break;
            case 14:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_14);
                break;
            case 15:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_15);
                break;
            case 16:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_16);
                break;

            default:
                kontaktDrawable = activity.getResources().getDrawable(R.drawable.avatar_1);
        }
        KontaktImage.setImageDrawable(kontaktDrawable);
    }

}
