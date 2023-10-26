package ru.timmson.gameoflife

import kotlin.random.Random

fun main() {

    print("Enter size of the board: ")
    val size = readln().toInt()

    var board = (0 until size).map { (0 until size).map { Random.nextInt(0, 2) }.toTypedArray() }.toTypedArray()

    println("Initial board: ")
    println(board.joinToString(separator = "\n") { it.contentToString() })

    var step = 0
    while (true) {
        board = Board(board).tick().board
        println("Step $step: ")
        println(board.joinToString(separator = "\n") {
            it.joinToString(separator = " ") { d ->
                when (d) {
                    0 -> " "
                    else -> "\uD83D\uDD34"
                }
            }
        })
        readln()
        step++
    }

}
