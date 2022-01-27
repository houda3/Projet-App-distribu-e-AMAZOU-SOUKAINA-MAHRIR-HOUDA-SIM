
import 'dart:core';
import 'package:flutter/material.dart';
import 'dart:convert' as convert;
import 'package:syncfusion_flutter_charts/charts.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/cupertino.dart';
import 'main.dart';


class DatatChart extends StatefulWidget {
  const DatatChart({Key? key}) : super(key: key);
  _DatatChartState createState() => _DatatChartState();
}

class  _DatatChartState extends State<DatatChart> {
  //String formatter = DateFormat.yMMMMd('en_US').format(new DateTime.now());
  List dataGetted = [];

  TooltipBehavior _tooltip = TooltipBehavior(enable: true);
  Future<void> _sendData() async {
    //showLoader(context);
    var url = Uri.parse(
        'http://localhost:8080/irisdata');
    // Await the http get response, then decode the json-formatted response.
    var response = await http.get(url);
    if (response.statusCode == 200) {
      setState(() {
        this.dataGetted = convert.jsonDecode(response.body) as List<dynamic>;
     });
    }
    else {
      print('Request failed with status: ${response.statusCode}.');
    }
    //hideLoader(context);
  }
  List<_BubbleData> data1=[];
  List<_BubbleData> data2=[];
  List<_BubbleData> data3=[];
  List<_BubbleData> d1=[];
  List<_BubbleData> d2=[];
  List<_BubbleData> d3=[];
  int currentPage = 0;
  GlobalKey bottomNavigationKey = GlobalKey();
  initData() async {
    var url = Uri.parse(
        'http://localhost:8080/irisdata');
    // Await the http get response, then decode the json-formatted response.
    var response = await http.get(url);

    if (response.statusCode == 200) {
      setState(() {
        this.dataGetted = convert.jsonDecode(response.body) as List;
        for(int i=0;i<dataGetted.length;i++) {
          final post=this.dataGetted[i];
          final val1 = post["sepallength"].toString();
          final val2 = post["sepalwidth"].toString();
          final val3 = post["petallength"].toString();
          final val4 = post["petalwidth"].toString();
          print("val1" + val1);
          print("val2" + val2);
          double x = double.parse(val1);
          double y = double.parse(val2);
          double z = double.parse(val3);
          double w = double.parse(val4);
          if(post["classification"].toString()=="Iris-setosa") {
            this.data1.add(_BubbleData(x, y));
            this.d1.add(_BubbleData(z, w));
          }
          if(post["classification"].toString()=="Iris-versicolor") {
            this.data2.add(_BubbleData(x, y));
            this.d2.add(_BubbleData(z, w));
          }
          if(post["classification"].toString()=="Iris-virginica") {
            this.data3.add(_BubbleData(x, y));
            this.d3.add(_BubbleData(z, w));
          }
        }
      }
      );

    } else {
      print('Request failed with status: ${response.statusCode}.');
    }
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    this.initData();
    //  this.RemplirData();

  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: const Text('Les analyses et clustering'),
        backgroundColor: Colors.blue,
      ),
      resizeToAvoidBottomInset: false,
      body:Center(
        child: SingleChildScrollView( child:
        Column(
            children: [
              Container(

                child: Column(crossAxisAlignment: CrossAxisAlignment.stretch, children: <Widget>[
                  DefaultTabController(
                      length: 2, // length of tabs
                      initialIndex: 0,
                      child: Column(crossAxisAlignment: CrossAxisAlignment.stretch, children: <Widget>[
                        Container(
                          child: TabBar(
                            labelColor: Colors.teal,
                            unselectedLabelColor: Colors.orange,
                            tabs: [
                              Tab(text: ' Sepale'),
                              Tab(text: ' Petale'),
                               ],
                          ),
                        ),
                        Container(
                            height: 400, //height of TabBarView
                            decoration: BoxDecoration(
                                border: Border(top: BorderSide(color: Colors.grey, width: 0.5))
                            ),
                            child: TabBarView(children: <Widget>[
                              SfCartesianChart(
                               primaryXAxis: CategoryAxis(),
                                primaryYAxis: NumericAxis(minimum: 0, maximum: 4.5, interval: 10),
                             tooltipBehavior: _tooltip,
                              series: <ChartSeries<_BubbleData, double>>[
                              BubbleSeries<_BubbleData, double>(
                               dataSource: data1,
                               xValueMapper: (_BubbleData data, _) => data.x,
                               yValueMapper: (_BubbleData data, _) => data.y,
                               name: 'Iris-setosa',
                               color: Color.fromRGBO(8, 142, 255, 1)),
                                BubbleSeries<_BubbleData, double>(
                                    dataSource: data2,
                                    xValueMapper: (_BubbleData data, _) => data.x,
                                    yValueMapper: (_BubbleData data, _) => data.y,
                                    name: 'versicolor',
                                    color: Color.fromRGBO(205, 122, 21, 1)),
                                BubbleSeries<_BubbleData, double>(
                                    dataSource: data3,
                                    xValueMapper: (_BubbleData data, _) => data.x,
                                    yValueMapper: (_BubbleData data, _) => data.y,
                                    name: 'virginica',
                                    color: Color.fromRGBO(8, 200, 100, 1)),

                            ]
                            ),

                              SfCartesianChart(
                                  primaryXAxis: CategoryAxis(),
                                  primaryYAxis: NumericAxis(minimum: 0, maximum: 3.5, interval: 10),
                                  tooltipBehavior: _tooltip,
                                  series: <ChartSeries<_BubbleData, double>>[
                                    BubbleSeries<_BubbleData, double>(
                                        dataSource: d1,
                                        xValueMapper: (_BubbleData data, _) => data.x,
                                        yValueMapper: (_BubbleData data, _) => data.y,
                                        name: 'Iris-setosa',
                                        color: Color.fromRGBO(10, 120, 230, 1)),
                                    BubbleSeries<_BubbleData, double>(
                                        dataSource: d2,
                                        xValueMapper: (_BubbleData data, _) => data.x,
                                        yValueMapper: (_BubbleData data, _) => data.y,
                                        name: 'versicolor',
                                        color: Color.fromRGBO(25, 212, 221, 1)),
                                    BubbleSeries<_BubbleData, double>(
                                        dataSource: d3,
                                        xValueMapper: (_BubbleData data, _) => data.x,
                                        yValueMapper: (_BubbleData data, _) => data.y,
                                        name: 'virginica',
                                        color: Color.fromRGBO(108, 200, 150, 1)),

                                  ]
                              )
                               ]

                             )
                          ),


                      ]
                      )
                  ),
                ]),
              ),


              /*********************************/
            ]
        ),
        ),
      ),


    );
  }

}
class _ChartData {
  _ChartData(this.x, this.y);
  final String x;
  final double y;
}
void _Home(BuildContext context) {
  final route=MaterialPageRoute(builder: (BuildContext context){
    return MyApp();

  });
  Navigator.of(context).push(route);
}

class _BubbleData {
  _BubbleData(this.x, this.y);

  final double x;
  final double y;
}