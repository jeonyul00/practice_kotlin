package data

// 프로젝트 전역에서 항상 같은 값을 유지해야함 : object
object CartItems {
    private val mutableProducts = mutableMapOf<Product, Int>()
    val products:Map<Product, Int> = mutableProducts

    // 상품 추가 함수
    fun addProduct(product:Product){
        mutableProducts[product]?.let {
            mutableProducts[product] = it + 1
        } ?: kotlin.run{
            mutableProducts[product] = 1
        }
    }
}