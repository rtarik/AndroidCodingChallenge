package io.github.teeyare.android_coding_challenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.github.teeyare.android_coding_challenge.R;
import io.github.teeyare.android_coding_challenge.ui.productDetails.ProductDetailsActivity;
import io.github.teeyare.android_coding_challenge.ui.productList.ProductListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.main_title);
        }

        Button button = findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(MainActivity.this, ProductListActivity.class)
                );
            }
        });
    }
}
