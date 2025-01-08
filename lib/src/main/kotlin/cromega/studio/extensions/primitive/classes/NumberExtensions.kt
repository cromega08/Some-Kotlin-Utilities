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

package cromega.studio.extensions.primitive.classes

/**
 * Convert [Number] to [Boolean].
 *
 * Convert a [Number] or primitive instance of it ([Byte], [Int], [Double], etc.) to [Boolean].
 *
 * @return **_true_** if [Number] instance **is not _null_** and **higher than (_>_) _0_**, **_false_** otherwise
 */
fun Number?.toBoolean(): Boolean = (this.isNotNull() && (this!!.toDouble() > 0))

/**
 * Check if [Number] is **different to _zero (0)_**.
 *
 * @return **_true_** if [Number] instance **is not _null_** and **different to _0_**, **_false_** otherwise
 */
fun Number?.isNotZero(): Boolean = (this.isNotNull() && (this!!.toInt() != 0))

/**
 * Check if [Number] is **equal to _zero (0)_**.
 *
 * @return **_true_** if [Number] instance **is not _null_** and **equals to _0_**, **_false_** otherwise
 */
fun Number?.isZero(): Boolean = !this.isNotZero()
