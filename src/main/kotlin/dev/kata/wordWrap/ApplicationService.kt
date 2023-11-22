package dev.kata.wordWrap

import java.io.PrintStream

class ApplicationService(private val outputPrinter: PrintStream, private val errorPrinter: PrintStream) {
    fun wrap(args: Array<String>) {
        if (args.size != 2){
            errorPrinter.println("Wrong number of arguments. Usage: wrap text columnWidth")
            return
        }
        val columnWidth = args[1].toIntOrNull()
        if (columnWidth == null){
            errorPrinter.println("Wrong argument. Column with must be an integer")
            return
        }
        val text = args[0]
        val  eitherWrap = Wrapper.wrap(text, columnWidth)
        eitherWrap
            .map { w -> outputPrinter.println(w.toString()) }
            .mapLeft { e -> errorPrinter.println(e.message) }
    }
}
