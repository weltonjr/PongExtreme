package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.AGScene

class Engine(game: AGScene, main:Boolean){
    companion object {
        lateinit var instance: Engine
    }
    val game = game
    val main = main
    val player1 = Player(game, main)
    val player2 = Player(game, !main)
    val ball = Ball(game)

    var powers = emptyList<Power>()

    fun TouchRight(){
        (if(main) player1 else player2).touchRight()
    }

    fun TouchLeft(){
        (if(main) player1 else player2).touchLeft()
    }

    fun loop(){
        player1.loop()
        //TODO remover isto
        player2.xPos = ball.xPos    //TODO: padronizar xPos - xPos

        player2.loop()
        ball.loop()

    }
}
