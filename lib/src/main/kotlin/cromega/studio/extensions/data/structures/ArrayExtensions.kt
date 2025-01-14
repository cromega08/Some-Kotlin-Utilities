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

package cromega.studio.extensions.data.structures

import cromega.studio.extensions.primitive.classes.isNotNull

/**
 * Check if _given element is the **last in current [Array]**_.
 *
 * @param T type of elements inside [Array]
 *
 * @param toCheck [T] Element to be checked, and determine if is the last element on [Array]
 *
 * @return **_true_** if compared element **is the last on [Array]**, **_false_** otherwise
 */
infix fun <T> Array<T>.isTheLast(toCheck: T): Boolean = this.last() == toCheck

/**
 * Check if _given element is not the **last in current [Array]**_.
 *
 * @param T type of elements inside [Array]
 *
 * @param toCheck [T] Element to be checked, and determine if is not the last element on [Array]
 *
 * @return **_true_** if compared element **is not the last on [Array]**, **_false_** otherwise
 */
infix fun <T> Array<T>.isNotTheLast(toCheck: T): Boolean = !(this isTheLast toCheck)

/**
 * Check if _given element **is the first in current [Array]**_.
 *
 * @param T type of elements inside [Array]
 *
 * @param toCheck [T] Element to be checked, and determine **if is the first element** on [Array]
 *
 * @return **_true_** if compared element **is the first on [Array]**, **_false_** otherwise
 */
infix fun <T> Array<T>.isTheFirst(toCheck: T): Boolean = this.first() == toCheck

/**
 * Check if _given element **is not the first in current [Array]**_.
 *
 * @param T type of elements inside [Array]
 *
 * @param toCheck [T] Element to be checked, and determine if **is not the first element** on [Array]
 *
 * @return **_true_** if compared element **is not the first on [Array]**, **_false_** otherwise
 */
infix fun <T> Array<T>.isNotTheFirst(toCheck: T): Boolean = !(this isTheFirst toCheck)

/**
 * Validate if current [Array] **is neither _null_ nor empty**.
 *
 * Allows to validate if current [Array] object **is neither _null_ nor empty**.
 *
 * @param T type of elements inside [Array]
 *
 * @return **_true_** if current [Array] **is neither _null_ nor its size is _0_**, **_false_** otherwise
 */
fun <T> Array<T>?.isNeitherNullOrEmpty(): Boolean = (this.isNotNull() && (this?.isNotEmpty() ?: false))

/**
 * Convert current [Array] to a [String].
 *
 * Read the current [Array] and write it on a **new** [String], with other configurable parameters.
 *
 * @param T type of elements inside [Array]
 *
 * @param startChar [CharSequence] to be written at the start of the [String]
 *
 * @param endChar [CharSequence] to be written at the end of the [String]
 *
 * @param separator [CharSequence] to be written between each element added to resultant [String]
 *
 * @param elementToString **_lambda function_** to be executed when trying the [T] element conversion to [String].
 * If **_lambda function_ is not declared**, [toString] standard function will be called
 *
 * @return [String] with all the elements of [Array] written on it, along with the other parameters passed
 */
fun <T> Array<T>.toText(
    startChar: CharSequence = "(",
    endChar: CharSequence = ")",
    separator: CharSequence = ",",
    elementToString: ((T) -> String) = { element -> element.toString() }
): String
{
    val string: StringBuilder = StringBuilder()

    string.append(startChar)

    this.forEach { element ->
        val toAppend: String = elementToString(element)

        string.append(toAppend)

        if (this isNotTheLast element) string.append(separator)
    }

    string.append(endChar)

    return string.toString()
}

/**
 * [Array.find] variant with fallback.
 *
 * [Array.find] function variant, allowing to generate a default value if no element match the [predicate].
 *
 * @param T type of elements inside [Array]
 *
 * @param predicate **_lambda function_** used to validate if any [T] element match the established condition
 *
 * @param generateDefault **_lambda function_** used to generate default [T] object if no element match the [predicate]
 *
 * @param dataForDefault [Any] object containing data possibly needed by [generateDefault] function
 *
 * @return [T] object found inside the current [Array], or default [T] element generated with [generateDefault]
 */
inline fun <T> Array<T>.findOrDefault(
    predicate: (T) -> Boolean,
    generateDefault: (Any) -> T,
    dataForDefault: Any = Any()
): T =
    firstOrNull(predicate) ?: generateDefault(dataForDefault)

/**
 * Convert current [Array] to [Map].
 *
 * Convert current [Array] to a [Map], using [E] elements as index for [Map], completing with default values [T].
 *
 * @param E type of elements inside [Array], and index type for [Map]
 *
 * @param T type of elements used for [Map.values]
 *
 * @param constructFunction **_lambda function_** used to generate default [T] values to fill [Map]<[E], [T]>
 *
 * @return [Map]<[E], [T]> generated by using the [Array] [E] elements as index,
 * and filled with [T] generated values by [constructFunction]
 */
inline fun <E, T> Array<E>.generateSimpleMap(
    constructFunction: () -> T
): Map<E, T>
{
    val toReturn: MutableMap<E, T> = mutableMapOf()

    this.forEach {
        toReturn[it] = constructFunction()
    }

    return toReturn.toMap()
}

/**
 * Convert current [Array] to [Map].
 *
 * Convert current [Array] to a [Map], using [E] elements as index for [Map],
 * completing with the result of a **_lambda function_** ([constructFunction]) that takes [E] and return [T].
 *
 * @param E type of elements inside [Array], and index type for [Map]
 *
 * @param T type of elements used for [Map.values]
 *
 * @param constructFunction **_lambda function_** used to generate [T] values, using [E] elements as argument
 *
 * @return [Map]<[E], [T]> generated by using the [Array] [E] elements as index,
 * and filled with [T] values (result of processing [E] by [constructFunction])
 */
inline fun <E, T> Array<E>.generateMap(
    constructFunction: (E) -> T
): Map<E, T>
{
    val toReturn: MutableMap<E, T> = mutableMapOf()

    this.forEach {
        toReturn[it] = constructFunction(it)
    }

    return toReturn.toMap()
}
