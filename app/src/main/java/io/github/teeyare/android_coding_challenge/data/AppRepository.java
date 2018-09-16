package io.github.teeyare.android_coding_challenge.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import io.github.teeyare.android_coding_challenge.data.network.ProductNetworkDataSource;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class AppRepository {
    private static AppRepository instance;
    private static final Object LOCK = new Object();

    private ProductDao dao;
    private ProductNetworkDataSource dataSource;

    private AppRepository(final ProductDao dao, ProductNetworkDataSource dataSource) {
        this.dao = dao;
        this.dataSource = dataSource;

        dataSource.getDownloadedProducts().observeForever(new Observer<Product[]>() {
            @Override
            public void onChanged(@Nullable Product[] products) {
                dao.bulkInsert(products);
            }
        });
    }

    public static AppRepository getInstance(ProductDao dao,
                                                         ProductNetworkDataSource dataSource) {
        if (instance == null) {
            synchronized (LOCK) {
                instance = new AppRepository(dao, dataSource);
            }
        }
        return instance;
    }

    public LiveData<List<Product>> getProducts() {
        dataSource.fetchProducts();
        return dao.getAll();
    }
}
