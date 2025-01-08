package cromega.studio.extensions.data.structures

import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.*

class IterableExtensionsTest
{
    private val standardIterable: Iterable<Int> = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    private val emptyIterable: Iterable<Int> = listOf()
    private val nullIterable: Iterable<Int>? = null
    private val randomIterable: Iterable<Int> = List<Int>(10) { Random.nextInt() }

    @Test fun validateValueIsLastInIterable()
    {
        assertTrue { standardIterable isTheLast 9 }
        assertFalse { standardIterable isTheLast 8 }
    }

    @Test fun validateValueIsNotTheLastInIterable()
    {
        assertTrue { standardIterable isNotTheLast 8 }
        assertFalse { standardIterable isNotTheLast 9 }
    }

    @Test fun validateValueIsTheFirstInIterable()
    {
        assertTrue { standardIterable isTheFirst 0 }
        assertFalse { standardIterable isTheFirst 1  }
    }

    @Test fun validateValueIsNotTheFirstInIterable()
    {
        assertTrue { standardIterable isNotTheFirst 1 }
        assertFalse { standardIterable isNotTheFirst 0 }
    }

    @Test fun validateValueIsNeitherNullOrEmpty()
    {
        assertTrue { standardIterable.isNeitherNullOrEmpty() }
        assertFalse { emptyIterable.isNeitherNullOrEmpty() }
        assertFalse { nullIterable.isNeitherNullOrEmpty() }
    }

    @Test fun iterableConvertedToString()
    {
        assertIs<String>(
            value =
                randomIterable
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
                standardIterable
                    .findOrDefault(
                        predicate = { false },
                        generateDefault = { 10 }
                    )
        )
    }

    @Test fun convertIterableToSimpleMap()
    {
        assertIs<Map<Int, String>>(
            value = randomIterable.generateSimpleMap { "Lorem Ipsum" }
        )
    }

    @Test fun convertIterableToMap()
    {
        assertIs<Map<Int, String>>(
            value = randomIterable.generateMap { it.toString() }
        )
    }
}