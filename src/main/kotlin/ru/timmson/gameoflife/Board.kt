package ru.timmson.gameoflife

class Board(val board: Array<Array<Int>>) {



    fun tick(): Board {
        val newBoard = board.indices.map { board.indices.map { 0 }.toTypedArray() }.toTypedArray()

        board.forEachIndexed { i, row ->
            row.forEachIndexed { j, cell ->
                run {
                    val neighbours = countNeighbours(i, j)
                    newBoard[i][j] = when {
                        neighbours == 3 && cell == 0 -> 1
                        (neighbours == 2 || neighbours == 3) && cell == 1 -> 1
                        else -> 0
                    }
                }
            }
        }

        return Board(newBoard)
    }

    fun countNeighbours(i: Int, j: Int): Int {
        var neighbours = 0

        (i - 1..i + 1).forEach { x ->
            (j - 1..j + 1).forEach { y ->
                try {
                    neighbours += if (x == i && y == j) 0 else board[x][y]
                } catch (ignore: Exception) {

                }
            }
        }

        return neighbours
    }

}
