package myApp

import org.springframework.beans.factory.annotation.Autowired

class UsuarioController {

    @Autowired
    UsuarioService service

    def save() {
        if(service == null){
            render status: 500, text: "erro interno: serviço não injetado"
        }


        def user = new Usuario(params)

        def resultado = service.salvarUser(user)

        if(resultado.erro){
            flash.error = resultado.erro
        }else{
            flash.message = resultado.sucesso
        }

        redirect(action: "create")
    }




    def create(){}
}