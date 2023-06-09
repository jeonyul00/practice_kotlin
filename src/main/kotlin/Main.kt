fun main(args: Array<String>) {
    println("hello world!");
    println("what your name? ");

    // val : 상수
    // readln() : 반환헝 String?, 입력받기
    val name = readln();

    // trimIndent() : 개행으로 생기는 인덴테이션 제거
    println("""
        =========================
        thank you $name
        please write the category
        =========================
    """.trimIndent())
}

