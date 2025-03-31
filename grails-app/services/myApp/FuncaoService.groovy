package myApp

import groovy.transform.CompileStatic

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
    }


}