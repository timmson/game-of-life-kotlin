package ru.timmson.gameoflife

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class BoardShould {

    @Test
    fun countNeighbours0() {
        val arrange = arrayOf(
            arrayOf(0, 0, 0),
            arrayOf(0, 0, 0),
            arrayOf(0, 0, 0)
        )

        val result = Board(arrange).countNeighbours(1, 1)

        assertEquals(0, result)
    }

    @Test
    fun countNeighbours1() {
        val arrange = arrayOf(
            arrayOf(1, 0, 0),
            arrayOf(0, 0, 0),
            arrayOf(0, 0, 0)
        )

        val result = Board(arrange).countNeighbours(1, 1)

        assertEquals(1, result)
    }

    @Test
    fun countNeighbours3() {
        val arrange = arrayOf(
            arrayOf(0, 1, 0),
            arrayOf(1, 1, 0),
            arrayOf(0, 0, 0)
        )

        val result = Board(arrange).countNeighbours(0, 0)

        assertEquals(3, result)
    }

    @Test
    fun countNeighbours5() {
        val arrange = arrayOf(
            arrayOf(0, 1, 1),
            arrayOf(0, 1, 1),
            arrayOf(0, 1, 1)
        )

        val result = Board(arrange).countNeighbours(1, 2)

        assertEquals(5, result)
    }

    @Test
    fun countNeighbours9() {
        val arrange = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 0, 1),
            arrayOf(1, 1, 1)
        )

        val result = Board(arrange).countNeighbours(1, 1)

        assertEquals(8, result)
    }

    @TestFactory
    fun cases() = mapOf(
        "returns empty board when all given cells are dead" to Case(
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0)
            ), arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0)
            )
        ),
        "returns empty board when 1 alive cell without neighbors is given" to Case(
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 1, 0),
                arrayOf(0, 0, 0)
            ), arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0)
            )
        ),
        "third" to Case(
            arrayOf(
                arrayOf(1, 0, 0),
                arrayOf(0, 1, 0),
                arrayOf(0, 0, 1)
            ), arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 1, 0),
                arrayOf(0, 0, 0)
            )
        ),
        "four" to Case(
            arrayOf(
                arrayOf(1, 0, 1),
                arrayOf(1, 0, 1),
                arrayOf(1, 1, 0)
            ), arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(1, 0, 1),
                arrayOf(1, 1, 0)
            )
        )
    ).map { (name, case) ->
        dynamicTest("$name: $case") {
            val result = Board(case.arrange).tick()

            assertArrayEquals(case.expected, result.board)
        }
    }
}

