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
public class CallActivity extends DialogFragment {
    OnCallDialogInteractionListener mListener;
    public CallActivity() {
        // Required empty public constructor
    }


    static CallActivity newInstance(){
        return new CallActivity();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof KontaktyFragment.OnListFragmentInteractionListener) {
            mListener = (OnCallDialogInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.call_callactivity) +"?");
        builder.setPositiveButton(getString(R.string.yes_callActivity), new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDialogPositiveClick(CallActivity.this);
            }
        });
        builder.setNegativeButton(getString(R.string.no_callActivity), new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDialogNegativeClick(CallActivity.this);
            }
        });
        return builder.create();
    }

    public interface OnCallDialogInteractionListener
    {
        void onDialogPositiveClick(DialogFragment dialog);
        void onDialogNegativeClick(DialogFragment dialog);
    }


}
