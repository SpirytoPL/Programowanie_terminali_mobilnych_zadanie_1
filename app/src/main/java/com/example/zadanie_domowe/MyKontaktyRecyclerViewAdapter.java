package com.example.zadanie_domowe;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zadanie_domowe.Kontakty.KontaktyListContent;
import com.example.zadanie_domowe.KontaktyFragment.OnListFragmentInteractionListener;
import com.example.zadanie_domowe.Kontakty.KontaktyListContent.KontatktItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link KontatktItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyKontaktyRecyclerViewAdapter extends RecyclerView.Adapter<MyKontaktyRecyclerViewAdapter.ViewHolder> {

    private final List<KontatktItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyKontaktyRecyclerViewAdapter(List<KontatktItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_kontakty, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        KontatktItem kontatktItem =  mValues.get(position);
        holder.mItem = kontatktItem;
        //holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(kontatktItem.name);
        final int picPath = kontatktItem.picPath;
        Context context = holder.mView.getContext();
        Drawable kontaktDrawable;
        switch(picPath)
        {
            case 2:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_2);
                break;
            case 3:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_3);
                break;
            case 4:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_4);
                break;
            case 5:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_5);
                break;
            case 6:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_6);
                break;
            case 7:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_7);
                break;
            case 8:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_8);
                break;
            case 9:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_9);
                break;
            case 10:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_10);
                break;
            case 11:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_11);
                break;
            case 12:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_12);
                break;
            case 13:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_13);
                break;
            case 14:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_14);
                break;
            case 15:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_15);
                break;
            case 16:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_16);
                break;

            default:
                kontaktDrawable = context.getResources().getDrawable(R.drawable.avatar_1);
        }
        holder.mItemImageView.setImageDrawable(kontaktDrawable);

        holder.mItemImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onDeleteClickInteraction(position);

            }
        });
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onListFragmentLongClickInteraction(position);
                return false;
            }
        });
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentClickInteraction(holder.mItem, position);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final View mView;
        public final ImageButton mItemImageButton;
        public final ImageView mItemImageView;
        public final TextView mContentView;
        //public final ImageButton mDeleteButton;
        public KontaktyListContent.KontatktItem mItem;
        public final FloatingActionButton mItemFloatingActionButton;


        public ViewHolder(View view)
        {
            super(view);
            mView = view;
            mContentView =  view.findViewById(R.id.content);
            mItemFloatingActionButton= view.findViewById(R.id.floatingActionButton);
            mItemImageView =  view.findViewById(R.id.item_image);

            mItemImageButton = view.findViewById(R.id.thrashButton);

        }
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
