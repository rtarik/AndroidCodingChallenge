package io.github.teeyare.android_coding_challenge.ui.productDetails;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.github.teeyare.android_coding_challenge.data.Product;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
public class ProductDetailsViewModel extends ViewModel {
    private MutableLiveData<Product> product;

    public ProductDetailsViewModel() {
        product = new MutableLiveData<>();
    }

    public LiveData<Product> getProduct() {
        return product;
    }

    public void setProduct(Product p) {
        product.postValue(p);
    }
}
