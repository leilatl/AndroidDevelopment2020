package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

abstract class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oneBtn.setOnClickListener{numberClicked("1")}
        twoBtn.setOnClickListener{numberClicked("2")}
        threeBtn.setOnClickListener{numberClicked("3")}
        fourBtn.setOnClickListener{numberClicked("4")}
        fiveBtn.setOnClickListener{numberClicked("5")}
        sixBtn.setOnClickListener{numberClicked("6")}
        sevenBtn.setOnClickListener{numberClicked("7")}
        eightBtn.setOnClickListener{numberClicked("8")}
        nineBtn.setOnClickListener{numberClicked("9")}
        delBtn.setOnClickListener{delClicked()}
        plusBtn.setOnClickListener{operationClicked("plus")}
        minBtn.setOnClickListener{operationClicked("minus")}
        divBtn.setOnClickListener { operationClicked("divide") }
        mulBtn.setOnClickListener { operationClicked("multiply") }
        equalsBtn.setOnClickListener{equalsClicked()}


    }
    abstract var ourNum: Double
    abstract var operation: String

    fun numberClicked(number: String){
        textView.append(number)
    }
    fun delClicked(){
        textView.text = ""
    }
    fun operationClicked(oper: String){
        ourNum = textView.text.toString().toDouble()
        textView.text = ""
        operation = oper
    }
    fun equalsClicked(){
        var firstnum = ourNum
        var secondnum = textView.text.toString().toDouble()
        if(operation == "plus"){
            textView.text = (firstnum+secondnum).toString()
            operation = ""
            ourNum = 0.0
        }
        if(operation == "minus"){
            textView.text = (firstnum-secondnum).toString()
            operation = ""
            ourNum = 0.0
        }
        if(operation == "divide"){
            textView.text = (firstnum/secondnum).toString()
            operation = ""
            ourNum = 0.0
        }
        if(operation == "multiply"){
            textView.text = (firstnum*secondnum).toString()
            operation = ""
            ourNum = 0.0
        }
    }
}