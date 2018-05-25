package np.com.sagunraj.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
            String savedNumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
            Toast.makeText(context, savedNumber, Toast.LENGTH_SHORT).show();
        }
    }
}
