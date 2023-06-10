package screen

import LINE
import extentions.getNotEmptyString

class ShoppingCategory :Screen(){

     fun showCategories() {
         ScreenStack.push(this)
        val categories = arrayOf("fashion", "electronics", "pet supplies");
        for (category in categories) {
            LINE
            println(category);

        }
        println("please enter # to go to cart");

        val selectedCategory = readln().getNotEmptyString();

        if (selectedCategory == "#") {
            var shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            // contains : 존재유무를 참거짓으로 반환
            if(categories.contains(selectedCategory)){
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showSelectProducts()
            }else{
                println("");
                println("[$selectedCategory] : this category is not find");
                showCategories();
            }


        }
    }


}