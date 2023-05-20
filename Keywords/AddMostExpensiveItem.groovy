import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




class AddMostExpensiveItem {

	// Find the most expensive item
	@Keyword
	def FindMostExpensivve() {

		int priceMax = 0
		int price2
		int i
		String price
		String itemDiv
		String itemDiv2

		for (i = 1; i < 31; i++) {
			itemDiv = i

			price = WebUI.getText(findTestObject('Shop/ItemCard/price', [('itemDiv') : itemDiv]))

			price2 = price.toInteger()

			if (price2 > priceMax) {
				priceMax = price2

				itemDiv2 = i
			}
		}

		println((('ItemDiv 2 value: ' + itemDiv2) + ' The maximum price: ') + priceMax)

		//Scroll to the most expensive item
		WebUI.scrollToElement(findTestObject('Shop/ItemCard/addItem', [('itemDiv2') : itemDiv2]), 0)

		//Add the most expensive item
		WebUI.click(findTestObject('Shop/ItemCard/addItem', [('itemDiv2') : itemDiv2]))

		return itemDiv2
	}

}