package cromega.studio.extensions.primitive.classes

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class AnyExtensionsTest
{
    private val nullValue: Byte? = null
    private val notNullValue: Byte = 0

    @Test fun valueIdentifiedAsNull()
    {
        assertEquals(expected = true, actual = nullValue.isNull())
        assertEquals(expected = false, actual = nullValue.isNotNull())
    }

    @Test fun valueIdentifiedAsNotNull()
    {
        assertEquals(expected = false, actual = notNullValue.isNull())
        assertEquals(expected = true, actual = notNullValue.isNotNull())
    }

    @Test fun throwValueNull()
    {
        assertNotEquals(illegal = false, actual = nullValue.isNull())
        assertNotEquals(illegal = true, actual = nullValue.isNotNull())
    }

    @Test fun throwValueNotNull()
    {
        assertNotEquals(illegal = true, actual = notNullValue.isNull())
        assertNotEquals(illegal = false, actual = notNullValue.isNotNull())
    }
}
