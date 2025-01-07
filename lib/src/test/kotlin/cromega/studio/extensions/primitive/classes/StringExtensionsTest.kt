package cromega.studio.extensions.primitive.classes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertIs

class StringExtensionsTest
{
    private val empty: String = ""
    private val tab: String = "   "
    private val spaces: String = "   "
    private val string: String = "Lorem ipsum odor amet, consectetuer adipiscing elit."
    private val alphanumeric: String = "abc123def"
    private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)

    @Test fun valueIsNeitherNullNorBlank()
    {
        assertEquals(expected = true, actual = string.isNeitherNullNorBlank())
    }

    @Test fun valueIsNullOrBlank()
    {
        assertEquals(expected = false, actual = empty.isNeitherNullNorBlank())
        assertEquals(expected = false, actual = tab.isNeitherNullNorBlank())
        assertEquals(expected = false, actual = spaces.isNeitherNullNorBlank())
    }

    @Test fun valueFormatedAsDateCorrectly()
    {
        assertIs<Date>(value = "20-20-2020" toDateWithFormat simpleDateFormat )
    }

    @Test fun throwsIncorrectValueWhenFormattingAsDate()
    {
        assertThrows<ParseException> { "10/10/1010" toDateWithFormat simpleDateFormat }

        assertThrows<ParseException> { string toDateWithFormat simpleDateFormat }
    }

    @Test fun throughEachWordOfValue()
    {
        assertDoesNotThrow {
            var capitalized: String = ""
            string.forEachWord { capitalized += it.uppercase() + " " }

            assertEquals(expected = string.uppercase(), actual = capitalized.trim())
        }
    }

    @Test fun removeNonLettersFromValues()
    {
        assertEquals(expected = "abcdef", actual = alphanumeric.removeNonLetters())
    }

    @Test fun removeNonLettersWithExceptions()
    {
        assertEquals(expected = "abc1def", actual = alphanumeric.removeNonLetters(exclude = "1"))
    }

    @Test fun extractWordsFromValue()
    {
        assertDoesNotThrow { string.extractWords() }
    }

    @Test fun valueAsTitleCase()
    {
        assertEquals(expected = "Lorem Ipsum Odor Amet, Consectetuer Adipiscing Elit.", actual = string.titlecase())
    }
}