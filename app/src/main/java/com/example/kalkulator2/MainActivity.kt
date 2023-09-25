package com.example.kalkulator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var wysw: TextView
    var obecne: Double? = null
    var poprzednie: Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wysw = findViewById(R.id.display)
    }

    fun click(v: View) {
        var press: String = ""
        var dzialanie: String? = null
        //if (wysw.text == "0")
        //    wysw.text = ""
        //var pom = wysw.text.toString().toDouble()
        when (v.id) {
            R.id.btn0 -> press = "0"
            R.id.btn1 -> press = "1"
            R.id.btn2 -> press = "2"
            R.id.btn3 -> press = "3"
            R.id.btn4 -> press = "4"
            R.id.btn5 -> press = "5"
            R.id.btn6 -> press = "6"
            R.id.btn7 -> press = "7"
            R.id.btn8 -> press = "8"
            R.id.btn9 -> press = "9"
            R.id.btnPlus -> {
                if (dzialanie != "+") {
                    dzialanie = "+"
                } else {
                    if (wysw.text.toString().toDouble() == 0.0) {
                        poprzednie = wysw.text.toString().toDouble()
                    }
                }
            }
            R.id.btnMinus -> dzialanie = "-"
            R.id.btnDivide -> dzialanie = "/"
            R.id.btnMultiply -> dzialanie = "*"
            R.id.btnEquals -> dzialanie = "="
        }
        if (dzialanie == null) {
            if (wysw.text.toString().toDouble() != 0.0) {
                poprzednie = wysw.text.toString().toDouble()
                obecne = poprzednie!! + press.toDouble()
                wysw.text = obecne.toString()
            } else {
                obecne = press.toDouble()
                wysw.text = obecne.toString()
            }
        } else {
            wysw.text = "inne"
        }
    }


    fun clear(v: View) {
        wysw.text = "0"
        obecne = null
        poprzednie = null
    }
}