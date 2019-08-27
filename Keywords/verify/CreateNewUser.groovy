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

class CreateNewUser {
	public static def jsonSlurper = new JsonSlurper()
	public static def jsonGetResponse

	//@Keyword
	def int getIdOfNewUser(TestObject request, int age, String username, String password, String avatar, String gender) {
		if (request instanceof RequestObject) {
			RequestObject requestObject = (RequestObject) request
			ResponseObject response = WSBuiltInKeywords.sendRequest(requestObject)
		}
		def newUser= WS.sendRequest(findTestObject("Object Repository/POST a new user", ["age": age, "username": username, "password": password,  "gender": gender]))
		def jsonPostResponse = jsonSlurper.parseText(newUser.getResponseText())
		return jsonPostResponse.id
	}

	@Keyword
	def getAttributeOfPostResponse(TestObject request, int age, String username, String password, String gender) {
		if (request instanceof RequestObject) {
			ResponseObject response = Common.getResponseObject(request)

			def jsonPostResponse = jsonSlurper.parseText(response.getResponseText())
			assertThat(jsonPostResponse.id).isNotNull()
			WS.verifyElementPropertyValue(response, "age", age)
			WS.verifyElementPropertyValue(response, "username", username)
			WS.verifyElementPropertyValue(response, "password", password)
			WS.verifyElementPropertyValue(response, "gender", gender)
		}
	}
}