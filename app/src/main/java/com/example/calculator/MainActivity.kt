package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var lastnumber:Boolean=false
    var lastdot:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun buttonpressed(view : View){
        screen.append((view as Button).text);
        lastnumber=true
    }
    fun clear(view: View){
        screen.text=" ";
        lastnumber=false
        lastdot=false
    }
    fun decimalpoint(view: View){
        if(lastnumber && !lastdot){
            screen.append(".")
            lastnumber=false
            lastdot=true
        }
    }
    fun equal(view: View){
        if(lastnumber){
            var a=screen.text.toString();
            var prefix=""
            try {
                if(a.startsWith("-")){
                    prefix="-"

                }
               if(a.contains("-")){
                   val splitvalue=a.split("-")
                   var b=splitvalue[0]
                   var c=splitvalue[1]
                   screen.text=(b.toDouble()-c.toDouble()).toString()
               }
                if(a.contains("+")){
                    val splitvalue1=a.split("+")
                    var b=splitvalue1[0]
                    var c=splitvalue1[1]
                    screen.text=(b.toDouble()+c.toDouble()).toString()
                }
                if(a.contains("*")){
                    val splitvalue=a.split("*")
                    var b=splitvalue[0]
                    var c=splitvalue[1]
                    screen.text=(b.toDouble()*c.toDouble()).toString()
                }
                if(a.contains("/")){
                    val splitvalue=a.split("/")
                    var b=splitvalue[0]
                    var c=splitvalue[1]
                    screen.text=(b.toDouble()/c.toDouble()).toString()
                }
            }catch (e: java.lang.ArithmeticException){
                e.printStackTrace()
            }
        }

    }
}