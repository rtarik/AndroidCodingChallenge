package io.github.teeyare.android_coding_challenge.ui.productList;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.github.teeyare.android_coding_challenge.R;
import io.github.teeyare.android_coding_challenge.data.database.Product;
import io.github.teeyare.android_coding_challenge.ui.productDetails.ProductDetailsActivity;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<Product> products;
    private Context context;

    ProductListAdapter(Context context) {
        this.context = context;
        products = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.product_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Product product = products.get(i);
        viewHolder.itemSummary.setText(
                context.getString(R.string.item_summary,
                        product.getTitle(),
                        product.getValue(),
                        product.getCurrency())
        );
        viewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra(ProductDetailsActivity.EXTRA_ITEM_ID, product.getItemId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout itemLayout;
        TextView itemSummary;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.layout_item);
            itemSummary = itemView.findViewById(R.id.text_item_summary);
        }
    }
}
