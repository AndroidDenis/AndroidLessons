package ru.mirea.schukind.d.e.looper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;



public class MyLooper extends Thread{
    public Handler mHandler;
    private Handler mainHandler;
    public MyLooper(Handler mainThreadHandler) {
        mainHandler = mainThreadHandler;
    }

    private int number = 0;
    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        mHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message msg) {
                String data = msg.getData().getString("KEY");
                Log.d("MyLooper get message: ", data);
                int Years = msg.getData().getInt("Years");
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("result", String.format("Denis Shuckin %s is %d ",data,Years));
                message.setData(bundle);
                mainHandler.sendMessage(message);

            }
        };
        Looper.loop();
    }
}
