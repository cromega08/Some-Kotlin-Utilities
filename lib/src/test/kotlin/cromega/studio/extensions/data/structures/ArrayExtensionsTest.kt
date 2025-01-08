package cromega.studio.extensions.data.structures

import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.*

class ArrayExtensionsTest
{
    private val standardArray: Array<Int> = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    private val emptyArray: Array<Int> = arrayOf()
    private val nullArray: Array<Int>? = null
    private val randomArray: Array<Int> = Array<Int>(10) { Random.nextInt() }

    @Test fun validateValueIsLastInArray()
    {
        assertTrue { standardArray isTheLast 9 }
        assertFalse { standardArray isTheLast 8 }
    }

    @Test fun validateValueIsNotTheLastInArray()
    {
        assertTrue { standardArray isNotTheLast 8 }
        assertFalse { standardArray isNotTheLast 9 }
    }

    @Test fun validateValueIsTheFirstInArray()
    {
        assertTrue { standardArray isTheFirst 0 }
        assertFalse { standardArray isTheFirst 1  }
    }

    @Test fun validateValueIsNotTheFirstInArray()
    {
        assertTrue { standardArray isNotTheFirst 1 }
        assertFalse { standardArray isNotTheFirst 0 }
    }

    @Test fun validateValueIsNeitherNullOrEmpty()
    {
        assertTrue { standardArray.isNeitherNullOrEmpty() }
        assertFalse { emptyArray.isNeitherNullOrEmpty() }
        assertFalse { nullArray.isNeitherNullOrEmpty() }
    }

    @Test fun arrayConvertedToString()
    {
        assertIs<String>(
            value =
                randomArray
                    .toText(
                        startChar = "[",
                        separator = " - "
                    )
        )
    }

    @Test fun findNotRealValue()
    {
        assertNotNull(
            actual =
                standardArray
                    .findOrDefault(
                        predicate = { false },
                        generateDefault = { 10 }
                    )
        )
    }

    @Test fun convertArrayToSimpleMap()
    {
        assertIs<Map<Int, String>>(
            value = randomArray.generateSimpleMap { "Lorem Ipsum" }
        )
    }

    @Test fun convertArrayToMap()
    {
        assertIs<Map<Int, String>>(
            value = randomArray.generateMap { it.toString() }
        )
    }
}