package cromega.studio.extensions.data.structures

import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.*

class CollectionExtensionsTest
{
    private val standardCollection: Collection<Int> = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    private val emptyCollection: Collection<Int> = listOf()
    private val nullCollection: Collection<Int>? = null
    private val randomCollection: Collection<Int> = List<Int>(10) { Random.nextInt() }

    @Test fun validateValueIsLastInCollection()
    {
        assertTrue { standardCollection isTheLast 9 }
        assertFalse { standardCollection isTheLast 8 }
    }

    @Test fun validateValueIsNotTheLastInCollection()
    {
        assertTrue { standardCollection isNotTheLast 8 }
        assertFalse { standardCollection isNotTheLast 9 }
    }

    @Test fun validateValueIsTheFirstInCollection()
    {
        assertTrue { standardCollection isTheFirst 0 }
        assertFalse { standardCollection isTheFirst 1  }
    }

    @Test fun validateValueIsNotTheFirstInCollection()
    {
        assertTrue { standardCollection isNotTheFirst 1 }
        assertFalse { standardCollection isNotTheFirst 0 }
    }

    @Test fun validateValueIsNeitherNullOrEmpty()
    {
        assertTrue { standardCollection.isNeitherNullOrEmpty() }
        assertFalse { emptyCollection.isNeitherNullOrEmpty() }
        assertFalse { nullCollection.isNeitherNullOrEmpty() }
    }

    @Test fun collectionConvertedToString()
    {
        assertIs<String>(
            value =
                randomCollection
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
                standardCollection
                    .findOrDefault(
                        predicate = { false },
                        generateDefault = { 10 }
                    )
        )
    }

    @Test fun convertCollectionToSimpleMap()
    {
        assertIs<Map<Int, String>>(
            value = randomCollection.generateSimpleMap { "Lorem Ipsum" }
        )
    }

    @Test fun convertCollectionToMap()
    {
        assertIs<Map<Int, String>>(
            value = randomCollection.generateMap { it.toString() }
        )
    }
}