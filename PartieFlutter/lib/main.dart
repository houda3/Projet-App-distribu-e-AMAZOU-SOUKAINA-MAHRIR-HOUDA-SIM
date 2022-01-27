import 'dart:convert';

import 'package:clientpartie/DataChart.dart';
import 'package:clientpartie/login.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatefulWidget{
  @override
  _MyAppState createState()=>_MyAppState();
}

class _MyAppState extends State<MyApp>{


  @override
  Widget build(BuildContext context)
  {
    return MaterialApp(
      home:Login()


    );
  }
}
//DatatChart()