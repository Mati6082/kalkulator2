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
        if (dzialanie == null) pom = wysw.text.toString()
        else pom = "0"
        wysw.text = ""
        var press = ""
        when (v.id) {
            R.id.btn0 -> {
                if (switch) {
                    wysw.text = "0"
                    switch = false
                    pom = ""
                }
                press = "0"
            }

            R.id.btn1 -> {
                if (switch) {
                    wysw.text = "1"
                    switch = false
                    pom = ""
                }
                press = "1"
            }

            R.id.btn2 -> {
                if (switch) {
                    wysw.text = "2"
                    switch = false
                    pom = ""
                }
                press = "2"
            }

            R.id.btn3 -> {
                if (switch) {
                    wysw.text = "3"
                    switch = false
                    pom = ""
                }
                press = "3"
            }

            R.id.btn4 -> {
                if (switch) {
                    wysw.text = "4"
                    switch = false
                    pom = ""
                }
                press = "4"
            }

            R.id.btn5 -> {
                if (switch) {
                    wysw.text = "5"
                    switch = false
                    pom = ""
                }
                press = "5"
            }

            R.id.btn6 -> {
                if (switch) {
                    wysw.text = "6"
                    switch = false
                    pom = ""
                }
                press = "6"
            }

            R.id.btn7 -> {
                if (switch) {
                    wysw.text = "7"
                    switch = false
                    pom = ""
                }
                press = "7"
            }

            R.id.btn8 -> {
                if (switch) {
                    wysw.text = "8"
                    switch = false
                    pom = ""
                }
                press = "8"
            }

            R.id.btn9 -> {
                if (switch) {
                    wysw.text = "9"
                    switch = false
                    pom = ""
                }
                press = "9"
            }

            R.id.btnPlus -> {
                if (dzialanie != "+") {
                    dzialanie = "+"
                    press = ""
                } else {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                }
            }

            R.id.btnMinus -> {
                if (dzialanie != "-") {
                    dzialanie = "-"
                    press = ""
                } else {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                }
            }

            R.id.btnDivide -> {
                if (ob != 0.0) {
                    if (dzialanie != "/") {
                        dzialanie = "/"
                        press = ""
                    } else {
                        press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                        dzialanie = null
                        switch = true
                    }
                } else press = "0"
            }

            R.id.btnMultiply -> {
                if (dzialanie != "*") {
                    dzialanie = "*"
                    press = ""
                } else {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                }
            }

            R.id.btnEquals -> {
                if (dzialanie != null && ob != null && pop != null) {
                    press = wykonajDzialanie(dzialanie!!, ob!!, pop!!).toString()
                    dzialanie = null
                    switch = true
                } else press = "0"
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
            if (pom == "0" && press != "") {
                wysw.text = press
            } else if (press != "") {
                wysw.text = pom + press
            } else wysw.text = pop.toString()
            ob = wysw.text.toString().toDouble()
        }
    }

    fun wykonajDzialanie(dzialanie: String, obecna: Double, poprzednia: Double): Double? {
        when (dzialanie) {
            "+" -> return poprzednia + obecna
            "*" -> return poprzednia * obecna
            "/" -> return poprzednia / obecna
            "-" -> return poprzednia - obecna
        }
        return null
    }

    fun clear(v: View) {
        wysw.text = "0"
        ob = null
        pop = null
        dzialanie = null
    }
}