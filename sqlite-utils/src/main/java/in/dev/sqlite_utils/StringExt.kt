package `in`.dev.sqlite_utils


/**
 * Created by harsh on 28/1/18.
 * String extensions
 */

/**
 * @return String.plus(" ")
 */
fun String.space(): String {
    return this.plus(" ")
}

/**
 * @return String.plus("\n")
 */
fun String.newLine(): String {
    return this.plus("\n")
}

/**
 * @return String.plus("\t")
 */
fun String.tab(): String {
    return this.plus("\t")
}

/**
 * @return String.plus("(")
 */
fun String.openParens(): String {
    return this.plus("(")
}

/**
 * @return String.plus(")")
 */
fun String.closeParens(): String {
    return this.plus(")")
}

/**
 * @return String.plus("{")
 */
fun String.openBraces(): String {
    return this.plus("{")
}

/**
 * @return String.plus("}")
 */
fun String.closeBraces(): String {
    return this.plus("}")
}

/**
 * @return String.plus("[")
 */
fun String.openBrackets(): String {
    return this.plus("[")
}

/**
 * @return String.plus("]")
 */
fun String.closeBrackets(): String {
    return this.plus("]")
}

/**
 * @return String.plus(";")
 */
fun String.semicolon(): String {
    return this.plus(";")
}

/**
 * @return String.plus(":")
 */
fun String.appendColon(): String {
    return this.plus(":")
}

/**
 * @return String.plus(".")
 */
fun String.dot(): String {
    return this.plus(".")
}

/**
 * @return String.plus(",")
 */
fun String.comma(): String {
    return this.plus(",")
}

/**
 * @return String.plus("_")
 */
fun String.underScore(): String {
    return this.plus("_")
}

/**
 * @return String.plus("-")
 */
fun String.hiphen(): String {
    return this.plus("-")
}

/**
 * @return String.plus("'")
 */
fun String.singleQuote(): String {
    return this.plus("'")
}

/**
 * @return String.plus("\"")
 */
fun String.doubleQuote(): String {
    return this.plus("\"")
}

/**
 * @return String.plus("=")
 */
fun String.equalTo(): String {
    return this.plus("=")
}

/**
 * @return tableName.dot().plus(String)
 */
fun String.with(tableName: String): String {
    return tableName.dot().plus(this)
}

/**
 * @return String.space().plus("INNER JOIN").space().plus(tableName).space()
 */
fun String.innerJoin(tableName: String): String {
    return this.space().plus("INNER JOIN").space().plus(tableName).space()
}

/**
 * @return String.space().plus("ON").space().plus(table1).dot().plus(col1).space()
 * .equalTo().space().plus(table2).dot().plus(col2).space()
 */
fun String.on(col1: String, table1: String, col2: String, table2: String): String {
    return this.space().plus("ON").space().plus(table1).dot().plus(col1).space()
            .equalTo().space().plus(table2).dot().plus(col2).space()
}