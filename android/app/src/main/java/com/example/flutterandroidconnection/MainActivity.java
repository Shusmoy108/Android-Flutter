package com.example.flutterandroidconnection;

import android.os.Bundle;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCall;
import java.nio.channels.Channel;
import io.flutter.embedding.android.FlutterActivity;
import java.util.*;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.flutter.connect/connection";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                        final Map<String, Object> parameters = methodCall.arguments();
                        if (methodCall.method.equals("Printy")) {
                            String name = (String) parameters.get("name");
                            result.success("Hi from Java" + name);
                        }
                    }
                });
    }
}
