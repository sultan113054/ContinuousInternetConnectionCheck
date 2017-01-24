package techcare.internetconnectioncheck.com.internetconnectioncheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnectivity();
    }

public void checkConnectivity() {

    boolean isConnected = ConnectivityReceiver.isConnected();
    show(isConnected);
}
private void show(boolean  isConnected) {

    if(isConnected){
        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();

    }
    else {
        Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();


    }
    }


    @Override
    public void onNetworkChange(boolean isConnected) {
        show(isConnected);
    }
}
