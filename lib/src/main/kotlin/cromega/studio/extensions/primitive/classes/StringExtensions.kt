package cromega.studio.extensions.primitive.classes

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Validate if [String] contains something.
 *
 * Validate if current [String] **is neither _null_, empty nor contains only blank characters**.
 *
 * @return **_true_** value if [String] **is neither _null_, empty nor filled with blank characters**, **_false_** otherwise
 */
fun String?.isNeitherNullNorBlank(): Boolean = (this.isNotNull() && (this?.isNotBlank() ?: false))

/**
 * Convert [String] to [Date].
 *
 * Convert current [String] to [Date] using a [SimpleDateFormat] established by the user.
 *
 * @param [dateFormat] [SimpleDateFormat] object to use as parser,
 * should match current [String] content format
 *
 * @return [Date] object, result of the parsing process of current [String]
 *
 * @throws [ParseException] if the current [String] has an incorrect format or content for parsing
 */
infix fun String.toDateWithFormat(dateFormat: SimpleDateFormat): Date =
    dateFormat.parse(this)!!

/**
 * Run a **_lambda function_** on each word of current [String].
 *
 * Run given **_lambda function_** with each word of current [String],
 * without modifying this object itself.
 *
 * This function works "_similar_" to [Collection.forEach] method, running through each word.
 *
 * @param wordsSeparator [Regex] object used to identify separation points for current [String]
 *
 * @param onlyLetters [Boolean] value to determine if "_non-letter_" characters should be removed at the start of current function
 *
 * @param lowercaseWords [Boolean] value to determine if current [String] should be lowered before modifications
 *
 * @param deduplicateWords [Boolean] value to determine if "_duplicate letters_" should be removed from
 *
 * @param action (([String]) -> [Unit]) lambda to be applied to each filtered word of current [String]
 */
inline fun String.forEachWord(
    wordsSeparator: Regex = "\\s+".toRegex(),
    onlyLetters: Boolean = false,
    lowercaseWords: Boolean = false,
    deduplicateWords: Boolean = false,
    action: (String) -> Unit
) {
    var toExtract: String =
        if (onlyLetters) this.removeNonLetters(exclude = wordsSeparator.toString())
        else this

    if (lowercaseWords) toExtract = toExtract.lowercase()

    val words: Collection<String> =
        if (deduplicateWords)
            toExtract.extractWords(
                separator = wordsSeparator,
                removeNonLetters = onlyLetters,
                extractAsLowercase = lowercaseWords
            )
        else toExtract.split(wordsSeparator)

    words.forEach { action(it) }
}

/**
 * Remove "_Non-letter_" characters.
 *
 * Remove the "_Non-letter_" characters of current [String], and other additional characters desired by the user,
 * returning a new [String] object.
 *
 * @param exclude [String] object with desired characters to be excluded from process
 *
 * @return new [String] object with all "_Non-letters_" characters removed from old [String]
 */
fun String.removeNonLetters(exclude: String = ""): String =
    this.replace("[^a-zA-Z${exclude}]".toRegex(), "")

/**
 * Extract the words of current [String].
 *
 * Extract all words of current [String], based on certain "_filters_", and excluding duplicates.
 *
 * @param separator [Regex] object used to identify separation points for current [String]
 *
 * @param removeNonLetters [Boolean] value to establish if "_Non-letter_" characters should be removed previous to split process
 *
 * @param extractAsLowercase [Boolean] value to establish if all characters should be converted to lowercase
 *
 * @return [Set]<[String]> with the unique words inside given [String], filtered by the parameters given when calling it
 */
fun String.extractWords(
    separator: Regex = "\\s+".toRegex(),
    removeNonLetters: Boolean = false,
    extractAsLowercase: Boolean = false
): Set<String>
{
    var onlyWords: String = this

    if (removeNonLetters) onlyWords = onlyWords.removeNonLetters(exclude = separator.toString())

    if (extractAsLowercase) onlyWords = onlyWords.lowercase()

    return onlyWords.split(separator).toSet()
}

/**
 * Bind to "_Title Format_" current [String].
 *
 * Bind to a "_Title Format_" current [String], converting the **_first letter of each word_** to uppercase.
 *
 * @return new [String] with first letter of each word old [String] as uppercase
 */
fun String.titlecase(): String
{
    var toReturn: String = this.lowercase()

    this.forEachWord(
        onlyLetters = true,
        lowercaseWords = true,
        deduplicateWords = true
    ) {
        toReturn = toReturn.replace(
            oldValue = it,
            newValue = it.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault())
                else it.toString()
            }
        )
    }

    return toReturn
}
