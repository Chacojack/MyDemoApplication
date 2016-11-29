package demo.me.mydemoapplication.mutiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            int what = msg.what;
            String data = bundle.getString("data");
            Log.d("REMOTE", "handleMessage: data:" + data + ", what:" + what);

            reply(msg);
        }
    };

    private void reply(final Message msg) {
        Messenger replyTo = msg.replyTo;
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data","你确实很帅！");
        message.setData(bundle);
        try {
            replyTo.send(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private Messenger mMessenger = new Messenger(mHandler);


    public RemoteService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }


}
