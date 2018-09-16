package io.github.teeyare.android_coding_challenge.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
@Dao
public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(Product... products);

    @Query("SELECT * FROM products WHERE itemId = :itemId")
    LiveData<Product> getProductById(String itemId);

    @Query("SELECT * FROM products")
    LiveData<List<Product>> getAll();

    @Query("DELETE FROM products")
    void deleteAll();
}
