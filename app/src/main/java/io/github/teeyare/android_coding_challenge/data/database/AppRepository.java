package io.github.teeyare.android_coding_challenge.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import io.github.teeyare.android_coding_challenge.data.network.ProductNetworkDataSource;
import io.github.teeyare.android_coding_challenge.utils.AppExecutors;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class AppRepository {
    private static AppRepository instance;
    private static final Object LOCK = new Object();

    private ProductDao dao;
    private ProductNetworkDataSource dataSource;

    // We fetch data once per app lifetime
    private boolean hasFetchedData;

    private AppRepository(final ProductDao dao, ProductNetworkDataSource dataSource) {
        this.dao = dao;
        this.dataSource = dataSource;

        dataSource.getDownloadedProducts().observeForever(new Observer<Product[]>() {
            @Override
            public void onChanged(@Nullable final Product[] products) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        dao.deleteAll();
                        dao.bulkInsert(products);
                    }
                });
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

    /**
     * Checks if the data has already been fetched and fetch it otherwise
     * @return an observable of the list of products
     */
    public LiveData<List<Product>> getProducts() {
        if (!hasFetchedData) {
            dataSource.fetchProducts();
            hasFetchedData = true;
        }
        return dao.getAll();
    }

    /**
     * Retrieves one item product by id from the database
     * @param itemId is the primary key of the products table
     * @return one record from the database
     */
    public LiveData<Product> getProductById(String itemId) {
        return dao.getProductById(itemId);
    }
}
