package screen

class ShoppingCategory {

     fun showCategories() {
        val categories = arrayOf("fashion", "electronics", "pet supplies");
        for (category in categories) {
            println(category);
        }
        println("please enter # to go to cart");

        var selectedCategory = readln();

        while (selectedCategory.isNullOrBlank()) {
            println("");
            println("please re write");
            selectedCategory = readln();
        }

        if (selectedCategory == "#") {
            var shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            // contains : 존재유무를 참거짓으로 반환
            if(categories.contains(selectedCategory)){
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showSelectProducts(selectedCategory);
            }else{
                println("");
                println("[$selectedCategory] : this category is not find");
                showCategories();
            }


        }
    }
}