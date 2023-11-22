package dev.kata.wordwrap

import arrow.core.getOrElse
import dev.kata.wordWrap.Wrapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class WordWrapShould {

    @Test
    fun wrapText(){
       assertThat(wrap("hola", 7)).isEqualTo("hola")
       assertThat(wrap("hola", 2)).isEqualTo("ho\nla")
       assertThat(wrap("ohlala", 2)).isEqualTo("oh\nla\nla")
    }

    @Test
    fun doNotWrapInCaseOfWrongColumnWidth(){
        assertThat(wrap("someText", -7)).isEqualTo("Column width has to be one or bigger")
    }

    private fun wrap(text: String, columnWidth: Int): String {
        return Wrapper
            .wrap(text, columnWidth).map { t -> t.toString() }
            .getOrElse { e -> e.message ?: "Error message is null!" }
    }
}
