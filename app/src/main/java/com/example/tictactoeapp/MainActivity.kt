package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellID = 0
        when (buSelected.id) {
            R.id.b1 -> cellID = 1
            R.id.b2 -> cellID = 2
            R.id.b3 -> cellID = 3
            R.id.b4 -> cellID = 4
            R.id.b5 -> cellID = 5
            R.id.b6 -> cellID = 6
            R.id.b7 -> cellID = 7
            R.id.b8 -> cellID = 8
            R.id.b9 -> cellID = 9

        }

        //Log.d("buClick",buSelected.id.toString())
        //Log.d("buClick: cellID:", cellID.toString())

        playGame(cellID, buSelected)
    }


    var activePlayer = 1

    var player1 = ArrayList<Int>()

    var player2 = ArrayList<Int>()

    fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(R.color.green)
            player1.add(cellID)
            activePlayer = 2
            autoplay()

        }


        else {

            buSelected.text = "O"
            buSelected.setBackgroundColor(R.color.pink)
            player2.add(cellID)
            activePlayer = 1
        }

        buSelected.isEnabled = false

        fun checkwinner() {

            var winner = -1
            //row 1

            if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
                winner = 1
            }
            if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
                winner = 2
            }
            //row 2

            if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
                winner = 1
            }
            if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
                winner = 2
            }
            //col1

            if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
                winner = 1
            }
            if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
                winner = 2
            }
            //col2
            if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
                winner = 1
            }
            if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
                winner = 2
            }
            //col3
            if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
                winner = 1
            }
            if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
                winner = 2

            }
            if (winner == 1) {
                Toast.makeText(this, "Player X has won the game", Toast.LENGTH_LONG).show()
                restartGame(1)
            }
            if (winner == 2) {
                Toast.makeText(this, "Player O has won the game", Toast.LENGTH_LONG).show()
                restartGame(2)
            }

        }

        fun PlayAuto(){
            var emptyCells = ArrayList<Int>()
            for (cellID in 1..9){
                if(!(player1.contains(cellID)|| player2.contains(cellID))){
                    emptyCells.add(cellID)

                }
            }

            val r = Random()
            val randIndex = r.nextInt(emptyCells.size)
            val cellID = emptyCells[randIndex]

            var  buSelected:Button?
            buSelected = when(cellID){
                1->R.id.b1
                2->R.id.b2
                3->R.id.b3
                4->R.id.b4
                5->R.id.b5
                6->R.id.b6
                7->R.id.b7
                8->R.id.b8
                9->R.id.b9

                else -> {R.id.b1}

            }
            playGame(cellID, buSelected)
        }


        var player1winscounts = 0
        var player2winscounts = 0


        fun restartGame(){

            activePlayer = 1
            player1.clear()
            player2.clear()
          for(cellID in 1..9)
            var  buSelected:Button?
            buSelected = when(cellID){
                1->R.id.b1
                2->R.id.b2
                3->R.id.b3
                4->R.id.b4
                5->R.id.b5
                6->R.id.b6
                7->R.id.b7
                8->R.id.b8
                9->R.id.b9

                else -> {R.id.b1}



        }
            buSelected.text = ""
            buSelected.setBackgroundColor((R.color.purple_200))


    }
}

