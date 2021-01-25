package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(R.id.Dice)
        }
    }
    private fun rollDice(diceId : Int)
    {
        val myDice = Dice(6)
        val diceRoll = myDice.roll()
        val diceImage : ImageView = findViewById(diceId)

        val diceResImage = when(diceRoll)
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceResImage)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val sides:Int)
{
    fun roll() : Int
    {
        return (1..sides).random()
    }
}