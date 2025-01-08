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
 * Check if _given element **is the last in current [Collection]**_.
 *
 * @param T type of elements inside [Collection]
 *
 * @param toCheck [T] Element to be checked, and determine if **is the last element** on [Collection]
 *
 * @return **_true_** if compared element **is the last on [Collection]**, **_false_** otherwise
 */
infix fun <T> Collection<T>.isTheLast(toCheck: T): Boolean = this.last() == toCheck

/**
 * Check if _given element **is not the last in current [Collection]**_.
 *
 * @param T type of elements inside [Collection]
 *
 * @param toCheck [T] Element to be checked, and determine if **is not the last element** on [Collection]
 *
 * @return **_true_** if compared element **is not the last on [Collection]**, **_false_** otherwise
 */
infix fun <T> Collection<T>.isNotTheLast(toCheck: T): Boolean = !(this isTheLast toCheck)

/**
 * Check if _given element **is the first in current [Collection]**_.
 *
 * @param T type of elements inside [Collection]
 *
 * @param toCheck [T] Element to be checked, and determine **if is the first element** on [Collection]
 *
 * @return **_true_** if compared element **is the first on [Collection]**, **_false_** otherwise
 */
infix fun <T> Collection<T>.isTheFirst(toCheck: T): Boolean = this.first() == toCheck

/**
 * Check if _given element **is not the first in current [Collection]**_.
 *
 * @param T type of elements inside [Collection]
 *
 * @param toCheck [T] Element to be checked, and determine if **is not the first element** on [Collection]
 *
 * @return **_true_** if compared element **is not the first on [Collection]**, **_false_** otherwise
 */
infix fun <T> Collection<T>.isNotTheFirst(toCheck: T): Boolean = !(this isTheFirst toCheck)

/**
 * Validate if current [Collection] **is neither _null_ nor empty**.
 *
 * Allows to validate if current [Collection] object **is neither _null_ nor empty**.
 *
 * @param T type of elements inside [Collection]
 *
 * @return **_true_** if current [Collection] **is neither _null_ nor its size is _0_**, **_false_** otherwise
 */
fun <T> Collection<T>?.isNeitherNullOrEmpty(): Boolean = (this.isNotNull() && (this?.isNotEmpty() ?: false))

/**
 * Convert current [Collection] to a [String].
 *
 * Read the current [Collection] and write it on a **new** [String], with other configurable parameters.
 *
 * @param T type of elements inside [Collection]
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
 * @return [String] with all the elements of [Collection] written on it, along with the other parameters passed
 */
fun <T> Collection<T>.toText(
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
 * [Collection.find] variant with fallback.
 *
 * [Collection.find] function variant, allowing to generate a default value if no element match the [predicate].
 *
 * @param T type of elements inside [Collection]
 *
 * @param predicate **_lambda function_** used to validate if any [T] element match the established condition
 *
 * @param generateDefault **_lambda function_** used to generate default [T] object if no element match the [predicate]
 *
 * @param dataForDefault [Any] object containing data possibly needed by [generateDefault] function
 *
 * @return [T] object found inside the current [Collection], or default [T] element generated with [generateDefault]
 */
inline fun <T> Collection<T>.findOrDefault(
    predicate: (T) -> Boolean,
    generateDefault: (Any) -> T,
    dataForDefault: Any = Any()
): T =
    firstOrNull(predicate) ?: generateDefault(dataForDefault)

/**
 * Convert current [Collection] to [Map].
 *
 * Convert current [Collection] to a [Map], using [E] elements as index for [Map], completing with default values [T].
 *
 * @param E type of elements inside [Collection], and index type for [Map]
 *
 * @param T type of elements used for [Map.values]
 *
 * @param constructFunction **_lambda function_** used to generate default [T] values to fill [Map]<[E], [T]>
 *
 * @return [Map]<[E], [T]> generated by using the [Collection] [E] elements as index,
 * and filled with [T] generated values by [constructFunction]
 */
inline fun <E, T> Collection<E>.generateSimpleMap(
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
 * Convert current [Collection] to [Map].
 *
 * Convert current [Collection] to a [Map], using [E] elements as index for [Map],
 * completing with the result of a **_lambda function_** ([constructFunction]) that takes [E] and return [T].
 *
 * @param E type of elements inside [Collection], and index type for [Map]
 *
 * @param T type of elements used for [Map.values]
 *
 * @param constructFunction **_lambda function_** used to generate [T] values, using [E] elements as argument
 *
 * @return [Map]<[E], [T]> generated by using the [Collection] [E] elements as index,
 * and filled with [T] values (result of processing [E] by [constructFunction])
 */
inline fun <E, T> Collection<E>.generateMap(
    constructFunction: (E) -> T
): Map<E, T>
{
    val toReturn: MutableMap<E, T> = mutableMapOf()

    this.forEach {
        toReturn[it] = constructFunction(it)
    }

    return toReturn.toMap()
}
