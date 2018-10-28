package com.army.groovy
//闭包与字符串的使用
def string = 'hello, groovy'
string.each {
    str -> print str * 2
}

println()

//find来查找符合条件的第一个
println string.find {
    str -> str == "l"
}

//findAll来查找所以符合条件的字符串
println string.findAll() {
    str -> str == "l"
}.toListString()

//any判断只要有一个满足条件就返回true
println string.any {
    str -> str == "l"
}

//every判断所有满足条件就返回true
println string.every {
    str -> str == "l"
}

//把每个字符转化成新的值然后返回
println string.collect {it.toUpperCase()}
