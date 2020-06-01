import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.After

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

def response = WS.sendRequestAndVerify(findTestObject("Object Repository/POST a new user",
	["age": age, "username": username, "password": password, "gender": gender]))

//println '' + response.getResponseText()

def respone1 = WS.sendRequest(findTestObject('Object Repository/POST a new user'))

WS.verifyElementPropertyValue(respone1, "age", 25)

//WS.verifyElementPropertyValue(response, "age", 25)
//WS.verifyElementPropertyValue(response, "username", "mimi")
//WS.verifyElementPropertyValue(response, "password", "123456789")
//WS.verifyElementPropertyValue(response, "gender", "MALE")



//WS.sendRequestAndVerify(findTestObject('Object Repository/GET user by id', [('id') : id]))