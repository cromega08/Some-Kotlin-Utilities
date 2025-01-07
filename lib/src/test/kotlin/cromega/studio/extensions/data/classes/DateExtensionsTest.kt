package cromega.studio.extensions.data.classes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.util.Date
import java.util.Locale

class DateExtensionsTest
{
    private val date: Date = Date()
    private val formatOnlyCalendar: String = "dd-MM-yyyy"
    private val formatOnlyClock: String = "HH:mm:ss.SSS"
    private val localeUS: Locale = Locale.US

    @Test fun convertValueToString()
    {
        assertDoesNotThrow { date.toStringWithFormat() }
    }

    @Test fun convertValueWithOnlyCalendarFormat()
    {
        assertDoesNotThrow { date.toStringWithFormat(format = formatOnlyCalendar) }
    }

    @Test fun convertValueWithOnlyLocaleUS()
    {
        assertDoesNotThrow { date.toStringWithFormat(locale = localeUS) }
    }

    @Test fun convertValueWithOnlyClockFormat()
    {
        assertDoesNotThrow { date.toStringWithFormat(format = formatOnlyClock) }
    }

    @Test fun throwIllegalFormat()
    {
        assertThrows<IllegalArgumentException> { date.toStringWithFormat(format = "Lorem Ipsum") }
    }
}