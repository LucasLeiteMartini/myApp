package myApp

class Pessoa {
    String nome
    Integer idade
    String endereco
    
    static constraints = {
        nome nullable: false, blank: false
        idade min: 0
        endereco nullable: false, blank: false
    }
}