package myApp

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PessoaServiceSpec extends Specification implements ServiceUnitTest<PessoaService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
