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
