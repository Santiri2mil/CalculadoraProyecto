package com.example.srg_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private var num1:Double=0.0
    private var num2:Double=0.0
    private var operacion:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultadoText.text = "0"
        operacion = NoOPE

        b1.setOnClickListener{numPresionado(digito = "1")}
        b2.setOnClickListener{numPresionado(digito = "2")}
        b3.setOnClickListener{numPresionado(digito = "3")}
        b4.setOnClickListener{numPresionado(digito = "4")}
        b5.setOnClickListener{numPresionado(digito = "5")}
        b6.setOnClickListener{numPresionado(digito = "6")}
        b7.setOnClickListener{numPresionado(digito = "7")}
        b8.setOnClickListener{numPresionado(digito = "8")}
        b9.setOnClickListener{numPresionado(digito = "9")}
        b0.setOnClickListener{numPresionado(digito = "0")}
        punto.setOnClickListener{numPresionado(digito = ".")}

        suma.setOnClickListener{operacionPresionada(SUMA)}
        resta.setOnClickListener{operacionPresionada(RESTA)}
        multi.setOnClickListener{operacionPresionada(MULTIPLICACIÓN)}
        division.setOnClickListener{operacionPresionada(DIVISION)}

        borrar.setOnClickListener{Borrar()}
        igual.serOnClickListener{IgualPresionado()}

    }
    private fun numPresionado(digito:String){
        CalVi.text="${CalVi.text}${digito}"

        if(CalVi.text == "0" && digito != ".") {
            CalVi.text = "$digito"
        } else {
            CalVi.text = "${digito.text}$digito"
        }

        if(operacion==NoOPE)
        {
            num1=CalVi.text.toString().toDouble()
        }else{
            num2=CalVi.text.toString().toDouble()
        }
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion=operacion

        CalVi.text="0"
    }
    private fun IgualPresionado(){
        var resultado =when(operacion){
            SUMA->num1+num2
            RESTA->num1-num2
            MULTIPLICACIÓN->num1*num2
            DIVISION->num1/num2
            else->0
        }
        CalVi.text== if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }
    }
    private fun Borrar(){
        num1=0.0
        num2=0.0
        Calvi.text="0"
        operacion= NoOPE
    }
    companion object{
        const val SUMA=1
        const val  RESTA=2
        const val MULTIPLICACIÓN=3
        const val DIVISION=4
        const val NoOPE=0
    }
}