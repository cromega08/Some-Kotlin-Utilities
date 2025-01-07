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
