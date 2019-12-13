package com.example.insurancepremiumcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myData: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)
        fun display(){
            if (myData.premiumAmount != 0.0)
                resultTxt.text = myData.premiumAmount.toString()
        }
        display()



        reset.setOnClickListener() {
            spinner.setSelection(0)
            radioGroup.clearCheck()
            checkBox.setChecked(false)
            resultTxt.setText("")
        }


        fun getPremium(): Double {

                return when (spinner.selectedItemPosition) {
                    0 -> 60.00
                    1 -> 70.00 +
                            (if (radioButton.isChecked) 50.00 else 0.0) +
                            (if (checkBox.isChecked) 100.00 else 0.0)
                    2 -> 90.00 +
                            (if (radioButton2.isChecked) 100.00 else 0.0) +
                            (if (checkBox.isChecked) 150.00 else 0.0)
                    3 -> 120.00+
                            (if (radioButton2.isChecked) 150.00 else 0.0) +
                            (if (checkBox.isChecked) 200.00 else 0.0)
                    4 -> 150.00 +
                    (if (radioButton2.isChecked) 200.00 else 0.0) +
                            (if (checkBox.isChecked) 300.00 else 0.0)
                    else -> 150.00
                }

        }
        calculate.setOnClickListener(){

            myData.premiumAmount = getPremium()

            display()
        }
    }



}
