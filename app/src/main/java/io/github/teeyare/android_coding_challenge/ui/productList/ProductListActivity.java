package io.github.teeyare.android_coding_challenge.ui.productList;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.teeyare.android_coding_challenge.R;
import io.github.teeyare.android_coding_challenge.data.AppRepository;
import io.github.teeyare.android_coding_challenge.utils.InjectorUtils;

public class ProductListActivity extends AppCompatActivity {

    private ProductListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        ProductListViewModelFactory factory = new ProductListViewModelFactory(
                InjectorUtils.provideRepository(this));

        viewModel = ViewModelProviders.of(this, factory)
                .get(ProductListViewModel.class);

    }
}
