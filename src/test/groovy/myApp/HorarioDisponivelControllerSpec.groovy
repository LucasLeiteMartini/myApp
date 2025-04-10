package myApp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HorarioDisponivelControllerSpec extends Specification implements ControllerUnitTest<HorarioDisponivelController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
