package cromega.studio.extensions.data.structures

import cromega.studio.extensions.primitive.classes.isNotNull

/**
 * Add [E]? element **if is not _null_**.
 *
 * Add [E]? element to current [MutableCollection], only if this [E]? element **is not _null_**.
 *
 * @param E type of elements inside [MutableCollection]
 *
 * @param element [E]? element to be added (**if not _null_**)
 *
 * @return **_true_** if [element] **is not _null_**, **_false_** otherwise
 */
infix fun <E> MutableCollection<E>.addIfNotNull(element: E?): Boolean =
    if (element.isNotNull()) this.add(element!!)
    else false

/**
 * Add [E] element **if this one doesn't exist in current [MutableCollection]**.
 *
 * @param E type of elements inside [MutableCollection]
 *
 * @param element [E] object to be added **if it doesn't exist in current [MutableCollection]**
 *
 * @param validationFunction **_lambda function_** to validate if [element] exist inside current [MutableCollection].
 * This function should return **_true_ if current [MutableCollection] don't contain the [element]**, **_false_ otherwise**
 */
inline fun <E> MutableCollection<E>.addIfNotExist(
    element: E,
    validationFunction: (E) -> Boolean = { element -> !this.contains(element) }
): Boolean =
    if (validationFunction(element)) this.add(element)
    else false
