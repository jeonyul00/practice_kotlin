fun main(args: Array<String>) {
    println("hello world! what your name?");

    val name = readln();

    println("""
        
        =========================
        thank you $name
        please write the category
        =========================
               
    """.trimIndent())


    val categories = arrayOf("fashion", "electronics", "pet supplies" );

    for(category in categories){
        println(category);
    }
    println("please enter # to go to cart");

    var selectedCategory = readln();

    while(selectedCategory.isNullOrBlank()){
        println("please re write");
        selectedCategory = readln();
    }

    if(selectedCategory == "#"){
        // todo : 장바구니 이동
    } else{
        // todo : 카테고리 상품 목록
        // todo : 카테고리 목록에 없는 값을 입력하는 경우
    }

}