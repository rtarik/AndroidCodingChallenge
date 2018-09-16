package io.github.teeyare.android_coding_challenge.data.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by teeyare (tarik) on 9/15/18.
 *
 * Simple class defining POJOs
 */
@Entity(tableName = "products")
public class Product {

    @NonNull @PrimaryKey
    private String itemId;
    private double value;
    private String currency;
    private String title;
    private Description description;

    public Product(@NonNull String itemId, double value, String currency, String title, Description description) {
        this.itemId = itemId;
        this.value = value;
        this.currency = currency;
        this.title = title;
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public static class Description {
        @SerializedName("en-CA")
        private String en_CA;
        @SerializedName("fr-CA")
        private String fr_CA;

        public Description(String en_CA, String fr_CA) {
            this.en_CA = en_CA;
            this.fr_CA = fr_CA;
        }

        public String getEn_CA() {
            return en_CA;
        }

        public void setEn_CA(String en_CA) {
            this.en_CA = en_CA;
        }

        public String getFr_CA() {
            return fr_CA;
        }

        public void setFr_CA(String fr_CA) {
            this.fr_CA = fr_CA;
        }
    }
}
