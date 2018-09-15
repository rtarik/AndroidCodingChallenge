package io.github.teeyare.android_coding_challenge.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
@Dao
public interface ProductDao {
    @Insert
    void bulkInsert(Product... products);

    @Query("SELECT * FROM products WHERE itemId = :itemId")
    Product getProductById(String itemId);
}
