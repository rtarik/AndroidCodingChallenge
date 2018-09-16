package io.github.teeyare.android_coding_challenge.ui.productList;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.products);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_product_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(
                this, linearLayoutManager.getOrientation()
        );
        recyclerView.addItemDecoration(itemDecoration);
        final ProductListAdapter adapter = new ProductListAdapter(this);
        recyclerView.setAdapter(adapter);

        ProductListViewModelFactory factory = new ProductListViewModelFactory(
                InjectorUtils.provideRepository(this));
        viewModel = ViewModelProviders.of(this, factory)
                .get(ProductListViewModel.class);

        viewModel.getProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                if (products != null && !products.isEmpty()) {
                    findViewById(R.id.progress_bar).setVisibility(View.GONE);
                    adapter.setProducts(products);
                }
            }
        });
    }
}
