package screen

class ShoppingCategory {

    public fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")

        println("******************************")

        for (category in categories) {
            println(category)
        }

        println(
            """
                => 장바구니로 이동하시려면 #을 입력해주세요.            
            """.trimIndent()
        )

        println("******************************")

        var selectedCategory = readlnOrNull()

        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요.")
            println("******************************")
            selectedCategory = readlnOrNull()
        }

        if (selectedCategory == "#") {
            // todo : 장바구니이동
        } else {
            if(categories.contains(selectedCategory)){
                // todo : 카테고리 목록 리스트
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