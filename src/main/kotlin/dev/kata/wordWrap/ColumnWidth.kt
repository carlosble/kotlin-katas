package dev.kata.wordWrap

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import kotlin.IllegalArgumentException

class ColumnWidth private constructor(private val width: Int) {
    fun width(): Int {
        return width
    }

    companion object {
        fun create(width: Int): Either<IllegalArgumentException, ColumnWidth> {
            return if (width <= 0) {
                IllegalArgumentException("Column width has to be one or bigger").left()
            } else {
                ColumnWidth(width).right()
            }
        }
    }
}
