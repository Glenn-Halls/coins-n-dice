package com.example.coins_n_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set on click listeners for buttons
        val blackDieButton: Button = findViewById(R.id.button_black_die)
        blackDieButton.setOnClickListener { catLog(blackDieButton) }

        val redDieButton: Button = findViewById(R.id.button_red_die)
        redDieButton.setOnClickListener { catLog(redDieButton) }

        val goldCoinButton: Button = findViewById(R.id.button_gold_coin)
        goldCoinButton.setOnClickListener { catLog(goldCoinButton) }

        val silverCoinButton: Button = findViewById(R.id.button_silver_coin)
        silverCoinButton.setOnClickListener { catLog(silverCoinButton) }

        val twoUpButton: Button = findViewById(R.id.button_two_up)
        twoUpButton.setOnClickListener { catLog(twoUpButton) }

        val rollDiceButton: Button = findViewById(R.id.button_roll_dice)
        rollDiceButton.setOnClickListener { catLog(rollDiceButton) }

        // Set coins and dice to value 0 and images to default
        var redDieValue = 0
        val redDieImage : ImageView = findViewById(R.id.image_red_die)
        redDieImage.setImageResource(R.drawable.die_red_0)

        var blackDieValue = 0
        val blackDieImage : ImageView = findViewById(R.id.image_black_die)
        blackDieImage.setImageResource(R.drawable.die_black_0)

        var goldCoinValue = 0
        val goldCoinImage : ImageView = findViewById(R.id.image_gold_coin)
        goldCoinImage.setImageResource(R.drawable.gold_coin_n)

        var silverCoinValue = 0
        val silverCoinImage : ImageView = findViewById(R.id.image_silver_coin)
        silverCoinImage.setImageResource(R.drawable.silver_coin_n)
        

        // Function to roll a die
        fun rollDie(): Int {
            return (1..6).random()
        }
        
        // Function to toss a coin
        fun tossCoin() : String {
            val coinSide = listOf("heads", "tails")
            return coinSide.random()
        }

        // Function to roll the red die
        fun rollRedDie() {

        }



    }

    private fun catLog(value: Button) {
        Log.d("init", "clicked on ${value.resources.getResourceName(value.id)}")
    }
}