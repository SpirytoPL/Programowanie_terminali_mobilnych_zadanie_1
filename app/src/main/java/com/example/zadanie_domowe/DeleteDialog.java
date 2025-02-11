package com.example.zadanie_domowe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteDialog extends DialogFragment {
    OnDeleteDialogInteractionListener mListener;
    public DeleteDialog() {
        // Required empty public constructor
    }


    public static DeleteDialog newInstance(){
        return new DeleteDialog();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof KontaktyFragment.OnListFragmentInteractionListener) {
            mListener = (DeleteDialog.OnDeleteDialogInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.delete_message));
        builder.setPositiveButton(getString(R.string.comfirmed), new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDeleteDialogPositiveClick(DeleteDialog.this);
            }
        });
        builder.setNegativeButton(getString(R.string.undo_dialog), new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDeleteDialogNegativeClick(DeleteDialog.this);
            }
        });
        return builder.create();

    }

    public interface OnDeleteDialogInteractionListener
    {
        void onDeleteDialogNegativeClick(DialogFragment dialog);
        void onDeleteDialogPositiveClick(DialogFragment dialog);

    }


}


