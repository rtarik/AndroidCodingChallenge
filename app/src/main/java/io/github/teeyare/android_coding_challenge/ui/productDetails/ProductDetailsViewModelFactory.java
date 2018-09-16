package io.github.teeyare.android_coding_challenge.ui.productDetails;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import io.github.teeyare.android_coding_challenge.data.database.AppRepository;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class ProductDetailsViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private AppRepository repository;

    ProductDetailsViewModelFactory(AppRepository repo) {
        repository = repo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new ProductDetailsViewModel(repository);
    }
}
