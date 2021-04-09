package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find the button by id
        val rollButton: Button = findViewById(R.id.button)

        //when we click the button we want an action to be performed
        rollButton.setOnClickListener {
            //create a method that when the button is clicked it will roll and give a random number
            roll()
        }
        //do a dice roll when the app starts
        roll()
    }

    private fun roll() {
        //create an object
        val dice = Dice(6)
        //roll the dice
        val diceRoll = dice.roll()
        //find the imageView
        val diceImage: ImageView = findViewById(R.id.imageView)

        //determine what image to use when the dice is rolled
         val  drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        //update the image with the correct drawable resource
        diceImage.setImageResource(drawableResource)
        //update the correct description
        diceImage.contentDescription = diceRoll.toString()
    }
}
//create a class that will contain the side of the dice and a method
class Dice (private val numbSides: Int){

    //create a method that will generate and return a random sideNumber
    fun roll (): Int {
        return (1..numbSides).random()
    }
}