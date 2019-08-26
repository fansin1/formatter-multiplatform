package org.fansin.formatter

import org.fansin.formatter.BorderCharacters.Companion.BorderStyle

class UnicodeBorderFormatter(
    private val borderCharacters: BorderCharacters = BorderStyle.DEFAULT.borderCharacters
) : BorderFormatter {

    private fun sepCreate(
        left: Char,
        middle: Char,
        right: Char,
        horizontal: Char,
        elements: List<String>
    ): StringBuilder {

        val result = StringBuilder()
        result.apply {
            append(left)
            elements.forEachIndexed { index, elem ->
                append(horizontal.toString().repeat(elem.length))
                if (index != elements.lastIndex)
                    append(middle)
            }
            append(right)
        }

        return result
    }

    override fun format(rows: Sequence<List<String>>): String {

        if (rows.none())
            return ""

        val topSep = sepCreate(
            borderCharacters.cornerRightTop,
            borderCharacters.topConnector,
            borderCharacters.cornerLeftTop,
            borderCharacters.horizontalOutside,
            rows.first())
        topSep.append('\n')

        val endHeaderSep = sepCreate(
            borderCharacters.headerLeftConnector,
            borderCharacters.headerCenterConnector,
            borderCharacters.headerRightConnector,
            borderCharacters.horizontalOutside,
            rows.first())
        endHeaderSep.append('\n')

        val insideSep = sepCreate(
            borderCharacters.leftConnector,
            borderCharacters.centerConnector,
            borderCharacters.rightConnector,
            borderCharacters.horizontalInside,
            rows.first())
        insideSep.append('\n')

        val botSep = sepCreate(
            borderCharacters.cornerRightBot,
            borderCharacters.botConnector,
            borderCharacters.cornerLeftBot,
            borderCharacters.horizontalOutside,
            rows.first())


        val separatedRows = rows.map {
                row -> row.joinToString(
                    borderCharacters.verticalInside.toString(),
                    borderCharacters.verticalOutside.toString(),
                    borderCharacters.verticalOutside.toString()) + "\n"
        }.toList()

        val result = StringBuilder()
        result.apply {
            append(topSep)
            if (separatedRows.size > 1) {
                append(separatedRows.first())
                append(endHeaderSep)
                for (i in 1 until separatedRows.lastIndex) {
                    append(separatedRows[i])
                    append(insideSep)
                }
                append(separatedRows.last())
            } else if (separatedRows.isNotEmpty()) {
                append(separatedRows.first())
            }
            append(botSep)
        }


        return result.toString()
    }

}