package com.example.coins_n_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
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

        // Function to roll the red / black die
        fun rollDice(unit : Die) {
            
            // Rolls the Die
            unit.roll()

            // Updates drawable resource based on roll & die color
            val drawableResource: Int?
            when (unit.dieColor) {
                "black" -> {
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
                }
                "red" -> {
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
                }
                else -> {
                    drawableResource = R.drawable.coinsndicelogo
                    Log.e("error", "die is not red or black")
                }
            }
            

            // Update image to drawable resource
            if (unit.dieColor == "black") {
                blackDieImage.setImageResource(drawableResource)
                blackDieImage.contentDescription = unit.number.toString()
            } else {
                redDieImage.setImageResource(drawableResource)
                redDieImage.contentDescription = unit.number.toString()
            }

            // Update the centre text to combined value if both dice ar rolled
            if ((blackDie.number == 0) or (redDie.number == 0)) {
                rollDiceButton.setText(R.string.dice_roll_button)
            } else { rollDiceButton.setText(when (redDie.number + blackDie.number) {
                2 -> R.string.Two
                3 -> R.string.Three
                4 -> R.string.Four
                5 -> R.string.Five
                6 -> R.string.Six
                7 -> R.string.Seven
                8 -> R.string.Eight
                9 -> R.string.Nine
                10 -> R.string.Ten
                11 -> R.string.Eleven
                12 -> R.string.Twelve
                else -> R.string.dice_roll_button
                })
                rollDiceButton.setTextSize(30F)
            }

            //  Increase Text Size

        }

        fun flipCoins(unit : Coin) {
            // Flips the coin
            unit.flip()

            // Updates drawable resource based on flip and coin color
            val drawableResource: Int?
            when (unit.coinColor) {
                "silver" -> {
                    drawableResource = when (unit.side) {
                        "heads" -> {
                            R.drawable.coin_silver_heads
                        }
                        "tails" -> {
                            R.drawable.coin_silver_tails
                        }
                        else -> {
                            R.drawable.coinsndicelogo
                        }
                    }
                }
                "gold" -> {
                    drawableResource = when (unit.side) {
                        "heads" -> {
                            R.drawable.coin_gold_heads
                        }
                        "tails" -> {
                            R.drawable.coin_gold_tails
                        }
                        else -> {
                            R.drawable.coinsndicelogo
                        }
                    }
                }
                else -> {
                    drawableResource = R.drawable.coinsndicelogo
                }
            }

            // Update image to drawable resource
            if (unit.coinColor == "silver") {
                silverCoinImage.setImageResource(drawableResource)
            } else {
                goldCoinImage.setImageResource(drawableResource)
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

        // Button click flips the silver coin with haptic feedback
        silverCoinButton.setOnClickListener {
            flipCoins(silverCoin)
            silverCoinButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        }

        // Button click flips the gold coin with haptic feedback
        goldCoinButton.setOnClickListener {
            flipCoins(goldCoin)
            goldCoinButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        }

        // Button click flips both coins with haptic feedback
        twoUpButton.setOnClickListener {
            flipCoins(silverCoin)
            flipCoins(goldCoin)
            twoUpButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        }
        Log.d("init", "test initialised ${redDie.number} and ${blackDie.number}")

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
    var value = 0
    private val coinSides = listOf("heads", "tails")
    fun flip() {
        side = coinSides.random()
        if (side == "heads") {
            value = 1
        } else {
            value = 2
        }
    }
}
