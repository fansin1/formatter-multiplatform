package org.fansin.formatter

data class BorderCharacters (
    val cornerRightTop: Char,
    val cornerLeftTop: Char,
    val cornerRightBot: Char,
    val cornerLeftBot: Char,

    val verticalOutside: Char,
    val verticalInside: Char,

    val horizontalOutside: Char,
    val horizontalInside: Char,

    val topConnector: Char,
    val botConnector: Char,
    val leftConnector: Char,
    val rightConnector: Char,
    val centerConnector: Char,

    val headerCenterConnector: Char,
    val headerLeftConnector: Char,
    val headerRightConnector: Char


) {
    companion object {
        enum class BorderStyle {
            DEFAULT {
                override val borderCharacters = BorderCharacters(
                    '╔', '╗', '╚', '╝', '║', '│', '═', '─', '╤', '╧', '╟', '╢', '┼', '╪', '╠', '╣'
                )

            };

            abstract val borderCharacters: BorderCharacters
        }
    }
}