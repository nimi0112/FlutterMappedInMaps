package com.example.verygoodcore.maps_demo

import android.content.Intent
import com.example.verygoodcore.NewMapsActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    private val CHANNEL = "samples.flutter/MappedInMaps"


    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
            // Note: this method is invoked on the main thread.
                call, result ->
            if (call.method == "openMaps") {
                startActivity(Intent(this, NewMapsActivity::class.java))
            } else {
                result.notImplemented()
            }
        }

    }
}
