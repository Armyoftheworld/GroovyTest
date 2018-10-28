package com.army.groovy
//闭包的基本用法
def closure = {String name, int age ->
    println "name = $name, age = $age"
}
//闭包的执行，以下两种方式等价
closure.call("army", 18)
println closure("army", 18)

//每个闭包有隐藏的入参it
def closure_it = {
    it -> println "it = $it"
}
println closure_it(12)

//每个闭包都有返回值，不写return的话是最后一行代码的结果，如果最后一行的代码没有返回值，那闭包的返回值就是null
def closure_add = {int x, int y ->
    println "x = $x, y = $y"
//    return x + y
    x + y
}
println closure_add(1, 2)

