package com.example.zadanie_domowe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zadanie_domowe.Kontakty.KontaktyListContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements KontaktyFragment.OnListFragmentInteractionListener,
        CallActivity.OnCallDialogInteractionListener,
        DeleteDialog.OnDeleteDialogInteractionListener
{
    public static final String taskExtra = "taskExtra";
    private int currentItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.fragment_kontakt_add);
            }
        });
    }


    @Override
    public void onListFragmentClickInteraction(KontaktyListContent.KontatktItem kontatktItem, int position) {
        Toast.makeText(this,getString(R.string.item_choice) + position,Toast.LENGTH_SHORT).show();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            displayKontantyInFragment(kontatktItem);
        }else{
            startSecondActivity(kontatktItem,position);
        }
    }

    @Override
    public void onListFragmentInteraction(KontaktyListContent.KontatktItem Kontakt, int position) {

    }

    @Override
    public void onListFragmentLongClickInteraction(int position)
    {
        showCallActivity();
    }
    @SuppressLint("ResourceType")
    public void onDeleteClickInteraction(int position) {

        Toast.makeText(this,getString(R.string.long_click_msg) + position, Toast.LENGTH_SHORT).show();
        showDeleteDialog();
        currentItemPosition = position ;
    }


    @SuppressLint("ResourceType")
    public void addClick(View view)
    {
        EditText kontaktNameEditText = findViewById(R.id.KontaktName);
        EditText kontaktSurnameEditText = findViewById(R.id.KontaktSurname);
        EditText kontaktBirthdayEditText = findViewById(R.id.KontaktBirthday);
        EditText kontaktPhoneEditText = findViewById(R.id.KontaktPhone);

        String kontaktName = kontaktNameEditText.getText().toString();
        String kontaktSurname = kontaktSurnameEditText.getText().toString();
        String kontaktBirthday = kontaktBirthdayEditText.getText().toString();
        String kontaktPhone = kontaktPhoneEditText.getText().toString();

        int min=2;
        int max=16;
        int range = max - min + 1;
        int selectedImage = (int)(Math.random()* range) + min;
        if(kontaktName.isEmpty())
        {
            kontaktName = getString(R.string.empty_name);
        }

        if(kontaktSurname.isEmpty())
        {
            kontaktSurname =getString(R.string.empty_surname);
        }

        if(kontaktBirthday.isEmpty())
        {
            kontaktBirthday = getString(R.string.epmty_birthday);
        }

        if(kontaktPhone.isEmpty())
        {
            kontaktPhone = getString(R.string.empty_phone);
        }


        KontaktyListContent.addItem(new KontaktyListContent.KontatktItem("Kontakt."+
                KontaktyListContent.ITEMS.size()+1,
                kontaktName,
                kontaktSurname,
                kontaktBirthday,
                kontaktPhone,
                selectedImage));

        kontaktNameEditText.setText("");
        kontaktSurnameEditText.setText("");
        kontaktPhoneEditText.setText("");
        kontaktBirthdayEditText.setText("");

        InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    private void displayKontantyInFragment(KontaktyListContent.KontatktItem kontatktItem){
        KontaktyInfoFragment KontaktyInfoFragment = ((KontaktyInfoFragment)
                getSupportFragmentManager().findFragmentById(R.id.displayInfo));
        if(KontaktyInfoFragment != null){
            KontaktyInfoFragment.displayKontakty(kontatktItem);
        }
    }
    private void startSecondActivity(KontaktyListContent.KontatktItem kontatktItem, int position){
        Intent intent = new Intent(this,KontaktyInfoActivity.class);
        intent.putExtra(taskExtra,kontatktItem);
        startActivity(intent);
    }
    private void showCallActivity()
    {
        CallActivity.newInstance().show(getSupportFragmentManager(),getString(R.string.calling));
    }

    private void showDeleteDialog()
    {
        DeleteDialog.newInstance().show(getSupportFragmentManager(),getString(R.string.delete));
    }
    @Override
    public void onDialogPositiveClick(DialogFragment dialog){

    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog){

    }
    @Override
    public void onDeleteDialogNegativeClick(DialogFragment dialog){
        View v = findViewById(R.id.delete_button);
        if(v != null){
            Snackbar.make(v,getString(R.string.delete_cancel), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.yes_mainactivity), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showDeleteDialog();
                        }
                    }).show();
        }
    }

    @Override
    public void onDeleteDialogPositiveClick(DialogFragment dialog)
    {
        if(currentItemPosition != -1 && currentItemPosition < KontaktyListContent.ITEMS.size()){
            KontaktyListContent.removeItem(currentItemPosition);

        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
