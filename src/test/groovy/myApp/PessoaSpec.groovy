package myApp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PessoaSpec extends Specification implements DomainUnitTest<Pessoa> {

     void "test domain constraints"() {
        when:
        Pessoa domain = new Pessoa()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
