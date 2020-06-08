<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GET user by id</name>
   <tag></tag>
   <elementGuidId>4fc9a73f-74bc-40c9-8fc4-73c6c0da00d6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}/api/users/${id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>21</defaultValue>
      <description></description>
      <id>0de4fa76-1864-4d5e-aa8a-70ad8f4f4342</id>
      <masked>false</masked>
      <name>age</name>
   </variables>
   <variables>
      <defaultValue>'ngoc'</defaultValue>
      <description></description>
      <id>086a27a9-05ed-4e07-8465-e17bddfdeac1</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>'1234567890'</defaultValue>
      <description></description>
      <id>311c2780-afd0-4352-a23f-fc00c2c42271</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <variables>
      <defaultValue>'https://www.rd.com/wp-content/uploads/2019/06/lily-of-the-valley-760x506.jpg'</defaultValue>
      <description></description>
      <id>bcddbada-1d5e-422c-b810-55f7c48bb931</id>
      <masked>false</masked>
      <name>avatar</name>
   </variables>
   <variables>
      <defaultValue>'FEMALE'</defaultValue>
      <description></description>
      <id>3b3cb3f6-19ff-4f44-ae2c-a1c680bd3044</id>
      <masked>false</masked>
      <name>gender</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.successCode</defaultValue>
      <description></description>
      <id>f1c9042c-8dca-4d38-ba9e-77542f9e8d20</id>
      <masked>false</masked>
      <name>expectedStatusCode</name>
   </variables>
   <variables>
      <defaultValue>7</defaultValue>
      <description></description>
      <id>c4249c68-7dc1-4ffc-ad8e-a4109ce4bb7b</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
assert response.getStatusCode() == 200
WS.verifyElementPropertyValue(response, &quot;age&quot;, 25)
WS.verifyElementPropertyValue(response, &quot;username&quot;, &quot;mimi&quot;)
WS.verifyElementPropertyValue(response, &quot;password&quot;, &quot;123456789&quot;)
WS.verifyElementPropertyValue(response, &quot;gender&quot;, &quot;MALE&quot;)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
