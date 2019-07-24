package com.example.android.animalshelter.view.home.shelter_list.route_choosing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.android.animalshelter.utils.IOnItemClickListener;

public class NetworkChangeReceiver extends BroadcastReceiver {

    private static String TAG = NetworkChangeReceiver.class.getSimpleName();
    private final IOnItemClickListener<Boolean> onConnectStateChanged;

    public NetworkChangeReceiver(IOnItemClickListener<Boolean> onConnectStateChanged) {
        this.onConnectStateChanged = onConnectStateChanged;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        onConnectStateChanged.onClick(isNetworkConnectedOrConnecting(context));
        Log.e(TAG, "Network Connection is [" + isNetworkConnectedOrConnecting(context) + "]");
    }

    public boolean isNetworkConnectedOrConnecting(Context context) {
        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
