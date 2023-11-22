package dev.kata.wordWrap

class Text(private val text: String) {
    fun wrapFirstLine(columnWidth: ColumnWidth): Text {
        return Text(text.substring(0, columnWidth.width()) + "\n")
    }

    fun removeFirstLine(columnWidth: ColumnWidth): Text {
        return Text(text.substring(columnWidth.width()))
    }

    fun fitsIn(columnWidth: ColumnWidth): Boolean {
        return text.length <= columnWidth.width()
    }

    fun concat(other: Text): Text {
        return Text(text + other)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Text

        return text == other.text
    }

    override fun hashCode(): Int {
        return text.hashCode()
    }

    override fun toString(): String {
        return text
    }


}
