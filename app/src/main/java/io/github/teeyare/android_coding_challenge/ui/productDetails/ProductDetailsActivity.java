package io.github.teeyare.android_coding_challenge.ui.productDetails;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import io.github.teeyare.android_coding_challenge.R;
import io.github.teeyare.android_coding_challenge.data.Product;
import io.github.teeyare.android_coding_challenge.utils.AppExecutors;

public class ProductDetailsActivity extends AppCompatActivity {

    private ProductDetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        viewModel = ViewModelProviders.of(this).get(ProductDetailsViewModel.class);
        viewModel.getProduct().observe(this, new Observer<Product>() {
            @Override
            public void onChanged(@Nullable Product product) {
                showProduct(product);
            }
        });

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    Product p = new Product("123", 100.0,"CAD", "item1",
                            new Product.Description("desc en-ca", "desc fr-ca"));
                    viewModel.setProduct(p);

                    Thread.sleep(2000);
                    p = new Product("456", 75.0,"USD", "item2",
                            new Product.Description("desc en-ca", "desc fr-ca"));
                    viewModel.setProduct(p);

                } catch (InterruptedException e) {
                    e.printStackTrace();
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
        String locale = getResources().getConfiguration().locale.getDisplayName();
        Log.d("ProductDetailsActivity", locale);
        String d;
        if (locale.equals("French (Canada)")) {
            d = product.getDescription().getFr_CA();
        }
        else {
            d = product.getDescription().getEn_CA();
        }
        description.setText(getString(R.string.description, d));
    }
}
