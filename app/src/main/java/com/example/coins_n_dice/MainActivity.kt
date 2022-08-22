package com.example.coins_n_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

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

    }

    private fun catLog(value: Button) {
        Log.d("init", "clicked on ${value.resources.getResourceName(value.id)}")
    }
}