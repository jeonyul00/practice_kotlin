package screen

class ShoppingHome {

    fun start(){
        showWelcomeMessage();
        showCategories();

    }



    private fun showWelcomeMessage() {
        println("hello world! what your name?");

        val name = readln();

        println(
            """
            
            =========================
            thank you $name
            please write the category
            =========================
                   
        """.trimIndent()
        )
    }

    private fun showCategories(){
        val shoppingCategory = ShoppingCategory();
        shoppingCategory.showCategories();
    }
}