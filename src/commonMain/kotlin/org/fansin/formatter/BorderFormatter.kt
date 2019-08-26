package org.fansin.formatter

interface BorderFormatter {
    fun format(rows: Sequence<List<String>>): String
}