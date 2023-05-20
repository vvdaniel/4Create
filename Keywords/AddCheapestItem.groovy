import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



class AddCheapestItem {

	//  Find the cheapest item
	@Keyword
	def FindCheapest (){
		int priceMin = 600
		int price2
		int i
		String price
		String itemDiv
		String itemDiv2
		String itemDiv3

		for (i = 1; i < 31; i++) {
			itemDiv = i

			price = WebUI.getText(findTestObject('Shop/ItemCard/price', [('itemDiv') : itemDiv]))

			price2 = price.toInteger()

			if (price2 < priceMin) {
				priceMin = price2

				itemDiv2 = i

				itemDiv3 = i
			}
		}

		println((('ItemDiv 2 value: ' + itemDiv2) + ' The minimum price: ') + priceMin)

		//Add the cheapest item
		WebUI.click(findTestObject('Shop/ItemCard/addItem', [('itemDiv2') : itemDiv2]))

		return itemDiv3
	}
}