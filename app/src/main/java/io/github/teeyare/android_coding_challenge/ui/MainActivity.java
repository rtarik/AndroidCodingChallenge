package io.github.teeyare.android_coding_challenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.github.teeyare.android_coding_challenge.R;
import io.github.teeyare.android_coding_challenge.ui.productDetails.ProductDetailsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        //TODO click should go to ProductListActivity
                        new Intent(MainActivity.this, ProductDetailsActivity.class)
                );
            }
        });
    }
}
