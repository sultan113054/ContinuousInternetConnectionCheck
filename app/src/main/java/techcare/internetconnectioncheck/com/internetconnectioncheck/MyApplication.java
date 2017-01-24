package techcare.internetconnectioncheck.com.internetconnectioncheck;

import android.app.Application;

/**
 * Created by Sultan Mahmud on 1/24/2017.
 */

public class MyApplication extends Application {


    public static MyApplication mInstance;
    @Override
     public void onCreate(){
         super.onCreate();
         mInstance=this;

     }

    public static synchronized MyApplication getmInstance(){

        return mInstance;
    }

    public  void setConnectivityReceiver(ConnectivityReceiver.ConnectivityReceiverListener listener){
        ConnectivityReceiver.connectivityReceiverListener=listener;


    }
}
