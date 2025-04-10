package myApp

import grails.gorm.transactions.Transactional

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



    def buscarPorCns() {
        def cns = params.cns
        def origem = params.origem
        if (!cns) {
            flash.error = "CNS não informado"
            redirect(action: origem == 'delete' ? 'deleteForm' : 'consulta')
            return
        }

        def resultado = service.buscarPorCns(cns)

        if (resultado.erro) {
            flash.error = resultado.erro
            redirect(action: origem == 'delete' ? 'deleteForm' : 'consulta')
            return 
        } 

        if(origem == 'delete'){
            render(view:"deleteForm", model: [pessoa: resultado.pessoa])
        }else{
            render(view: "consulta", model: [pessoa: resultado.pessoa])
        }

    }

    def create(){}
    def deleteForm(){}
    def consulta(){}
}   
