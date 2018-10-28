package com.army.groovy
//闭包与基本数据类型的配合使用

//求阶乘
//如果方法的最后一个参数是闭包，那么大括号可以写到方法外面
int fab(int num) {
    def result = 1
    1.upto(num) { n ->
        result *= n
    }
    return result
}

//求阶乘
int fab2(int num) {
    def result = 1
    num.downto(1) {
        n -> result *= n
    }
    return result
}

println fab(5)
println fab2(5)

//累加
int count(int number) {
    def result = 0
    number.times {
        //num从0开始
        num -> result += num + 1
    }
    return result
}

println count(100)