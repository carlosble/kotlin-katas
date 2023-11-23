package dev.kata.wordWrap

import arrow.core.Either

class Wrapper {
    companion object {

        fun wrap(text: Text, columnWidth: ColumnWidth): Text {
            return if (text.fitsIn(columnWidth)) {
                text
            } else {
                val wrappedText = text.wrapFirstLine(columnWidth)
                val remainingText = text.removeFirstLine(columnWidth)
                wrappedText.concat(wrap(remainingText, columnWidth))
            }
        }
    }
}
