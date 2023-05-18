package com.example.my_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class WORDJUMBLE1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wordjumble1)
           val greeting=findViewById<TextView>(R.id.GREETING)
           val word=findViewById<TextView>(R.id.WORD)
           val wordType=findViewById<EditText>(R.id.ENTERWORD)
           val clueType=findViewById<EditText>(R.id.ENTERCLUE)
           val clue=findViewById<TextView>(R.id.CLUE)
           val start=findViewById<Button>(R.id.START)
           start.setOnClickListener {
               val enterWord=wordType.text.toString()
               val enterClue=clueType.text.toString()
               if (enterWord=="" || enterClue==""){
                   if (enterWord!=""){
                       Toast.makeText(this@WORDJUMBLE1,"PLEASE ENTER THE CLUE!",Toast.LENGTH_SHORT).show()
                   }
                   else if (enterClue!=""){
                       Toast.makeText(this@WORDJUMBLE1,"PLEASE ENTER THE WORD!",Toast.LENGTH_SHORT).show()
                   }
                   else{
                       Toast.makeText(this@WORDJUMBLE1,"PLEASE ENTER BOTH WORD AND CLUE!",Toast.LENGTH_SHORT).show()
                   }
               }
               else {
                   val intent = Intent(this, WORDJUMBLE2::class.java)
                   intent.putExtra("CLUE",enterClue)
                   intent.putExtra("WORD",enterWord)
                   startActivity(intent)
               }
           }
    }
}