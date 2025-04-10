package myApp

class Profissional {
    String nome
    String crm
    String especialidade
    

    static constraints = {
        nome nullable: false, blank: false
        crm nullable: false, blank: false, unique: true
        especialidade nullable: false, blank: false
    }

    static mapping = {
        version false
    }
}