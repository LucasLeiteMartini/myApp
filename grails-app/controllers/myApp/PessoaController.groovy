package myApp

import org.springframework.beans.factory.annotation.Autowired


class PessoaController {

    @Autowired //força a injeção de serviço
    PessoaService service

    def save() {
        if(service==null){
            render status: 500, text: "erro interno: servicec não injetado"
            return
        }

        def pessoa = new Pessoa(params)

        def resultado = service.salvarPessoa(pessoa)
    
        if(resultado.erro){
            flash.error = resultado.erro
        } else {
            flash.message = resultado.sucesso
        }
    
        redirect(action: "create")

    }



    def delete() {
        if(service == null){
            render status: 500, text: "erro interno: serviço não injetado"
        }

        def cns = params.cns

        if (!cns) {
            flash.error = "CNS não informado"
            redirect(action: "deleteForm")
            return
        }
        
        def resultado = service.excluirPessoa(cns)
    
        if (resultado.erro) {
            flash.error = resultado.erro
        } else {
            flash.message = resultado.sucesso
        }
    
        redirect(action: "deleteForm")
    }

    def update(){
        def cns = params.cns as String
        def resultado = service.atualizarPessoa(cns, params)

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
            text: "erro interno: serviço não injetado"
        }

        def cns = params.cns
        def origem = params.origem

        if (!cns) {
            flash.error = "CNS não informado"
            if(origem == 'delete'){
                redirect(action: "deleteForm")
            }else if(origem == 'atualizar'){
                redirect(action: "atualizar")
            }else{
                redirect(action: "consulta")
            }
            return
        }

        def resultado = service.buscarPorCns(cns)

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

        if(origem == 'delete'){
            render(view:"deleteForm", model: [pessoa: resultado.pessoa])
        }else if(origem == 'atualizar'){
            render(view: "atualizar", model: [pessoa: resultado.pessoa])
        }else{
            render(view: 'consulta', model: [pessoa: resultado.pessoa])
        }

    }

    def create(){}
    def deleteForm(){}
    def consulta(){}
    def atualizar(){}
}   
