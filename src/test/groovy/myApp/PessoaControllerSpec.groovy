package myApp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PessoaControllerSpec extends Specification implements ControllerUnitTest<PessoaController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
