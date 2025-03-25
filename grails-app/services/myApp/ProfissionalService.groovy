package myApp

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@Transactional
@CompileStatic
class ProfissionalService {

    def salvarProfissional(Profissional profissional) {
        if (!profissional.validate()) {
            return [erro: "Erro ao cadastrar: ${profissional.errors}"]
        }

        profissional.save(flush: true)
        return [sucesso: "Profissional cadastrado com sucesso!", profissional: profissional]
    }

    def excluirProfissional(String crmConsultado) {
        def profissional = Profissional.where { crm == crmConsultado }.find()
        if (!profissional) {
            return [erro: "Profissional com CRM ${crmConsultado} não encontrado!"]
        }

        profissional.delete(flush: true)
        return [sucesso: "Profissional com CRM ${crmConsultado} excluído com sucesso."]
    }

    def buscarPorCrm(String crmConsultado) {
        def profissional = Profissional.where { crm == crmConsultado }.find()
        if (!profissional) {
            return [erro: "Nenhum profissional encontrado com o CRM ${crmConsultado}."]
        }

        return [sucesso: "Profissional encontrado!", profissional: profissional]
    }
}
