package techcare.internetconnectioncheck.com.internetconnectioncheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Sultan Mahmud on 1/24/2017.
 */

public class ConnectivityReceiver extends BroadcastReceiver {
    public static ConnectivityReceiverListener connectivityReceiverListener;
    @Override
    //When Connectivity state change this method will help to  capture it .This method will be called when connectivity state changed
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo=connectivityManager.getActiveNetworkInfo();
        boolean isConnected=activeNetworkInfo!=null&&activeNetworkInfo.isConnectedOrConnecting();
        if(connectivityReceiverListener!=null) {
            connectivityReceiverListener.onNetworkChange(isConnected);

        }
    }

    public static boolean isConnected(){

        ConnectivityManager connectivityManager= (ConnectivityManager)MyApplication.getmInstance().getApplicationContext().getSystemService(MyApplication.getmInstance().getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo=connectivityManager.getActiveNetworkInfo();
        return  activeNetworkInfo!=null&&activeNetworkInfo.isConnectedOrConnecting();

    }

    public interface ConnectivityReceiverListener{
        public void onNetworkChange(boolean isConnected );


    }
}
