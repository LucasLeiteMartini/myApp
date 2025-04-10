package myApp



class HorarioDisponivel {

    String data
    String hora
    Profissional profissional

    static belongsTo = [profiossonal:Profissional]

    static constraints = {
        data nullable: false, blank: false;
        hora nullable: false, blank: false;
    }

    static mapping = {
        version false
    }
}
