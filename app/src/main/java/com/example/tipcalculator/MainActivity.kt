package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateTip.setOnClickListener {
            calculateTip()
        }
        }
     private fun calculateTip() {
         val stringInField=binding.costOfService.text.toString()
         val cost = stringInField.toDoubleOrNull()
         if(cost==null){
             binding.tipAmount.text=""
             return
         }
         val selectedId=binding.radioGroup.checkedRadioButtonId
         val tipPercent=when (selectedId)
         {
             R.id.amazing_value->0.20
             R.id.good_value->0.18
             else->0.15
         }
         var tip =tipPercent*cost
         val roundUp=binding.roundOfTip.isChecked
         if(roundUp){
             tip=kotlin.math.ceil(tip)
         }
         val formattedTip=NumberFormat.getCurrencyInstance().format(tip)
         binding.tipAmount.text=getString(R.string.tip_amount,formattedTip)


    }
    }


