
package verify

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*


public class Common {
	public static def jsonSlurper = new JsonSlurper()
	public static def jsonGetResponse

	@Keyword
	def static ResponseObject getResponseObject(TestObject request) {
		RequestObject requestObject = (RequestObject) request
		ResponseObject response = WSBuiltInKeywords.sendRequestAndVerify(requestObject)
		return response
	}

	@Keyword
	def static void verifyStatusCode(TestObject request, int expectedStatusCode) {
		if (request instanceof RequestObject) {
			ResponseObject response = Common.getResponseObject(request)
			if (response.getStatusCode() == expectedStatusCode) {
				KeywordUtil.markPassed("Response status codes match")
			} else {
				KeywordUtil.markFailed("Response status code not match. Expected: " +
						expectedStatusCode + " - Actual: " + response.getStatusCode() )
			}
		} else {
			KeywordUtil.markFailed(request.getObjectId() + " is not a RequestObject")
		}
	}


	@Keyword
	def int getIdOfNewUser(TestObject request, int age, String username, String password, String gender) {
		if (request instanceof RequestObject) {
			ResponseObject response = Common.getResponseObject(request)
		}
		def newUser = WS.sendRequest(findTestObject("Object Repository/POST a new user", ["age": age, "username": username, "password": password, "gender": gender]))
		def jsonPostResponse = jsonSlurper.parseText(newUser.getResponseText())
		return jsonPostResponse.id
	}
}
