package org.fansin.formatter

class TableFormatter(private val borderFormatter: BorderFormatter) {

    companion object {
        fun create(borderFormatter: BorderFormatter = EmptyBorderFormatter()): TableFormatter {
            return TableFormatter(borderFormatter)
        }
    }

    private val rows = mutableListOf<MutableList<String>>()


    fun<T> addRow(vararg values: T) {
        rows.add(values.asSequence().map { it.toString() }.toMutableList())
    }

    fun removeAt(index: Int) {
        rows.removeAt(index)
    }

    fun format(): String {
        val columnsCount = rows.map { row -> row.size }.max() ?: 0

        val lengths = IntArray(columnsCount) { index ->
            rows.map { row ->
                if (index < row.size)
                    row[index].length
                else
                    0
            }.max() ?: 0
        }

        val sameSizeRows = rows.map { row ->
            while (row.size < columnsCount) {
                row.add("")
            }
            row
        }

        val res: Sequence<List<String>> = sameSizeRows.asSequence().map {
            row -> row.mapIndexed {
                index, elem -> elem + " ".repeat(lengths[index] - elem.length)
            }
        }

        return borderFormatter.format(res)

    }
}