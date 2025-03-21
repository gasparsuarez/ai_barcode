package com.air.ai_barcode

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** AiBarcodePlugin */
class AiBarcodePlugin : FlutterPlugin, MethodCallHandler {
    private lateinit var channel: MethodChannel

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "ai_barcode")
        channel.setMethodCallHandler(this)

        // Register PlatformViews
        flutterPluginBinding.platformViewRegistry.registerViewFactory(
            "view_type_id_scanner_view",
            AndroidScannerViewFactory(flutterPluginBinding.binaryMessenger)
        )
        flutterPluginBinding.platformViewRegistry.registerViewFactory(
            "view_type_id_creator_view",
            AndroidCreatorViewFactory(flutterPluginBinding.binaryMessenger)
        )
}