package io.github.teeyare.android_coding_challenge.ui.productList;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import io.github.teeyare.android_coding_challenge.data.database.AppRepository;
import io.github.teeyare.android_coding_challenge.data.database.Product;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class ProductListViewModel extends ViewModel {
    private LiveData<List<Product>> products;
    private AppRepository repository;

    ProductListViewModel(AppRepository repo) {
        repository = repo;
        products = repository.getProducts();
    }

    public LiveData<List<Product>> getProducts() {
        return products;
    }
}
