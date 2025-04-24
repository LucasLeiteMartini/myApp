package myApp

import org.springframework.beans.factory.annotation.Autowired


class FuncaoController {

    @Autowired
    FuncaoService service

    def save(){
        if(service == null){
            status: 500
            text: "erro interno: serviço não injetado"
        }
        def role = new Funcao(params)
        def resultado = service.salvarRole(role)

        if(resultado.erro){
            flash.error = resultado.erro
        }else{
            flash.message = resultado.sucesso
        }

        redirect(action: "create")
    }

    def delete(){

        if(service == null){
            status: 500
            text: "erro interno: serviço não injetado"
        }

        def role = params.authority

        if(!role){
            flash.error = "Função não informada"
            redirect(action: "deleteForm")
            return
        }

        def resultado = service.excluirFuncao(role)

        if(resultado.erro){
            flash.error = resultado.erro
        }else{
            flash.message = resultado.suceso
        }

        redirect(action: "deleteForm")
    }

    def search(){
        if(service == null){
            status: 500
            text: "erro interno: serviço não injetado"
        }

        def role = params.authority

        if(!role){
            flash.error = "Função nao informada"
            redirect(action: "consulta")
            return
        }

        def resultado = service.buscarFuncao(role)
        if(resultado.erro){
            flash.error = resultado.erro
            redirect(action: "consulta")
            return
        }

        render(view: "consulta", model: [funcao: resultado.funcao])
    }

    def create(){}
    def deleteForm(){}
    def consulta(){}
}