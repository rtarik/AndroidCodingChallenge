package io.github.teeyare.android_coding_challenge.utils;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import io.github.teeyare.android_coding_challenge.data.database.Product;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
public class DescriptionConverter {
    /**
     * Converts a description object to a JSON String
     * @param description in JSON format
     * @return JSON string representation
     */
    @TypeConverter
    public static String toString(Product.Description description) {
        Gson gson = new Gson();

        return gson.toJson(description);
    }

    /**
     * Converts the JSON String representation to a Description object
     * @param json JSON string
     * @return Description object
     */
    @TypeConverter
    public static Product.Description toDescription(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Product.Description.class);
    }
}
