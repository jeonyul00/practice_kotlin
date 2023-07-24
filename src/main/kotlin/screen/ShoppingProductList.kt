package screen

import data.Product

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
            val productSize = categoryProducts.size
            for(product in categoryProducts){
                println(product.categoryLabel + product.name)
            }
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
}