package ru.timmson.gameoflife

import kotlin.random.Random

fun main() {

    print("Enter size of the board: ")
    val size = readln().toInt()

    val board = (0 until size).map { (0 until size).map { Random.nextInt(0, 2) }.toTypedArray() }.toTypedArray()

    step(board)
}

fun step(board: Array<Array<Int>>) {
    val newBoard = Board(board).tick().board
    println(newBoard.joinToString(separator = "\n") {
        it.joinToString(separator = " ") { d ->
            when (d) {
                0 -> "✖\uFE0F"
                else -> "\uD83D\uDD34"
            }
        }
    })

    println()
    Thread.sleep(1000) // or readln()

    if (!board.contentDeepEquals(newBoard)) step(newBoard)
}
