import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class LaunchMapsView extends StatelessWidget {
  const LaunchMapsView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: Center(
          child: InkWell(
              onTap: openMapsActivity,
              child: Container(
                  padding: const EdgeInsets.all(20),
                  color: Colors.green,
                  child: const Text('Click to Launch map'))),
        ),
      ),
    );
  }

  static const platform = MethodChannel('samples.flutter/MappedInMaps');

  Future<void> openMapsActivity() async {
    try {
      final int? result = await platform.invokeMethod('openMaps');
    } on PlatformException catch (e) {
      debugPrint(e.message);
    }
  }
}
