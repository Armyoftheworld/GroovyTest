package com.army.groovy

def numberAdd(int x, int y) {
    return x + y
}

//调用至少包含一个参数的方法时可以不需要使用括号，但是这种方式只限制于单独调用该方法
numberAdd 1, 2
//和其他方法组合调用的话，必须用括号
println numberAdd(1, 2)


