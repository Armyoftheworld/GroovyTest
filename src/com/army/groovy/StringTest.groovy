package com.army.groovy

def string1 = 'a single \'string\''
//三个单引号里面按照输入的格式生成，在三个单引号后面加\表示不生成接下来的换行，不加的话会多一个换行
def threeString = '''\
line one
    line two
        line three'''
//println(threeString)

def doubleString = "say: $string1"
//println(doubleString)
//println(doubleString.class)

//println "the sum of 2 plus 3 is ${2 + 3}"

def groovy = "groovy"
//从字符串的两边填充给定字符串以达到给定的长度，先从右边开始填充
println groovy.center(9, "a")
//从字符串的左边填充给定字符串以达到给定的长度
println groovy.padLeft(9, "a")
//从字符串的右边填充给定字符串以达到给定的长度
println groovy.padRight(9, "a")

//字符串的比较
def hello = "hello"
println groovy.compareTo(hello)
//字符串普通的比较还可以直接用符号比较
println groovy < hello

//获取第一个字符，下面两种方式等价
//println groovy.getAt(0)
println groovy[0]

//获取范围的字符串
println groovy[0..1]

//字符串的减法，把原字符串中一个给定的字符串去掉，下面两种写法等价
def str = "o"
println(groovy.minus(str))//结果：grovy
println(groovy - str)//结果：grovy

//字符串的倒序
println groovy.reverse()
//首字母大写方法
println(groovy.capitalize())

println("12345".toLong().class)
