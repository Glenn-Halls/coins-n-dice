package com.example.coins_n_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.graphics.drawable.Drawable
import android.view.HapticFeedbackConstants

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

        // Create Dice and Coins
        val redDie = Die("red")
        val blackDie = Die("black")
        val goldCoin = Coin("gold")
        val silverCoin = Coin("silver")

        // Set coins and dice to value 0 and images to default
        val redDieImage : ImageView = findViewById(R.id.image_red_die)
        redDieImage.setImageResource(R.drawable.die_red_0)

        val blackDieImage : ImageView = findViewById(R.id.image_black_die)
        blackDieImage.setImageResource(R.drawable.die_black_0)

        val goldCoinImage : ImageView = findViewById(R.id.image_gold_coin)
        goldCoinImage.setImageResource(R.drawable.gold_coin_n)

        val silverCoinImage : ImageView = findViewById(R.id.image_silver_coin)
        silverCoinImage.setImageResource(R.drawable.silver_coin_n)
        
        Log.d("init", "initial number = ${blackDie.number}, blackDie = ${blackDie.roll()}, die color = ${blackDie.dieColor}")
        blackDie.roll()
        Log.d("init", "initial number = ${blackDie.number}, blackDie = ${blackDie.roll()}, die color = ${blackDie.dieColor}")

        Log.d("init", "initial side = ${goldCoin.side}, goldCoin = ${goldCoin.flip()}, coin color = ${goldCoin.coinColor}")
        blackDie.roll()
        Log.d("init", "initial side = ${goldCoin.side}, goldCoin = ${goldCoin.flip()}, coin color = ${goldCoin.coinColor}")

        
        fun rollDice(unit : Die) {
            
            // Rolls the Die
            unit.roll()

            // Updates drawable resource based on roll & die color
            var drawableResource: Int? = null
            if (unit.dieColor == "black") {
                drawableResource = when (unit.number) {
                    1 -> R.drawable.die_black_1
                    2 -> R.drawable.die_black_2
                    3 -> R.drawable.die_black_3
                    4 -> R.drawable.die_black_4
                    5 -> R.drawable.die_black_5
                    6 -> R.drawable.die_black_6
                    else -> {R.drawable.coinsndicelogo
                        Log.e("error", "die roll not in range")}
                }
            } else if (unit.dieColor == "red") {
                drawableResource = when (unit.number) {
                    1 -> R.drawable.die_red_1
                    2 -> R.drawable.die_red_2
                    3 -> R.drawable.die_red_3
                    4 -> R.drawable.die_red_4
                    5 -> R.drawable.die_red_5
                    6 -> R.drawable.die_red_6
                    else -> {R.drawable.coinsndicelogo
                        Log.e("error", "die roll not in range")}
                }
            } else {
                drawableResource = R.drawable.coinsndicelogo
                Log.e("error", "die is not red or black")
            }
            

            // Update image to drawable resource
            if (unit.dieColor == "black") {
                blackDieImage.setImageResource(drawableResource)
                blackDieImage.contentDescription = unit.number.toString()
            } else {
                redDieImage.setImageResource(drawableResource)
                redDieImage.contentDescription = unit.number.toString()
            }
        }


        // Button click rolls the black die with haptic feedback
        blackDieButton.setOnClickListener {
            rollDice(blackDie)
            blackDieButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        }

        // Button click rolls the red die with haptic feedback
        redDieButton.setOnClickListener {
            rollDice(redDie)
            redDieButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        }

        // Button click rolls both dice  with haptic feedback
        rollDiceButton.setOnClickListener {
            rollDice(blackDie)
            rollDice(redDie)
            rollDiceButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        }
    }
}


// logging of button clicks
private fun catLog(value: Button) {
    Log.d("init", "clicked on ${value.resources.getResourceName(value.id)}")
}

// Die class with initial value 0
class Die(val dieColor: String) {
    var number = 0
    fun roll() {
        number = (1..6).random()
    }
}

// Coin class with initial value "null"
class Coin(val coinColor: String) {
    var side = "null"
    val coinSides = listOf("heads", "tails")
    fun flip() {
        side = coinSides.random()
    }
}
