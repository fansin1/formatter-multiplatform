package org.fansin.formatter

class AsciiBorderFormatter : BorderFormatter {

    override fun format(rows: Sequence<List<String>>): String {
        val horizontalSeparator = StringBuilder("+") //+----+----+------+ and etc.

        rows.firstOrNull()?.forEach { elem ->
            horizontalSeparator.apply {
                append("-".repeat(elem.length))
                append('+')
            }
        } ?: return ""

        return rows.map {
                row -> row.joinToString("|", "|", "|")
        }.joinToString("\n$horizontalSeparator\n", "$horizontalSeparator\n", "\n$horizontalSeparator")
    }

}