package extensions

fun String?.getNotEmptyString():String{
    var input = this
    while (input.isNullOrBlank()){
        println("값을 입력해주세요.")
        input = readlnOrNull()
    }
    return  input.trim()
}

fun String?.getNotEmptyInt(): Int{
    var input = this?.trim()
    while (input.isNullOrBlank() || input.toIntOrNull() == null){
        println("값을 입력해주세요.")
        input = readlnOrNull()
    }
    return  input.toInt()
}