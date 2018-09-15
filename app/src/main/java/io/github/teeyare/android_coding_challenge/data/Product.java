package io.github.teeyare.android_coding_challenge.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
@Entity(tableName = "products")
public class Product {

    @PrimaryKey
    private String itemId;
    private double value;
    private String currency;
    private String title;
    private Description description;

    public Product(String itemId, String currency, String title, Description description) {
        this.itemId = itemId;
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
        private String en_CA;
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
