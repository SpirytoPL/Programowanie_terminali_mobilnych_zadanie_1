package com.example.zadanie_domowe.Kontakty;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class KontaktyListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<KontatktItem> ITEMS = new ArrayList<KontatktItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, KontatktItem> ITEM_MAP = new HashMap<String, KontatktItem>();

    private static final int COUNT =7;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(KontatktItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void removeItem(int position) {
        String itemId = ITEMS.get(position).id;
        ITEMS.remove(position);
        ITEM_MAP.remove(itemId);
    }

    public static KontatktItem createDummyItem(int position) {
        return new KontatktItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
   /* public static class Task implements Parcelable {
        public final String id;
        public final String title;
        public final String details;
        public final String picPath;*/
    public static class KontatktItem implements Parcelable {
        public final String id;
        public final String name;
        public final String surname;
        public final String phone;
        public final String birthday;
        public final int picPath;

        public KontatktItem(String id, String name, String surname) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthday = "";
            this.phone = "";
            int min = 2;
            int max = 16;
            int range = max - min + 1;
            this.picPath = (int)(Math.random()*range) + min;
        }
        public KontatktItem(String id, String name, String surname, String birthday, String phone, int picPath)
        {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthday= birthday;
            this.phone = phone;
            this.picPath = picPath;
        }

        protected KontatktItem(Parcel in) {
            id=in.readString();
            name = in.readString();
            surname = in.readString();
            phone = in.readString();
            birthday=in.readString();
            picPath = in.readInt();
        }

        public static final Creator<KontatktItem> CREATOR = new Creator<KontatktItem>() {
            @Override
            public KontatktItem createFromParcel(Parcel in) {
                return new KontatktItem(in);
            }

            @Override
            public KontatktItem[] newArray(int size) {
                return new KontatktItem[size];
            }
        };

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(name);
            dest.writeString(surname);
            dest.writeString(phone);
            dest.writeString(birthday);
            dest.writeInt(picPath);
        }
    }
}
