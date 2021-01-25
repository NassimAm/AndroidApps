package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{calculateTip()}
    }

    private fun calculateTip() {
        val stringText = binding.costOfService.text.toString()
        val cost = stringText.toDoubleOrNull()

        if(cost == null)
        {
            binding.tipAmountText.text=""
            return
        }

        val tipAmount = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.twenty_percent -> 0.20
            R.id.fifteen_percent -> 0.15
            R.id.ten_percent -> 0.10
            else -> 0.00
        }

        var tip = cost * tipAmount
        val roundUp = binding.roundTipSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmountText.text = getString(R.string.tip_amount_text,formattedTip)
    }
}