package com.army.groovy
//逻辑控制测试
def x = 1.23
def result
//case的类型可以是任意类型
switch (x) {
    case "abc":
        result = 'string'
        break
    case [1, 1.23, 2, 'a']:
        result = 'list'
        break
    case 1..2:
        result = 'range'
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'bigdecimal'
        break
    default:
        result = 'unknow'
        break
}
println(result)

//对范围的for循环
def sum = 0
for (i in 0..9) {
    sum += i
}
println(sum)

//对list的循环
sum = 0
for (i in [1, 2, 3, 4, 5]) {
    sum += i
}
println(sum)

//对map的循环
sum = 0
for (i in ['a': 1, 'b': 2, 'c': 3]) {
    sum += i.value
}
println(sum)
