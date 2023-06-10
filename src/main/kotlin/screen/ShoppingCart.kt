package screen

import data.CartItems
import extentions.getNotEmptyString

class ShoppingCart:Screen() {
    private val products = CartItems.products

    // 추가된 아이템을 보여주는 함수
    fun showCartItems(){
        ScreenStack.push(this)
        if(products.isNotEmpty()){
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        this is your product list in cart 
                    """.trimIndent()){
                    product -> "category : ${product.categoryLabel} / name : ${product.nameLabel} / amount : ${products[product]}"
                }
            )
        } else{
            println("""
                empty your cart
            """.trimIndent())
        }
        showPrevScreen()
    }


    private fun showPrevScreen(){
        println("""
            do you want go back? (y/n)
        """.trimIndent())

        when(readlnOrNull().getNotEmptyString()){
            "y"-> {
                moveToPrevScreen()
            }
            "n" -> {
                showCartItems()
            }
            else -> {
                // todo : 재입력
            }
        }
    }

    private fun moveToPrevScreen(){
        ScreenStack.pop()
        when (val prevScreen = ScreenStack.peek()){
            is ShoppingCategory -> {
                prevScreen.showCategories()
            }
            is ShoppingProductList -> {
                prevScreen.showSelectProducts()
            }
            else -> {}
        }

    }
}
