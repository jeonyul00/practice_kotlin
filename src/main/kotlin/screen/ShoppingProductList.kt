package screen

import data.CartItems
import data.Product
import extentions.getNotEmptyInt
import extentions.getNotEmptyString

class ShoppingProductList {
    private val products = arrayOf(
        Product("fashion", "T-Shirt"),
        Product("fashion", "pants"),
        Product("electronics", "macbook"),
        Product("electronics", "I-Pad"),
        Product("pet supplies", "Cat-Snack"),
        Product("pet supplies", "Dog-Snack"),
    )


    // 카테고리 레이블을 기준으로 조회
    private val categories:Map<String, List<Product>> = products.groupBy { products -> products.categoryLabel }


    // 요청한 카테고리 상품 출력
    fun showSelectProducts(selectCategory: String){
        val categoryProducts = categories[selectCategory]

        if(!categoryProducts.isNullOrEmpty()){
            println("""
                
                선택하신 [$selectCategory] 카테고리의 상품입니다.
                """.trimIndent())

            for ((index, value) in categoryProducts.withIndex()) {
                println("${index}. ${value.nameLabel}")
            }

            showCartOption(categoryProducts,selectCategory)
        }else{
            println("[$selectCategory] : this category is not find");
        }
    }

    private fun showCartOption(categoryProduct:List<Product>,selectCategory:String){
        println("""
            please enter product number 
        """.trimIndent())

        val  selectedIndex = readln().getNotEmptyInt()

        categoryProduct.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> if you want to go to your shopping cart press \"#\" or if you want to continue shopping, press \"*\"")
            var answer = readln().getNotEmptyString()

            if(answer == "#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            } else if(answer == "*"){
                showSelectProducts(selectCategory)
            }
            else {
                // todo: 다른 값 입력 시
            }

        }
    }


}