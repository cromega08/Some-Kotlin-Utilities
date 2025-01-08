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

package cromega.studio.extensions.primitive.collections

/**
 * Validate if all elements are **_true_** or **_false_**, based on given comparison.
 *
 * @param booleanToBe [Boolean] value to be matched
 *
 * @return **_true_** if all elements match given value [booleanToBe], **_false_** otherwise
 */
infix fun BooleanArray.allOfThemAre(booleanToBe: Boolean): Boolean =
    this.all { boolean -> boolean == booleanToBe }

/**
 * Validate if current [BooleanArray] contains given value.
 *
 * @param booleanToContain [Boolean] value to be contained in current [BooleanArray]
 *
 * @return **_true_** if match element ([booleanToContain]) exist at least one time inside current [BooleanArray]
 */
infix fun BooleanArray.atLeastOneIs(booleanToContain: Boolean): Boolean =
    this.any { boolean -> boolean == booleanToContain }
