package screen

import data.CartItems

class ShoppingCart {
    private val products = CartItems.products

    // 추가된 아이템을 보여주는 함수
    fun showCartItems(){
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
    }
}
