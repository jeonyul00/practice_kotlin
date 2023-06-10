package extentions

// top level && 확장함수
fun String?.getNotEmptyString():String{
    var input = this
    while (input.isNullOrBlank()){
        println("please write value")
        input = readln()
    }
    return input.trim()
}

fun String?.getNotEmptyInt():Int{
    var input = this?.trim()
    while (input.isNullOrEmpty() || input.toIntOrNull() == null){
        println("please write value")
        input = readln()
    }
    return input.toInt()
}
