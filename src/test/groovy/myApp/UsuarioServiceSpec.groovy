package myApp

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class UsuarioServiceSpec extends Specification implements ServiceUnitTest<UsuarioService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
