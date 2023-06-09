package screen

import data.Product

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
                println("${index+1}. ${value.nameLabel}")
            }

        }else{
            println("[$selectCategory] : this category is not find");
        }
    }
}