package dev.kata.templateengine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Template(parsedTemplate: String) {}
class TemplateEngine {
    companion object {
        fun parse(template: String, templateVariables: Map<String, String>): Template {
            throw NotImplementedError("foo")
        }
    }
}
class TemplateEngineShould {
/*
    @Test
    fun `parsing a template with no variables produces the same string as result`(){
        assertThat(
            TemplateEngine.parse("hola", mapOf()))
            .isEqualTo("hola")
    }

    @Test
    fun `variables in the template are replace with matching variables in the map`(){
        assertThat(
            TemplateEngine.parse("hola {\$var}", mapOf(Pair("\$var", "foo"))))
            .isEqualTo("hola foo")
    }
*/
    /*
            TODO-list: especificacion de requisitos.

            null, null -> ???
            "", [] -> ???
            "hola", [] -> "hola"
            "{$var1}", [] -> ???
            "{$var1}", [$var2: hola] -> ???
            "hola {$placeholder}", [$placeholder: mundo] -> "hola mundo"
            "hola {$a1} {$b2} {$a1}", [$a1: foo, $b2: bar] -> "hola foo bar foo"
            "hola {$a1} {$b2}", [$a1: foo] -> ???
         */
    // TDD / Test-driven development.
}
