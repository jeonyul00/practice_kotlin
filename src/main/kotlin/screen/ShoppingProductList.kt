package screen

import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식 사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식"),
    )

    private val categories:Map<String,List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    fun showProducts(selectedCategory: String){
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){
            println("""
                ******************************
                선택하신 $selectedCategory 카테고리 상품입니다.
                
            """.trimIndent())

            categoryProducts.forEachIndexed{index, product ->
                println("${index}. ${product.name}")
            }

            showCartOption(categoryProducts,selectedCategory)
            println("******************************")

        } else{
            showEmptyProductMessage()
        }
    }

    private fun showEmptyProductMessage(){
        println("""
            ******************************
            선택한 카테고리의 상품이 없습니다.
            ******************************
        """.trimIndent())
    }

    private  fun showCartOption(categoryProducts:List<Product>,selectedCategory:String){
        println("""
            장바구니에 담을 상품 번호를 선택해주세요.
        """.trimIndent())
        val selectedIndex = readlnOrNull().getNotEmptyInt()

        categoryProducts.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *을 입력해주세요.")
        }
        val answer = readlnOrNull().getNotEmptyString()

        if(answer == "#"){
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        }else if(answer == "*"){
            showProducts(selectedCategory)
        }else {
            // todo: 그 외의 값을 입력한 경우
        }

    }
}