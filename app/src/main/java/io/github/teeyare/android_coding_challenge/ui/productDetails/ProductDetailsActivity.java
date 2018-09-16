package io.github.teeyare.android_coding_challenge.ui.productDetails;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.github.teeyare.android_coding_challenge.R;
import io.github.teeyare.android_coding_challenge.data.database.Product;
import io.github.teeyare.android_coding_challenge.utils.InjectorUtils;

public class ProductDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_ID = "extra.item.id";
    private ProductDetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.product_detail);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String itemId = getIntent().getExtras().getString(EXTRA_ITEM_ID);

        ProductDetailsViewModelFactory factory = new ProductDetailsViewModelFactory(
                InjectorUtils.provideRepository(this)
        );
        viewModel = ViewModelProviders.of(this, factory).get(ProductDetailsViewModel.class);
        viewModel.getProduct(itemId).observe(this, new Observer<Product>() {
            @Override
            public void onChanged(@Nullable Product product) {
                if (product != null) {
                    showProduct(product);
                }
            }
        });
    }

    private void showProduct(Product product) {
        TextView item = findViewById(R.id.text_item);
        TextView price = findViewById(R.id.text_price);
        TextView description = findViewById(R.id.text_description);

        item.setText(getString(R.string.item, product.getTitle()));
        price.setText(getString(R.string.price, product.getValue(), product.getCurrency()));
        String locale = getResources().getConfiguration().locale.toString();
        String d;
        if (locale.equals("fr_CA")) {
            d = product.getDescription().getFr_CA();
        }
        else {
            d = product.getDescription().getEn_CA();
        }
        description.setText(getString(R.string.description, d));
    }
}
