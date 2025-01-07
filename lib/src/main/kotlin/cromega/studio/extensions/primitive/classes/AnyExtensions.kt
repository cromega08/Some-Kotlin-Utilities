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
