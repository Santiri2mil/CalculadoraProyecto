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
    private var num1:Double=0.0
    private var num2:Double=0.0
    private var operacion:Int=0
    private var CalVi: TextView?=null
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

        val CalVi:TextView=findViewById<TextView>(R.id.CalVi)


        CalVi?.text = ""
        operacion = NoOPE

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
        suma?.setOnClickListener{numPresionado(digito = "+")}
        resta?.setOnClickListener{numPresionado(digito = "-")}
        multi?.setOnClickListener{numPresionado(digito = "*")}
        division?.setOnClickListener{numPresionado(digito = "/")}

        suma?.setOnClickListener{operacionPresionada(SUMA)}
        resta?.setOnClickListener{operacionPresionada(RESTA)}
        multi?.setOnClickListener{operacionPresionada(MULTIPLICACIÓN)}
        division?.setOnClickListener{operacionPresionada(DIVISION)}

        borrar?.setOnClickListener{Borrar()}
        igual?.setOnClickListener{IgualPresionado()}

    }
    private fun numPresionado(digito:String){
        CalVi?.text="${CalVi?.text}${digito}"

        if(CalVi?.text == "0" && digito != ".") {
            CalVi?.text = "$digito"
        } else {
            CalVi?.text = "${digito?.text}$digito"
        }

        if(operacion==NoOPE)
        {
            num1=CalVi?.text.toString().toDouble()
        }else{
            num2=CalVi?.text.toString().toDouble()
        }
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion=operacion

        CalVi?.text="0"
    }
    private fun IgualPresionado(){
        var resultado =when(operacion){
            SUMA->num1+num2
            RESTA->num1-num2
            MULTIPLICACIÓN->num1*num2
            DIVISION->num1/num2
            else->0
        }
        CalVi?.text== if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }
    }
    private fun Borrar(){
        num1=0.0
        num2=0.0
        Calvi?.text=""
        operacion= NoOPE
    }
    companion object{
        const val SUMA=1
        const val  RESTA=2
        const val MULTIPLICACIÓN=3
        const val DIVISION=4
        const val NoOPE=0
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