package `in`.dev.sqlite_utils


/**
 * Created by harsh on 28/1/18.
 * String extensions
 */

fun String.space(): String {
    return this.plus(" ")
}

fun String.newLine(): String {
    return this.plus("\n")
}

fun String.tab(): String {
    return this.plus("\t")
}

fun String.openParens(): String {
    return this.plus("(")
}

fun String.closeParens(): String {
    return this.plus(")")
}

fun String.openBraces(): String {
    return this.plus("{")
}

fun String.closeBraces(): String {
    return this.plus("}")
}

fun String.openBrackets(): String {
    return this.plus("[")
}

fun String.closeBrackets(): String {
    return this.plus("]")
}

fun String.semicolon(): String {
    return this.plus(";")
}

fun String.appendColon(): String {
    return this.plus(":")
}

fun String.dot(): String {
    return this.plus(".")
}

fun String.comma(): String {
    return this.plus(",")
}

fun String.underScore(): String {
    return this.plus("_")
}

fun String.hiphen(): String {
    return this.plus("-")
}