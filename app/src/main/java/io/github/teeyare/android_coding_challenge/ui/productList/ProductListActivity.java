package io.github.teeyare.android_coding_challenge.ui.productList;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import io.github.teeyare.android_coding_challenge.R;
import io.github.teeyare.android_coding_challenge.data.database.Product;
import io.github.teeyare.android_coding_challenge.utils.InjectorUtils;

public class ProductListActivity extends AppCompatActivity {

    private ProductListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_product_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ProductListAdapter adapter = new ProductListAdapter(this);
        recyclerView.setAdapter(adapter);

        ProductListViewModelFactory factory = new ProductListViewModelFactory(
                InjectorUtils.provideRepository(this));
        viewModel = ViewModelProviders.of(this, factory)
                .get(ProductListViewModel.class);

        viewModel.getProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                adapter.setProducts(products);
            }
        });

    }
}
