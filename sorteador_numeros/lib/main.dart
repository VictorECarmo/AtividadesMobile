import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Sortear Números',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Sortear Números'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  late TextEditingController num1 = TextEditingController();
  late TextEditingController num2 = TextEditingController();
  late TextEditingController result = TextEditingController();
  late TextEditingController alert = TextEditingController();

  void _incrementCounter() {
    setState(() {
      var rng = Random();
      int num1Int = _tryParse(num1.text);
      int num2Int = _tryParse(num2.text);
      if (num1Int >= 0 && num2Int > num1Int) {
        result.text = (rng.nextInt(num2Int - num1Int) + num1Int).toString();
        alert.text = "Sucesso!";
      } else {
        alert.text = "Valor(es) informado(s) inválido(s)";
      }
    });
  }

  int _tryParse(String value) {
    try {
      return int.parse(value);
    } on Exception catch (_) {
      return 0;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Center(
              child: TextField(
                textAlign: TextAlign.center,
                controller: result,
                obscureText: false,
                enabled: false,
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                ),
              ),
            ),
            const Text(
              'Informe os valores',
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 16),
              child: Row(
                children: [
                  Flexible(
                    child: TextField(
                      controller: num1,
                      obscureText: false,
                      keyboardType: TextInputType.number,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Inicial',
                      ),
                    ),
                  ),
                  const SizedBox(width: 16),
                  Flexible(
                    child: TextField(
                      controller: num2,
                      obscureText: false,
                      keyboardType: TextInputType.number,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Final',
                      ),
                    ),
                  ),
                ],
              ),
            ),
            ElevatedButton(
              onPressed: _incrementCounter,
              child: const Text("Sortear"),
            ),
            TextField(
              controller: alert,
              obscureText: false,
              enabled: false,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
