package com.daawa.ipc.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.daawa.ipc.example.IMainService;
import com.daawa.ipc.example.MarshallObject;

import java.util.ArrayList;
import java.util.List;

public class MainService extends Service {

    private void log(String message) {
        Log.v("MainService", message);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("Received start command.");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("Received binding.");
        return mBinder;
    }

    private final IMainService.Stub mBinder = new IMainService.Stub() {
        @Override
        public MarshallObject[] listFiles(String path) throws RemoteException {
            log("Received list command for: " + path);
            List<MarshallObject> toSend = new ArrayList<>();
            // Generates a list of 1000 objects that aren't sent back to the binding Activity
            for (int i = 0; i < 1000; i++)
                toSend.add(new MarshallObject("/example/item" + (i + 1)));
            return toSend.toArray(new MarshallObject[toSend.size()]);
        }

        @Override
        public void exit() throws RemoteException {
            log("Received exit command.");
            stopSelf();
        }
    };
}
