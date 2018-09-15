package io.github.teeyare.android_coding_challenge.utils;

import android.arch.persistence.room.TypeConverter;

import io.github.teeyare.android_coding_challenge.data.Product;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
public class DescriptionConverter {
    /**
     * Converts a description object to a String by splitting its two parts by a | character
     * @param description assumed that its parts don't contain the | character
     * @return string representation
     */
    @TypeConverter
    public static String toString(Product.Description description) {
        return description.getEn_CA() + "|" + description.getFr_CA();
    }

    /**
     * Converts the String representation to a Description object
     * @param string assumed to have only one | character which separates the two parts
     *               en_CA being first and then fr_CA
     * @return Description object
     */
    @TypeConverter
    public static Product.Description toDescription(String string) {
        String[] parts = string.split("|");
        return new Product.Description(parts[0], parts[1]);
    }
}
