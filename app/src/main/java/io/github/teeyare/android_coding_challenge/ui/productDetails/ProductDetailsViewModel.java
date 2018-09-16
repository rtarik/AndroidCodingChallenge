package io.github.teeyare.android_coding_challenge.ui.productDetails;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import io.github.teeyare.android_coding_challenge.data.database.AppRepository;
import io.github.teeyare.android_coding_challenge.data.database.Product;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
public class ProductDetailsViewModel extends ViewModel {
    private AppRepository repository;

    /**
     * Constructor method
     * @param repo the AppRepository is passed in the constructor, this way it can
     *             be easily mocked in testing
     */
    ProductDetailsViewModel(AppRepository repo) {
        repository = repo;

    }

    public LiveData<Product> getProduct(String itemId) {
        return repository.getProductById(itemId);
    }
}
