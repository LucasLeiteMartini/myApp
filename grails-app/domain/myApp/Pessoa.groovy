package myApp

class Pessoa {
    String nome
    Integer idade
    String endereco
    // String cns

    static constraints = {
        nome nullable: false, blank: false
        idade min: 0
        endereco nullable: false, blank: false
        cns nullable: false, blank: false, unique: true
    }
}
