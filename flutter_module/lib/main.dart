import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_module/hexcolor.dart';
import 'package:flutter_module/screens/HomeScreen.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return HomeScreen() ;
  }
}
