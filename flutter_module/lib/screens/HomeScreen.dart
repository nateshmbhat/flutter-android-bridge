import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_module/hexcolor.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  String color = 'fefefe';

  static const platform = const MethodChannel('mychannel');

  @override
  void initState() {
    super.initState();
    _getPrimaryColor() ;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primaryColor: HexColor(color),
        ),
        home: Scaffold(
          appBar: AppBar(
            title: Text("Title"),
          ),
          body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[MyButton()],
            ),
          ),
        ));
  }

  Future<void> _getPrimaryColor() async {
    print("getting primary color");
    String result = color;
    try {
      result = await platform.invokeMethod('getPrimaryColor');
      print("Got result $result");
    } on PlatformException catch (e) {
      print("Error occured at native side : '${e.message}'.");
    }
    setState(() {
      color = result;
    });
  }
}

class MyButton extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return RaisedButton(
      onPressed: () {
      },
      child: Text("Open screen 2"),
    );
  }
}
