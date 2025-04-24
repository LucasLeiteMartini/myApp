package myApp

import org.springframework.beans.factory.annotation.Autowired

class ProfissionalController {
   
    @Autowired
    ProfissionalService service

    def save() {
        if(service == null){
            status: 500
            text: "erro interno. serviço não injetado"
        }

        def profissional = new Profissional(params)
        def resultado = service.salvarProfissional(profissional)

        if (resultado.erro) {
            flash.error = resultado.erro
        } else {
            flash.message = resultado.sucesso
        }

        redirect(action: "create")
    }

    def delete() {
        if(service == null){
            status: 500
            text: "erro interno. serviço não injetado"
        }

        def crm = params.crm

        if (!crm) {
            flash.error = "CRM não informado"
            redirect(action: "deleteForm")
            return
        }

        def resultado = service.excluirProfissional(crm)

        if (resultado.erro) {
            flash.error = resultado.erro
        } else {
            flash.message = resultado.sucesso
        }

        redirect(action: "deleteForm")
    }

    def update(){
        def crm = params.crm as String
        def resultado = service.atualizarProfissional(crm, params)

        if(resultado.erro){
            flash.error = resultado.erro
            redirect(action: "atualizar")
        }else{
            flash.message = resultado.sucesso
            redirect(action: "atualizar")
        }
    }

    def search() {
        if(service == null){
            status: 500
            text: "erro interno. serviço não injetado"
        }

        def crm = params.crm
        def origem = params.origem

        if (!crm) {
            flash.error = "CRM não informado"
            if(origem == 'delete'){
                redirect(action: "deleteForm")
            }else if(origem == 'atualizar'){
                redirect(action: "atualizar")
            }else{
                redirect(action: "consulta")
            }
            return
        }

        def resultado = service.buscarPorCrm(crm)

        if (resultado.erro) {
            flash.error = resultado.erro
            if(origem == 'delete'){
                redirect(action: "deleteForm")
            }else if(origem == 'atualizar'){
                redirect(action: "atualizar")
            }else{
                redirect(action: "consulta")
            }
            return
        }

        if (origem == 'delete') {
            render(view: "deleteForm", model: [profissional: resultado.profissional])
        } else if(origem == 'atualizar'){
            render(view: "atualizar", model: [profissional: resultado.profissional])
        }else{
            render(view: "consulta", model: [profissional: resultado.profissional])
        }
    }

    def atualizar(){}
    def create() {}
    def deleteForm() {}
    def consulta() {}
}
