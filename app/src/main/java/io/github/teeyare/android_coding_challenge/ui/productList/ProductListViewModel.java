package io.github.teeyare.android_coding_challenge.ui.productList;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import io.github.teeyare.android_coding_challenge.data.Product;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class ProductListViewModel extends ViewModel {
    private MutableLiveData<List<Product>> products;

    public ProductListViewModel() {
        products = new MutableLiveData<>();
    }

    public LiveData<List<Product>> getProducts() {
        return products;
    }

    public void setProducts(List<Product> productsList) {
        products.postValue(productsList);
    }
}
