package com.example.my_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text


class WORDJUMBLE2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wordjumble2)


        val check = findViewById<Button>(R.id.CHECK)
        val reset = findViewById<Button>(R.id.RESET)
        var display = findViewById<EditText>(R.id.WORDDISPLAY)

        //Disabling the keypad
        display.isFocusable = false
        display.isFocusable = false


        val clue = findViewById<ImageButton>(R.id.CLUE)
        val gridLayout1 = findViewById<GridLayout>(R.id.GRIDLAYOUT1)
        val i1 = findViewById<ImageView>(R.id.I1)
        val i2 = findViewById<ImageView>(R.id.I2)
        val i3 = findViewById<ImageView>(R.id.I3)

        var count: Int = 0

        val alertDialog = AlertDialog.Builder(this)
        val alertDialog2 = AlertDialog.Builder(this)
        val clueDialog = intent.getStringExtra("CLUE")
        val wordCheck = intent.getStringExtra("WORD").toString()

        //var wordnew:List<Char> = wordCheck2.toList()

        var alphabet: MutableList<Char> = mutableListOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
        var wordList: List<Char> = wordCheck.toList().distinct()
        var sorted = (alphabet-wordList).shuffled()
        var shufList=wordList.shuffled()
        var result= (shufList+sorted)

        for(i in 0..15) {
            val a = result[i]
            val b = gridLayout1.getChildAt(i) as Button
            b.text = a.toString()
            b.setOnClickListener {
                if( display.text.toString().length < wordCheck.length) {
                    var display2 = b.text.toString()
                    display.append(display2)
                }
                else{
                    Toast.makeText(this@WORDJUMBLE2,"Word limit exceeded!!",Toast.LENGTH_SHORT).show()
                }
            }




            clue.setOnClickListener {

                alertDialog.setTitle("CLUE:")
                alertDialog.setMessage("$clueDialog")
                alertDialog.setPositiveButton("OKAY") { dialogInterface, it ->
                    dialogInterface.cancel()
                }.show()
            }

            reset.setOnClickListener {
                display.text.clear()
                var shufList=wordList.shuffled()
                var sorted=(alphabet-wordList).shuffled()
                var result= (shufList+sorted)
                for(i in 0..15) {
                    val a = result[i]
                    val b = gridLayout1.getChildAt(i) as Button
                    b.text = a.toString()
                }
            }


            check.setOnClickListener {
                val display1 = display.text.toString()
                var k: Int = (3 - count) * 100
                if (display1 == wordCheck) {
                    alertDialog2.setTitle("GAME OVER!")
                    alertDialog2.setMessage("YOUR SCORE:$k")
                    alertDialog2.setPositiveButton("PLAY AGAIN") { dialogInterface, it ->
                        dialogInterface.cancel()
                        display.text.clear()
                        i1.visibility = ImageView.VISIBLE
                        i2.visibility = ImageView.VISIBLE
                        i3.visibility = ImageView.VISIBLE
                    }
                    alertDialog2.setNegativeButton("HOME") { dialogInterface, it ->
                        finish()
                    }.show()

                } else if (display1 == "") {
                    Toast.makeText(this@WORDJUMBLE2, "ENTER A WORD!", Toast.LENGTH_SHORT).show()
                } else {
                    if (count == 0) {
                        i3.visibility = ImageView.INVISIBLE
                        count++
                        Toast.makeText(
                            this@WORDJUMBLE2,
                            "OOPS, WRONG WORD. TRY AGAIN!",
                            Toast.LENGTH_SHORT
                        ).show()
                        var shufList=wordList.shuffled()
                        var sorted=(alphabet-wordList).shuffled()
                        var result= (shufList+sorted)
                        for(i in 0..15) {
                            val a = result[i]
                            val b = gridLayout1.getChildAt(i) as Button
                            b.text = a.toString()
                        }
                    } else if (count == 1) {
                        i2.visibility = ImageView.INVISIBLE
                        count++
                        Toast.makeText(
                            this@WORDJUMBLE2,
                            "OOPS, WRONG WORD. TRY AGAIN!",
                            Toast.LENGTH_SHORT
                        ).show()
                        var shufList=wordList.shuffled()
                        var sorted=(alphabet-wordList).shuffled()
                        var result= (shufList+sorted)
                        for(i in 0..15) {
                            val a = result[i]
                            val b = gridLayout1.getChildAt(i) as Button
                            b.text = a.toString()
                        }
                    } else {
                        i1.visibility = ImageView.INVISIBLE
                        alertDialog2.setTitle("GAME OVER!")
                        alertDialog2.setMessage("YOU LOST! GOOD LUCK NEXT TIME!")
                        alertDialog2.setPositiveButton("PLAY AGAIN") { dialogInterface, it ->
                            dialogInterface.cancel()
                            display.text.clear()
                            i1.visibility = ImageView.VISIBLE
                            i2.visibility = ImageView.VISIBLE
                            i3.visibility = ImageView.VISIBLE
                        }
                        var shufList=wordList.shuffled()
                        var sorted=(alphabet-wordList).shuffled()
                        var result= (shufList+sorted)
                        for(i in 0..15) {
                            val a = result[i]
                            val b = gridLayout1.getChildAt(i) as Button
                            b.text = a.toString()
                        }
                        alertDialog2.setNegativeButton("HOME") { dialogInterface, it ->
                            finish()
                        }.show()
                    }
                }

            }

        }
    }
}

