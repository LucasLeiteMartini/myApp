package myApp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class HorarioDisponivelSpec extends Specification implements DomainUnitTest<HorarioDisponivel> {

     void "test domain constraints"() {
        when:
        HorarioDisponivel domain = new HorarioDisponivel()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
