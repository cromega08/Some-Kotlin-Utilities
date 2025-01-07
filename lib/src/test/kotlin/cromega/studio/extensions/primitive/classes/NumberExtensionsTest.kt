package cromega.studio.extensions.primitive.classes

import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertIs

class NumberExtensionsTest
{
    private val zero: Byte = 0
    private val positive: Byte = 1
    private val negative: Byte = -1

    @Test fun byteConvertedToBoolean()
    {
        assertIs<Boolean>(value = Random.nextInt().toByte().toBoolean())
    }

    @Test fun shortConvertedToBoolean()
    {
        assertIs<Boolean>(value = Random.nextInt().toShort().toBoolean())
    }

    @Test fun intConvertedToBoolean()
    {
        assertIs<Boolean>(value = Random.nextInt().toBoolean())
    }

    @Test fun longConvertedToBoolean()
    {
        assertIs<Boolean>(value = Random.nextLong().toBoolean())
    }

    @Test fun floatConvertedToBoolean()
    {
        assertIs<Boolean>(value = Random.nextFloat().toBoolean())
    }

    @Test fun doubleConvertedToBoolean()
    {
        assertIs<Boolean>(value = Random.nextDouble().toBoolean())
    }

    @Test fun zeroConvertedToFalse()
    {
        assertEquals(expected = false, actual = zero.toBoolean())
    }

    @Test fun positiveConvertedToTrue()
    {
        assertEquals(expected = true, actual = positive.toBoolean())
    }

    @Test fun negativeConvertedToFalse()
    {
        assertEquals(expected = false, actual = negative.toBoolean())
    }

    @Test fun numberIdentifiedAsNotZero()
    {
        assertEquals(expected = true, actual = positive.isNotZero())
        assertEquals(expected = true, actual = negative.isNotZero())
    }

    @Test fun numberIdentifiedAsZero()
    {
        assertEquals(expected = true, actual = zero.isZero())
    }
}