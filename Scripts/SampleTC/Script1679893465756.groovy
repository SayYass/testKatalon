import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://moonlay.com/contact-us/')

myObject = findTestObject('Moonlay/ContactUS_input_FirstName')

// Variabel (Bisa dikembangkan dengan mengambil value dari excel sehingga lebih reusable untuk kedepannya)
firstName = 'Ilyas'

LastName = 'Dewanto'

dtEmail = 'email@gmail.com'

dtPhone = '089998778998'

service = 'Apps'

dtMessage = 'Test Message untuk katalon moonlay'

findTestObject('Object Repository/Moonlay/ContactUS_input_PhoneNumber')

if (WebUI.verifyElementPresent(myObject, 10)) {
    WebUI.setText(findTestObject('Moonlay/ContactUS_input_FirstName'), firstName)

    WebUI.setText(findTestObject('Moonlay/ContactUS_input_LastName'), LastName)

    WebUI.setText(findTestObject('Moonlay/ContactUS_input_Email'), dtEmail)

    WebUI.setText(findTestObject('Moonlay/ContactUS_input_PhoneNumber'), dtPhone)

    WebUI.click(findTestObject('Moonlay/ContactUS_dropdown_Service'))

    //	Validasi Dropdown (sebenarnya kalo class yang terdeteksi 'select' maka bisa langsung di select. namun case kali ini class yang terdeteksi adalah span. maka dari itu dibuat validasi manual
    if (service == 'Apps') {
        WebUI.click(findTestObject('Moonlay/li_Apps and Cloud'));
    } else if (service == 'Brain') {
        WebUI.click(findTestObject('Moonlay/li_Brain Resources'));
    }
    
    WebUI.setText(findTestObject('Moonlay/ContactUS_input_Message'), dtMessage);

    WebUI.click(findTestObject('Moonlay/button_Submit Form'));
	
//	Verifikasi Bahwa objek yang di inginkan sudah muncul
	WebUI.verifyElementVisible(findTestObject('Moonlay/Verifikasi_ContactUs Berhasil'));
	
} else {
    WebUI.closeBrowser()
}



