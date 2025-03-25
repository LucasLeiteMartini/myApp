package myApp

class ProfissionalController {
   
    @Autowired
    ProfissionalService service

    def save() {
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

    def buscarPorCrm() {
        def crm = params.crm
        def origem = params.origem

        if (!crm) {
            flash.error = "CRM não informado"
            redirect(action: origem == 'delete' ? 'deleteForm' : 'consulta')
            return
        }

        def resultado = service.buscarPorCrm(crm)

        if (resultado.erro) {
            flash.error = resultado.erro
            redirect(action: origem == 'delete' ? 'deleteForm' : 'consulta')
            return
        }

        if (origem == 'delete') {
            render(view: "deleteForm", model: [profissional: resultado.profissional])
        } else {
            render(view: "consulta", model: [profissional: resultado.profissional])
        }
    }

    def create() {}
    def deleteForm() {}
    def consulta() {}
}
