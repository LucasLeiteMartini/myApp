package myApp

import groovy.transform.CompileStatic

import grails.gorm.transactions.Transactional

@Transactional
@CompileStatic
class UsuarioService {

    def salvarUser(Usuario user) {
        if(!user.validate()){
            return [erro: "Erro ao validar usuário: ${user.errors}"]
        }

        user.save(flush: true)
        return [sucesso: "Usuário cadastrado com sucesso!", pessoa: user]
    }

    def excluirUser(String userConsultado){
        def user = Usuario.where{username == userConsultado }.find()
        if(!user){
            return [erro: "Usuario ${userConsultado} não encontrado!"]
        }
        user.delete(flush: true)
        return [sucesso: "Usuário ${userConsultado} encontrado!"]
    }


}