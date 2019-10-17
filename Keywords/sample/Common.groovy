
package sample

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

public class Common {

	public static JsonSlurper jsonSlurper = new JsonSlurper()

	def static void verifyStatusCode(ResponseObject response, int expectedStatusCode) {
		if (response.getStatusCode() == expectedStatusCode) {
			KeywordUtil.markPassed("Response status codes match")
		} else {
			KeywordUtil.markFailed("Response status code not match. Expected: ${expectedStatusCode} - Actual: ${response.getStatusCode()}")
		}
	}

	@Keyword
	def int createNewUser(int age, String username, String password, String gender, int expectedStatus) {
		def response = WS.sendRequest(findTestObject("Object Repository/POST a new user",
				["age": age, "username": username, "password": password, "gender": gender]))

		Common.verifyStatusCode(response, expectedStatus)
		WS.verifyElementPropertyValue(response, "age", age)
		WS.verifyElementPropertyValue(response, "username", username)
		WS.verifyElementPropertyValue(response, "password", password)
		WS.verifyElementPropertyValue(response, "gender", gender)

		def jsonResponse = jsonSlurper.parseText(response.getResponseText())
		return jsonResponse.id
	}

	@Keyword
	def static void findUserById(int id, int age, String username, String password, String gender, int expectedStatus) {
		def response = WS.sendRequest(findTestObject('Object Repository/GET user by id', [('id') : id]))

		Common.verifyStatusCode(response, expectedStatus)
		WS.verifyElementPropertyValue(response, "id", id)
		WS.verifyElementPropertyValue(response, "age", age)
		WS.verifyElementPropertyValue(response, "username", username)
		WS.verifyElementPropertyValue(response, "password", password)
		WS.verifyElementPropertyValue(response, "gender", gender)
	}
}
