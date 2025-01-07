package cromega.studio.extensions.data.classes

import java.text.SimpleDateFormat
import java.util.*

/**
 * Convert [Date] to [String].
 *
 * Convert current [Date] to [String] using a pattern established passed as argument.
 *
 * @param format [String] with the pattern to use when formating [Date] as [String]
 *
 * @param locale [Locale] object used for localization info on format process
 *
 * @return [String] with current [Date] formatted with given pattern ([format])
 *
 * @throws [NullPointerException] if given [format] or [locale] is null
 *
 * @throws [IllegalArgumentException] if give [format] is wrong
 */
fun Date.toStringWithFormat(format: String = "dd-MM-yyyy HH:mm:ss.SSS", locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat(format, locale).format(this)
