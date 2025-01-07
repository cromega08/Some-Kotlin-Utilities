package cromega.studio.extensions.primitive.collections

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BooleanArrayExtensionsTest
{
    private val allElementsTrue: BooleanArray = booleanArrayOf(true, true, true)
    private val allElementsFalse: BooleanArray = booleanArrayOf(false, false, false)
    private val mixedElements: BooleanArray = booleanArrayOf(true, false, true, false)

    @Test fun validateAllElementsAreTrue()
    {
        assertEquals(expected = true, actual = allElementsTrue allOfThemAre true)
    }

    @Test fun validateAllElementsAreFalse()
    {
        assertEquals(expected = true, actual = allElementsFalse allOfThemAre false)
    }

    @Test fun failAllElementsAreTrue()
    {
        assertEquals(expected = false, actual = mixedElements allOfThemAre true)
    }

    @Test fun failAllElementsAreFalse()
    {
        assertEquals(expected = false, actual = mixedElements allOfThemAre false)
    }

    @Test fun validateAtLeastOneIsTrue()
    {
        assertEquals(expected = true, actual = mixedElements atLeastOneIs true)
    }

    @Test fun validateAtLeastOneIsFalse()
    {
        assertEquals(expected = true, actual = mixedElements atLeastOneIs false)
    }

    @Test fun failAtLeastOneIsTrue()
    {
        assertEquals(expected = false, actual = allElementsFalse atLeastOneIs true)
    }

    @Test fun failAtLeastOneIsFalse()
    {
        assertEquals(expected = false, actual = allElementsTrue atLeastOneIs false)
    }
}