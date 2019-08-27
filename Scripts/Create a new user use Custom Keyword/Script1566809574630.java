import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import static org.assertj.core.api.Assertions.*

TestObject newUser = findTestObject('POST a new user', [('age') : age, ('username') : username, ('password') : password, ('gender') : gender])

CustomKeywords.'verify.Common.verifyStatusCode'(newUser, expectedStatusCode)
CustomKeywords.'verify.CreateNewUser.getAttributeOfPostResponse'(newUser, ((age) as Integer), username, password, gender)
