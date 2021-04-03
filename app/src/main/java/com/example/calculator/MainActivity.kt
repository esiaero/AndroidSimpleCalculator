package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.calculator_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    var rhsBuilder = StringBuilder()
    var lhs = 0
    var operation = ""
    var newOutput = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_main)
        result.text = "0"
        val buttonList = listOf<Button>(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9)
        for (x in buttonList.indices) {
            buttonList[x].setOnClickListener{ updateDigit(x.toString()) }
        }

        minus.setOnClickListener{
            resetOperationColors()
            calculateSum()
            minus.setBackgroundResource(R.drawable.button_pressed)
            operation = "-"
        }

        plus.setOnClickListener{
            resetOperationColors()
            calculateSum()
            plus.setBackgroundResource(R.drawable.button_pressed)
            operation = "+"
        }

        equals.setOnClickListener{
            if (operation != "") {
                resetOperationColors()
                calculateSum()
                operation = ""
            }
        }

        equals.setOnLongClickListener{
            clear()
            val toast = Toast.makeText(applicationContext, "Cleared", Toast.LENGTH_SHORT)
            toast.show()

            true
        }
    }

    private fun clear() {
        resetOperationColors()
        result.text = "0"
        lhs = 0
        operation = "+"
        rhsBuilder.clear()
    }

    private fun updateDigit(num : String) {
        if (operation == "") {
            clear()
        }
        resetOperationColors()
        rhsBuilder.append(num)
        result.text = rhsBuilder
        newOutput = false
    }

    private fun resetOperationColors() {
        minus.setBackgroundResource(R.drawable.button)
        plus.setBackgroundResource(R.drawable.button)
    }

    private fun calculateSum(): Int {
        val sum : Int
        if (rhsBuilder.isEmpty()) {
            return lhs
        }
        val rhs = rhsBuilder.toString().toInt()
        sum = when (operation) {
            "+" -> {
                lhs + rhs
            }
            "-" -> {
                lhs - rhs
            }
            else -> {
                lhs
            }
        }
        result.text = sum.toString()
        this.rhsBuilder.clear()
        lhs = sum
        return sum
    }
}