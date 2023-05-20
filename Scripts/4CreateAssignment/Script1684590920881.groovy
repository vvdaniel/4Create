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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

String itemDiv2

String itemDiv3

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(urlShop)

url = WebUI.getUrl()

WebUI.verifyMatch(url, urlShop, false)

// Adding item four times
for (i = 0; i < 3; i++) {
    WebUI.click(findTestObject('Shop/increaseItemNumber'))
}

WebUI.click(findTestObject('Shop/addItem'))

//Add cheapest item
CustomKeywords.'AddCheapestItem.FindCheapest'()

//Add most Expensive item
CustomKeywords.'AddMostExpensiveItem.FindMostExpensivve'()

//Set random item
Random random = new Random()

String randomDiv = random.internalNextInt(1, 30)

while ((randomDiv == itemDiv2) || (randomDiv == itemDiv3)) {
    randomDiv = random.internalNextInt(1, 30)
}

itemDiv2 = randomDiv

//Scroll to the random item
WebUI.scrollToElement(findTestObject('Shop/ItemCard/itemDiv', [('itemDiv2') : itemDiv2]), 0)

//Add random item
WebUI.click(findTestObject('Shop/ItemCard/addItem', [('itemDiv2') : itemDiv2]))

//Basket
WebUI.click(findTestObject('Object Repository/Shop/img'))

addedItemNumber = WebUI.getText(findTestObject('Shop/Basket/itemNumber', [('itemNumber') : itemNumber]))

WebUI.verifyMatch(addedItemNumber, '4 Nos.', false)

itemNumber = 2

addedItemNumber = WebUI.getText(findTestObject('Shop/Basket/itemNumber', [('itemNumber') : itemNumber]))

WebUI.verifyMatch(addedItemNumber, '1 No.', false)

itemNumber = 3

addedItemNumber = WebUI.getText(findTestObject('Shop/Basket/itemNumber', [('itemNumber') : itemNumber]))

WebUI.verifyMatch(addedItemNumber, '1 No.', false)

itemNumber = 4

addedItemNumber = WebUI.getText(findTestObject('Shop/Basket/itemNumber', [('itemNumber') : itemNumber]))

WebUI.verifyMatch(addedItemNumber, '1 No.', false)

WebUI.click(findTestObject('Object Repository/Shop/button_PROCEED TO CHECKOUT'))

WebUI.delay(2)

//Cart
url = WebUI.getUrl()

WebUI.verifyMatch(url, 'https://rahulshettyacademy.com/seleniumPractise/#/cart', false)

price = WebUI.getText(findTestObject('Shop/Cart/TotlaAmount'))

WebUI.setText(findTestObject('Object Repository/Shop/input_Total_promoCode'), price)

WebUI.click(findTestObject('Object Repository/Shop/button_Apply'))

WebUI.delay(5)

WebUI.verifyTextPresent('Invalid code ..!', false)

WebUI.verifyElementText(findTestObject('Shop/Cart/span_Invalid code'), 'Invalid code ..!')

WebUI.click(findTestObject('Object Repository/Shop/button_Place Order'))

WebUI.delay(2)

//Country
url = WebUI.getUrl()

WebUI.verifyMatch(url, 'https://rahulshettyacademy.com/seleniumPractise/#/country', false)

country = WebUI.getAttribute(findTestObject('Shop/Cart/select'), 'disabled')

WebUI.verifyMatch(country, 'true', false)

WebUI.verifyElementPresent(findTestObject('Shop/Cart/country'), 0)

WebUI.verifyElementPresent(findTestObject('Shop/termsConditions'), 0)

totalCountry = WebUI.getNumberOfTotalOption(findTestObject('Shop/Cart/country'))

println(totalCountry)

String randomCon = random.internalNextInt(2, totalCountry)

println(randomCon)

WebUI.selectOptionByIndex(findTestObject('Shop/Cart/country'), randomCon)

WebUI.click(findTestObject('Shop/button_Proceed'))

WebUI.verifyElementPresent(findTestObject('Shop/b_Please accept Terms  Conditions - Required'), 0)

WebUI.click(findTestObject('Object Repository/Shop/termsConditions'))

WebUI.click(findTestObject('Shop/button_Proceed'))

WebUI.verifyElementPresent(findTestObject('Shop/div_Thank you, your order has been placed successfully  Youll be redirected to Home page shortly'), 
    0)

WebUI.delay(5)

//Home page
url = WebUI.getUrl()

WebUI.verifyMatch(url, urlShop, false)

//webdriveruniversity
WebUI.executeJavaScript('window.open();', [])

String currentWin = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentWin + 1)

WebUI.switchToWindowIndex(1)

WebUI.navigateToUrl(urlWeb)

url = WebUI.getUrl()

WebUI.verifyMatch(url, urlWeb, false)

WebUI.scrollToElement(findTestObject('webdriveruniversity/div_ACTIONS'), 0)

WebUI.takeScreenshot(screenshotsDestination + '\\screenshot1.png')

WebUI.click(findTestObject('Object Repository/webdriveruniversity/div_ACTIONS'))

WebUI.switchToWindowTitle('WebDriver | Actions')

WebUI.switchToWindowIndex(1)

WebUI.takeScreenshot(screenshotsDestination + '\\screenshot2.png')

WebUI.switchToWindowIndex(2)

String windowTitle = WebUI.getWindowTitle()

WebUI.println(windowTitle)

WebUI.verifyMatch(windowTitle, 'WebDriver | Actions', false)

WebUI.dragAndDropToObject(findTestObject('webdriveruniversity/div_DRAG ME TO MY TARGET'), findTestObject('webdriveruniversity/div_DROP HERE'))

WebUI.verifyElementText(findTestObject('webdriveruniversity/div_DROP HERE'), 'Dropped!')

WebUI.verifyElementNotVisible(findTestObject('webdriveruniversity/a_Link 1'))

WebUI.mouseOver(findTestObject('Object Repository/webdriveruniversity/button_Hover Over Me First'))

WebUI.verifyElementPresent(findTestObject('webdriveruniversity/a_Link 1'), 0)

WebUI.click(findTestObject('Object Repository/webdriveruniversity/a_Link 1'))

WebUI.verifyAlertPresent(0)

WebDriver driver = DriverFactory.getWebDriver()

String AlertText = driver.switchTo().alert().getText()

WebUI.println(AlertText)

WebUI.dismissAlert()

WebUI.switchToWindowIndex(1)

WebUI.closeWindowIndex(1)

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(urlConntactPage)

url = WebUI.getUrl()

WebUI.verifyMatch(url, urlConntactPage, false)

WebUI.setText(findTestObject('webdriveruniversity/textarea_CONTACT US_message'), AlertText)

