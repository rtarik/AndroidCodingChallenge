package io.github.teeyare.android_coding_challenge.utils;

import android.content.Context;

import io.github.teeyare.android_coding_challenge.data.database.AppDatabase;
import io.github.teeyare.android_coding_challenge.data.database.AppRepository;
import io.github.teeyare.android_coding_challenge.data.network.ProductNetworkDataSource;

/**
 * Created by teeyare (tarik) on 9/16/18.
 *
 * Basic dependency injection utility class
 */
public class InjectorUtils {
    public static AppRepository provideRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context.getApplicationContext());

        return AppRepository.getInstance(db.productDao(),
                ProductNetworkDataSource.getInstance());
    }


}
