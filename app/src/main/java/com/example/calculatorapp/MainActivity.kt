package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var history: String? = null
    var isNewOperator = true
    var oldNumber = ""
    var newNumber = ""
    var operator = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun onClick(view: View) {
        if(isNewOperator) binding.textViewResult.text = ""
        isNewOperator = false
        var btnClicked = binding.textViewResult.text.toString()
        var btnSelect = view as Button
        when (view.id) {
            R.id.btn0 -> {
                btnClicked  += "0"
            }
            R.id.btn1 -> {
                btnClicked  += "1"
            }
            R.id.btn2 -> {
                btnClicked  += "2"
            }
            R.id.btn3 -> {
                btnClicked  += "3"
            }
            R.id.btn4 -> {
                btnClicked  += "4"
            }
            R.id.btn5 -> {
                btnClicked  += "5"
            }
            R.id.btn6 -> {
                btnClicked  += "6"
            }
            R.id.btn7 -> {
                btnClicked  += "7"
            }
            R.id.btn8 -> {
                btnClicked  += "8"
            }
            R.id.btn9 -> {
                btnClicked  += "9"
            }
            R.id.btnEquals -> {
                btnClicked  = "$btnClicked + "
            }

            R.id.btnDel -> Toast.makeText(this, "0", Toast.LENGTH_SHORT).show()
            R.id.btnAC -> {
                btnClicked  = "0"
            }
            R.id.btnDot -> {
                btnClicked  += "."
            }
        }
        binding.textViewResult.text = btnClicked
    }

    fun onOperatorClick(view: View) {
        isNewOperator = true
        oldNumber = binding.textViewResult.text.toString()
        when(view.id){
            R.id.btnPlus -> {
              operator ="+"
            }
            R.id.btnMinus -> {
                operator ="-"
            }
            R.id.btnMultiple -> {
                operator ="*"
            }
            R.id.btnDivide -> {
                operator ="/"
            }
        }
    }
    fun onEqualClick(view: View) {
        newNumber = binding.textViewResult.text.toString()
        var result = 0
        when (operator){
            "+"->{result = oldNumber.toInt() + newNumber.toInt()}
            "-"->{result = oldNumber.toInt() - newNumber.toInt()}
            "*"->{result = oldNumber.toInt() * newNumber.toInt()}
            "+/"->{result = oldNumber.toInt() / newNumber.toInt()}
        }
        binding.textViewResult.text = result.toString()
    }
}