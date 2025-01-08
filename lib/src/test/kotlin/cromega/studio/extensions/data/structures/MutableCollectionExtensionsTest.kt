package cromega.studio.extensions.data.structures

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MutableCollectionExtensionsTest
{
    private val standardMutableCollection: MutableCollection<Int> =
        mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    @Test fun addValueIfNotNull()
    {
        assertTrue { standardMutableCollection addIfNotNull 10 }
        assertFalse { standardMutableCollection addIfNotNull null }
    }

    @Test fun addValueIfNotExists()
    {
        assertTrue { standardMutableCollection.addIfNotExist(10) }
        assertFalse { standardMutableCollection.addIfNotExist(0) }
    }
}