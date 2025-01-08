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
 * Validate if an object is **_null_**.
 *
 * Allow to validate if any object **is _null_**, simplified with a method call.
 *
 * @return [Boolean] value indicating if object **is _null_** (**_true_**) or **not** (**_false_**)
 */
fun Any?.isNull(): Boolean = this == null

/**
 * Validate if an object is **not _null_**.
 *
 * Allow to validate if any object **is not _null_**, simplified with a method call.
 *
 * @return [Boolean] value indicating if object **is not _null_** (**_true_**) or **if is it** (**_false_**)
 */
fun Any?.isNotNull(): Boolean = !this.isNull()
