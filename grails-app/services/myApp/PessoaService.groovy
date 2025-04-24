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

    def excluirPessoa(String cnsConsultado){
        def pessoa = Pessoa.where{cns == cnsConsultado}.find()
        if(!pessoa){
            return [erro: "Pessoa com CNS ${cnsConsultado} não encontrada!"]
        }
        pessoa.delete(flush: true)
        return [sucesso: "Pessoa com CNS ${cnsConsultado} excluída com sucesso"]
    }

    def buscarPorCns(String cnsConsultado) {
        
        def pessoa = Pessoa.where{cns == cnsConsultado}.find()
        if (!pessoa) {
            return [erro: "Nenhuma pessoa encontrada com o CNS ${cnsConsultado}."]
        }
     
        return [sucesso: "Pessoa encontrada!", pessoa: pessoa]
    }

    def atualizarPessoa(String cnsConsultado, Map params){
        def pessoa = Pessoa.where {cns == cnsConsultado}.find()

        pessoa.nome = params.nome
        pessoa.idade = params.idade as Integer
        pessoa.endereco = params.endereco
        pessoa.cns = params.cns

        if(!pessoa.validate()){
            return [erro: "Erro ao atualizar cadastro: ${pessoa.errors}"]
        }

        pessoa.save(flush: true)
        return [sucesso: "Pessoa cadastrada com sucesso!", pessoa: pessoa]
    }

}