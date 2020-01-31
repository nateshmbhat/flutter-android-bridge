package com.techy.nateshmbhat.sampleapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;



public class Module1FlutterActivity extends FlutterActivity {

    private static final String CHANNEL = "mychannel";
    private static final String TAG = "Module1FlutterActivity";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Log.d(TAG, "configureFlutterEngine: ");
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if ("add".equals(call.method)) result.success(add());
                            if ("getPrimaryColor".equals(call.method))
                                result.success(getColorPrimary());
                            Log.d(TAG, "configureFlutterEngine:  call method " + call.method);
                            Log.d(TAG, "configureFlutterEngine:  call args " + call.arguments);
                        }
                );
    }

    private int add() {
        return 10;
    }

    private String getColorPrimary() {
        return Integer.toHexString(R.color.colorPrimary);
    }
}
