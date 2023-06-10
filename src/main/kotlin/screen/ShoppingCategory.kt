package screen

import extentions.getNotEmptyString

class ShoppingCategory {

     fun showCategories() {
        val categories = arrayOf("fashion", "electronics", "pet supplies");
        for (category in categories) {
            println("=========================");
            println(category);
            println("=========================");
        }
        println("please enter # to go to cart");

        val selectedCategory = readln().getNotEmptyString();

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