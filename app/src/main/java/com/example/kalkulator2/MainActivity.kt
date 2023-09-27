package com.example.kalkulator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var wysw: TextView
    var ob: Double? = null
    var pop: Double? = null
    var dzialanie: String? = null
    var switch = false
    lateinit var pom: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wysw = findViewById(R.id.display)
    }

    fun click(v: View) {
        if (dzialanie != null || (dzialanie != null && wysw.text.toString().toDouble()==pop)) pom = "0"
        else pom = wysw.text.toString()
        wysw.text = "0"
        var press = "0"
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
                    press = "0"
                    pom = "0"
                } else {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                }
            }

            R.id.btnMinus -> {
                if (dzialanie != "-") {
                    dzialanie = "-"
                    press = "0"
                } else {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                }
            }

            R.id.btnDivide -> {
                if (dzialanie != "/") {
                    dzialanie = "/"
                    press = "0"
                } else {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                }
            }

            R.id.btnMultiply -> {
                if (dzialanie != "*") {
                    dzialanie = "*"
                    press = "0"
                } else {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                }
            }

            R.id.btnEquals -> {
                if (dzialanie != null && ob != null && pop != null) {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = "="
                    switch = true
                } else {
                    press = "0"
                    pom = "0"
                }
            }
        }
        if (dzialanie == null) {
            if (pom == "0") {
                wysw.text = press
            } else {
                wysw.text = pom + press
            }
            pop = wysw.text.toString().toDouble()
        } else {
            if (pom == "0") {
                wysw.text = press
            } else if (dzialanie == "="){
                wysw.text = press
                dzialanie = null
            } else wysw.text = pom + press
            ob = wysw.text.toString().toDouble()
        }
    }

    fun wykonajDzialanie(dzialanie: String, obecna: Double, poprzednia: Double): Double {
        when (dzialanie) {
            "+" -> return poprzednia + obecna
            "*" -> return poprzednia * obecna
            "/" -> if (obecna != 0.0) return poprzednia / obecna
            "-" -> return poprzednia - obecna
        }
        return 0.0
    }

    fun clear(v: View) {
        wysw.text = "0"
        ob = null
        pop = null
        dzialanie = null
    }
}