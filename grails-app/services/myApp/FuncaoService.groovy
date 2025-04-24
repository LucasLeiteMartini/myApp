package myApp

import groovy.transform.CompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@CompileStatic
class FuncaoService {

    def salvarRole(Funcao role) {
        if(!role.validate()){
            return [erro: "Erro ao cadastrar nova função: ${role.errors}"]
        }

        role.save(flush: true)
        return [sucesso: "Função cadastrada com sucesso!", role: role]
    }

    def excluirFuncao(String authorityConsultada){
        def role = Funcao.where {authority == authorityConsultada}.find()
        if(!role) {
            return [erro: "Função não excluída. Erros: ${role.errors}"]
        }
        role.delete(flush: true)
        return [sucesso: "Função excluída com sucesso."]
    }

    def buscarFuncao(String funcao){
        def role = Funcao.where {authority == funcao}.find()
        if(!role){
            return [erro: "Nenhuma função encontrada."]
        }

        return [sucesso: "Função encontrada!", funcao: role]
    }
}