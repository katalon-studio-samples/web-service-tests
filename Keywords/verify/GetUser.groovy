package verify
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import static org.assertj.core.api.Assertions.*
import groovy.json.JsonSlurper


class GetUser {
	public static def jsonSlurper = new JsonSlurper()
	public static def jsonGetResponse

	@Keyword
	def static void getAttributeOfGETResponse(int id, TestObject request) {
		if (request instanceof RequestObject) {
			ResponseObject response = Common.getResponseObject(request)

			def jsonGetResponse = jsonSlurper.parseText(response.getResponseText())

			assertThat(jsonGetResponse.id).isEqualTo(id)

			assertThat(jsonGetResponse.username).isNotNull()

			assertThat(jsonGetResponse.password).isNotNull()

			assertThat(jsonGetResponse.gender).isNotNull()

			assertThat(jsonGetResponse.age).isNotNull()

			assertThat(jsonGetResponse.avatar).isNull()
		}
	}
}
