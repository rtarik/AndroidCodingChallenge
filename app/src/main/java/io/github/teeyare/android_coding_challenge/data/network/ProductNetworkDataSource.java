package io.github.teeyare.android_coding_challenge.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import java.util.List;

import io.github.teeyare.android_coding_challenge.data.Product;
import io.github.teeyare.android_coding_challenge.utils.AppExecutors;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class ProductNetworkDataSource {
    private static final Object LOCK = new Object();
    private static ProductNetworkDataSource instance;

    // LiveData holding the latest downloaded products
    private final MutableLiveData<Product[]> downloadedProducts;

    private ProductNetworkDataSource() {
        downloadedProducts = new MutableLiveData<>();
    }

    public static ProductNetworkDataSource getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                instance = new ProductNetworkDataSource();
            }
        }
        return instance;
    }

    public LiveData<Product[]> getDownloadedProducts() {
        return downloadedProducts;
    }

    public void fetchProducts() {
        AppExecutors.getInstance().networkIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulating a networking delay
                    Thread.sleep(4000);
                    Gson gson = new Gson();
                    ProductsResponse response = gson.fromJson(
                            ProductsResponse.MOCK_RESPONSE,
                            ProductsResponse.class);
                    if (response != null) {
                        downloadedProducts.postValue(response.getData());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
