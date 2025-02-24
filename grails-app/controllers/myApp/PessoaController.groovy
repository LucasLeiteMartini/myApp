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

    def delete(Long id){
        def pessoaId = params.id as Long

        if(!pessoaId){
            flash.error = "ID inválido"
            redirect(action: "deleteForm")
            return
        }

        def resultado = service.exlcuirPessoa(pessoaId)

        if(resultado.erro){
            flash.error = resultado.erro
        }
        flash.message = resultado.sucesso

        redirect(action: "deleteForm")
    }

    def create(){}
    def deleteForm(){}
}   
