package com.example.srg_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.util.Log

private val TAG="MainActivity"
private val TEXT="TEXT_CONTENT"
class MainActivity : AppCompatActivity() {
    var num1=0.0
    var num2:Double=0.0
    var oper:Int=0
    var num:Double=0.0
    var resultado:Double=0.0
    private var CalVi: TextView?=null
    private var CalVi2: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bu1:Button=findViewById<Button>(R.id.b1)
        val bu2:Button=findViewById<Button>(R.id.b2)
        val bu3:Button=findViewById<Button>(R.id.b3)
        val bu4:Button=findViewById<Button>(R.id.b4)
        val bu5:Button=findViewById<Button>(R.id.b5)
        val bu6:Button=findViewById<Button>(R.id.b6)
        val bu7:Button=findViewById<Button>(R.id.b7)
        val bu8:Button=findViewById<Button>(R.id.b8)
        val bu9:Button=findViewById<Button>(R.id.b9)
        val bu0:Button=findViewById<Button>(R.id.b0)
        val pun:Button=findViewById<Button>(R.id.punto)

        val suma:Button=findViewById<Button>(R.id.suma)
        val multi:Button=findViewById<Button>(R.id.multi)
        val division:Button=findViewById<Button>(R.id.divsion)
        val resta:Button=findViewById<Button>(R.id.resta)

        val borrar:Button=findViewById<Button>(R.id.borrar)
        val igual:Button=findViewById<Button>(R.id.igual)

        CalVi=findViewById<TextView>(R.id.CalVi)
        CalVi2=findViewById<TextView>(R.id.CalVi2)

        CalVi?.text = ""
        CalVi2?.text = ""
        oper=0

        bu1?.setOnClickListener{numPresionado(digito = "1")}
        bu2?.setOnClickListener{numPresionado(digito = "2")}
        bu3?.setOnClickListener{numPresionado(digito = "3")}
        bu4?.setOnClickListener{numPresionado(digito = "4")}
        bu5?.setOnClickListener{numPresionado(digito = "5")}
        bu6?.setOnClickListener{numPresionado(digito = "6")}
        bu7?.setOnClickListener{numPresionado(digito = "7")}
        bu8?.setOnClickListener{numPresionado(digito = "8")}
        bu9?.setOnClickListener{numPresionado(digito = "9")}
        bu0?.setOnClickListener{numPresionado(digito = "0")}

        pun?.setOnClickListener{numPresionado(digito = ".")}


        suma?.setOnClickListener{operacionPresionada(operacion = 1,signo = "+")}
        resta?.setOnClickListener{operacionPresionada(operacion = 2,signo = "-")}
        multi?.setOnClickListener{operacionPresionada(operacion = 3,signo = "*")}
        division?.setOnClickListener{operacionPresionada(operacion = 4,signo = "/")}

        borrar?.setOnClickListener{Borrar()}
        igual?.setOnClickListener{IgualPresionado()}

    }
    private fun numPresionado(digito:String) {

        CalVi?.append("$digito")
        CalVi2?.append("$digito")

    }
    private fun operacionPresionada(operacion: Int,signo:String){
        oper=operacion

        num1=CalVi?.text.toString().toDouble()//Guardamos el primer valor que se hizo


        CalVi2?.append("$signo")
        CalVi?.text=""//borramos borramos lo que tenga la calculadora

    }
    private fun IgualPresionado(){

        num2= CalVi?.text.toString().toDouble()//Guardamos el segundo valor que se hizo

        when(oper) {

            1->resultado=num1+num2
            2->resultado=num1-num2
            3->resultado=num1*num2
            4->resultado=num1/num2
        }
        num=resultado
        CalVi?.text="${resultado}"
        CalVi2?.append("="+CalVi?.text)
        //CalVi2?.append("\n")
        CalVi?.append("")

    }

    private fun Borrar(){
        num1=0.0
        num2=0.0
        num=0.0
        resultado=0.0
        CalVi?.text=""
        CalVi2?.text=""
        oper=0
    }

    override fun onStart() {
        Log.d(TAG,"onStart")
        super.onStart()
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG,"onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        CalVi?.text=savedInstanceState.getString(TEXT,  "")
    }
    override fun onResume(){
        Log.d(TAG,"onResume")
        super.onResume()
    }
    override fun onPause() {
        Log.d(TAG,"onPause")
        super.onPause()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG,"onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT,CalVi?.text.toString())
    }
    override fun onStop() {
        Log.d(TAG,"onStop")
        super.onStop()
    }
    override fun onRestart() {
        Log.d(TAG,"onRestart")
        super.onRestart()
    }
    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }
}



