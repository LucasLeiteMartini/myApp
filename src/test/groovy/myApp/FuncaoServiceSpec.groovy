package myApp

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class FuncaoServiceSpec extends Specification implements ServiceUnitTest<FuncaoService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
