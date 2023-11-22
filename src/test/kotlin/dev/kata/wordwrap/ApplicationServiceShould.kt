package dev.kata.wordwrap

import dev.kata.wordWrap.ApplicationService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class ApplicationServiceShould {

    private lateinit var byteArrayOutputStream: ByteArrayOutputStream
    private lateinit var printStream: PrintStream
    private lateinit var byteArrayErrorStream: ByteArrayOutputStream
    private lateinit var errorPrintStream: PrintStream
    private lateinit var appService: ApplicationService

    @BeforeEach
    fun setUp(){
        byteArrayOutputStream = ByteArrayOutputStream()
        printStream = PrintStream(byteArrayOutputStream)
        byteArrayErrorStream = ByteArrayOutputStream()
        errorPrintStream = PrintStream(byteArrayErrorStream)
        appService = ApplicationService(printStream, errorPrintStream)
    }

    @AfterEach
    fun tearDown(){
        printStream.close()
        errorPrintStream.close()
    }

    @Test
    fun `print the wrapped text`(){
        appService.wrap(arrayOf("hola", "2"))
        assertThat(byteArrayOutputStream.toString(Charsets.UTF_8.name()))
            .isEqualTo("ho\nla\n")
    }

    @Test
    fun `print the error message in case of wrong usage`(){
        appService.wrap(arrayOf("hola", "foo"))
        assertThat(byteArrayErrorStream.toString(Charsets.UTF_8.name()))
            .isEqualTo("Wrong argument. Column with must be an integer\n")
    }

    @Test
    fun `print the error message in case of bad column width`(){
        appService.wrap(arrayOf("hola", "-9"))
        assertThat(byteArrayErrorStream.toString(Charsets.UTF_8.name()))
            .isEqualTo("Column width has to be one or bigger\n")
    }
}
