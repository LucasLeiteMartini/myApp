package myApp

import groovy.transform.CompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@CompileStatic
class PessoaService {

    def salvarPessoa(Pessoa pessoa) {

        if(!pessoa.validate()){
            return [erro: "Erro ao cadastrar: ${pessoa.errors}"]
        }
        
        pessoa.save(flush: true)
        return [sucesso: "Pessoa cadastrada com sucesso!", pessoa: pessoa]
    }

    def exlcuirPessoa(Long id){
        def pessoa = Pessoa.get(id)
        if(!pessoa){
            return [erro: "Pessoa com ID ${id} não encontrada!"]
        }
        pessoa.delete(flush: true)
        return [sucesso: "Pessoa com ID ${id} excluída com sucesso"]
    }
}