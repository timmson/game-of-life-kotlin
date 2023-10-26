package ru.timmson.gameoflife

data class Case(
    val arrange: Array<Array<Int>>,
    val expected: Array<Array<Int>>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Case

        if (!arrange.contentDeepEquals(other.arrange)) return false
        if (!expected.contentDeepEquals(other.expected)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = arrange.contentDeepHashCode()
        result = 31 * result + expected.contentDeepHashCode()
        return result
    }

    override fun toString(): String {
        return "Case(arrange=${
            arrange.joinToString { it.contentToString() }
        }, expected = ${
            expected.joinToString { it.contentToString() }
        })"
    }
}
