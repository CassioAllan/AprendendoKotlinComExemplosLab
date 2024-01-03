data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarioConteudoPairs: Pair<Usuario, ConteudoEducacional>) {
        for ((usuario, conteudo) in usuarioConteudoPairs) {
            if (!inscritos.contains(usuario)) {
                inscritos.add(usuario)
                println("Matrícula realizada com sucesso para ${usuario.nome} na $nome no conteúdo ${conteudo.nome}.")
            } else {
                println("${usuario.nome} já está matriculado em outro máteria.")
            }
        }
    }
}

fun main() {
    val usuario1 = Usuario("Allan")
    val usuario2 = Usuario("Beatriz")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin")

    val formacaoKotlin = Formacao("Formação Kotlin", mutableListOf(conteudo1, conteudo2))

    formacaoKotlin.matricular(usuario1 to conteudo1, usuario2 to conteudo2)
    formacaoKotlin.matricular(usuario1 to conteudo1)
    
    formacaoKotlin.conteudos.add(ConteudoEducacional("Desenvolvimento Android em Kotlin"))
}
