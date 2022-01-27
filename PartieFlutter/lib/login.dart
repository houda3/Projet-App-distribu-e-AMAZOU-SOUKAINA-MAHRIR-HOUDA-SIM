import 'dart:convert';

import 'package:clientpartie/dashboard.dart';
import 'package:clientpartie/register.dart';
import 'dart:convert' as convert;
import 'package:clientpartie/user.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:http/http.dart' as http;

import 'DataChart.dart';

class Login extends StatefulWidget {
  Login({Key? key}) : super(key: key);

  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final _formKey = GlobalKey<FormState>();
  List dataGetted = [];

  List<User> listUsers=[];

  String url = "http://localhost:8080/login";
  initData() async {
    var url = Uri.parse(
        'http://localhost:8080/findAllUtilisateurs');
    // Await the http get response, then decode the json-formatted response.
    var response = await http.get(url);
    if (response.statusCode == 200) {
      setState(() {
        this.dataGetted = convert.jsonDecode(response.body) as List;
        for(int i=0;i<dataGetted.length;i++) {
          final post=this.dataGetted[i];
          final val1 = post["email"].toString();
          final val2 = post["pass"].toString();
          this.listUsers.add(User(val1,val2));

        }
      }
      );

    } else {
      print('Request failed with status: ${response.statusCode}.');
    }
  }
  // Getting value from TextField widget.
  final emailController = TextEditingController();
  final passwordController = TextEditingController();

  Future save() async {
    User user=new User(emailController.text,passwordController.text);
    var res = await http.post(Uri.parse(url),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({'email': user.email, 'pass': user.pass}));

        print("email ===> "+emailController.text);
        print(user);
        if (res.statusCode == 200) {
         Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => DatatChart(),
          ));
    }
        else{
          Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => Dashboard(),
              ));
        }
  }
  @override
  void initState() {
    //emailController.addListener();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Form(
            key: _formKey,
            child: Column(
              children: [
                Container(
                  height: 550,
                  width: MediaQuery.of(context).size.width,
                  decoration: BoxDecoration(
                    color: Color.fromRGBO(233, 65, 82, 1),
                    boxShadow: [
                      BoxShadow(
                          blurRadius: 10,
                          color: Colors.black,
                          offset: Offset(1, 5))
                    ],
                    borderRadius: BorderRadius.only(
                        bottomLeft: Radius.circular(80),
                        bottomRight: Radius.circular(20)),
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      children: [
                        SizedBox(
                          height: 50,
                        ),
                        Text("Login",
                            style: GoogleFonts.pacifico(
                              //fontWeight: FontWeight.bold,
                              fontSize: 50,
                              color: Colors.white,
                            )
                        ),
                        SizedBox(
                          height: 30,
                        ),
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            "Email",
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Color.fromRGBO(255, 255, 255, 0.8),
                            ),
                          ),
                        ),
                        TextFormField(
                          controller: emailController,
                         /* onChanged: (val) {
                            user.email = val;
                          },
                          validator: (value) {
                            if (value!.isEmpty) {
                              return 'Password is Empty';
                            }
                            return null;
                          },*/
                          style: TextStyle(fontSize: 15, color: Colors.white),
                          decoration: InputDecoration(
                              errorStyle:
                              TextStyle(fontSize: 20, color: Colors.black),
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                        ),
                        Container(
                          height: 8,
                          color: Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        SizedBox(
                          height: 30,
                        ),
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            "Password",
                            style: GoogleFonts.roboto(
                               fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Color.fromRGBO(255, 255, 255, 0.8),
                            ),
                          ),
                        ),
                        TextFormField(
                          obscureText: true,
                          controller:passwordController,
                         /* TextEditingController(text: user.password),
                          onChanged: (val) {
                            user.password = val;
                          },
                         validator: (value) {
                            if (value!.isEmpty) {
                              return 'Email is Empty';
                            }
                            return null;
                          },*/
                          style: TextStyle(fontSize: 30, color: Colors.white),
                          decoration: InputDecoration(
                              errorStyle:
                              TextStyle(fontSize: 20, color: Colors.black),
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                        ),
                        Container(
                          height: 8,
                          color: Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        SizedBox(
                          height: 30,
                        ),
                        Center(
                          child: InkWell(
                            onTap: () {
                              Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                      builder: (context) => Register()));
                            },
                            child: Text(
                              "Vous n'avez pas de compte ?",
                              style: GoogleFonts.roboto(
                                  fontWeight: FontWeight.bold,
                                  fontSize: 10,
                                  color: Colors.white),
                            ),
                          ),
                        )
                      ],
                    ),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Container(
                  height: 90,
                  width: 90,
                  child: FlatButton(
                      color: Color.fromRGBO(240, 65, 82, 1),
                      onPressed: () {
                        if (_formKey.currentState!.validate()) {
                          save();
                        }
                      },
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(50)),
                      child: Icon(
                        Icons.arrow_forward,
                        color: Colors.white,
                        size: 30,
                      )),
                )
              ],
            )),
      ),
    );
  }
}