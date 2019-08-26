package org.fansin.formatter

class EmptyBorderFormatter : BorderFormatter {

    override fun format(rows: Sequence<List<String>>): String {
        return rows.map { row -> row.joinToString("\t") }.joinToString("\n")
    }
}