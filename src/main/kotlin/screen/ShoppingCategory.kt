package screen

import extensions.getNotEmptyString

class ShoppingCategory {

    public fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")

        println(LINE_DIVIDER)

        for (category in categories) {
            println(category)
        }

        println(
            """
                => 장바구니로 이동하시려면 #을 입력해주세요.            
            """.trimIndent()
        )

        println(LINE_DIVIDER)

        val selectedCategory = readlnOrNull().getNotEmptyString()

        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()

        } else {
            if(categories.contains(selectedCategory)){
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else{
                showErrormessage(selectedCategory)
            }

        }
    }

    private fun showErrormessage(selectedCategory: String?) {
        println("$selectedCategory 존재하지 않는 카테고리 입니다. 다시 입력해주세요.")
        showCategories()
    }
}