/**
 *     <Some Kotlin Utilities - Library with utility code to use on Kotlin projects>.
 *     Copyright (C) <2025>  <Cromega>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * Autor: Cromega
 * E-mail: cr.jrg08@gmail.com
 */

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
