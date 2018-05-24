package np.com.sagunraj.serviceexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent i = new Intent(MyService.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MyService.this, 1, i, 0); // not a compulsion to implement this for NotificationManager
        long[] pattern = {500, 500, 500, 500, 500, 500};
        Notification notification = new NotificationCompat.Builder(MyService.this).setContentTitle("New Notification").setContentText("Your time is up!").setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent).setSound(Uri.parse("android.resource://"+MyService.this.getPackageName()+"/"+R.raw.notification)).setVibrate(pattern).build();
        notificationManager.notify(0, notification);
        return super.onStartCommand(intent, flags, startId);
    }
}
