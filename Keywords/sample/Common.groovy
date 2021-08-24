
package sample

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*

import java.nio.file.WatchService

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

public class Common {

	public static JsonSlurper jsonSlurper = new JsonSlurper()

	@Keyword
	def int createNewUser(int age, String username, String password, String gender, int expectedStatus) {
		def response = WS.sendRequestAndVerify(findTestObject("Object Repository/POST a new user",
				["age": age, "username": username, "password": password, "gender": gender]))

		def jsonResponse = jsonSlurper.parseText(response.getResponseText())
		return jsonResponse.id
	}

	@Keyword
	def static void findUserById(int id, int age, String username, String password, String gender, int expectedStatus) {
		WS.sendRequestAndVerify(findTestObject('Object Repository/GET user by id', [('id') : id]))
	}

	@Keyword
	def static void soap_multiply(Number first_number, Number second_number, expectedResult) {
		'Set access to external DTD allowed to verify element property'
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl")

		RequestObject requestObject = findTestObject('Object Repository/SOAP_Multiply', ["first_number": first_number, "second_number": second_number])
		ResponseObject response = WS.sendRequest(requestObject)
		println('Response value: ' + response.getResponseText())

		WS.verifyResponseStatusCode(response, 200, FailureHandling.CONTINUE_ON_FAILURE)
		WS.verifyElementPropertyValue(response, "MultiplyResponse.MultiplyResult", expectedResult)
	}
}
