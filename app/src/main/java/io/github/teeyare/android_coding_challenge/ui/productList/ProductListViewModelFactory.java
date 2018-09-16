package io.github.teeyare.android_coding_challenge.ui.productList;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import io.github.teeyare.android_coding_challenge.data.AppRepository;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class ProductListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private AppRepository repository;

    public ProductListViewModelFactory(AppRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new ProductListViewModel(repository);
    }
}
