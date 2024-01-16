enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (usuario.nome.isNotBlank() && usuario.nome.isNotEmpty()) {
            inscritos.add(usuario)
            println("Nome aluno: ${usuario.nome} matriculado na formação '$nome' com sucesso!")
        } else {
            println("Não foi possível matricular o usuário. Nome inválido.")
             
        }
      println("------------------------------------------------------------")   
    }

    fun imprimirDetalhes() {
        println("Detalhes da Formação:")
        println("Nome: $nome")
        println("Conteúdos:")
        conteudos.forEachIndexed { index, conteudo ->
            println("  ${index + 1}. Nome: ${conteudo.nome}, Duração: ${conteudo.duracao} horas, Nível: ${conteudo.nivel}")
        }
        println("------------------------------------------------------------")
    }

    fun imprimirMatriculados() {
        println("Usuários Matriculados:")
        inscritos.forEachIndexed { index, usuario ->
            println("${index + 1}. Nome: ${usuario.nome}")
        }
        println("------------------------------------------------------------")
    }
}

fun main() {
    
    val conteudo1 = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 1, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 3, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Tratamento de Exceções em Kotlin", 5, Nivel.DIFICIL)
    
    val formacao = Formacao("Desenvolvimento com Kotlin", listOf(conteudo1, conteudo2, conteudo3))
    
    val usuario1 = Usuario("Matheus")
    val usuario2 = Usuario("Ivan")
    val usuario3 = Usuario("Daniel")
    val usuario4 = Usuario("")
    
    formacao.imprimirDetalhes()
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)
    formacao.matricular(usuario4)
    
    formacao.imprimirMatriculados()
}

