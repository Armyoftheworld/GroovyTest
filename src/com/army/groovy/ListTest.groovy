package com.army.groovy

//默认是ArrayList
def list = [1, 2, 3, 4, 5]
//println(list.class)
//这样强转成int数组
def intArray = [1, 2, 3, 4, 5] as int[]
//或者这样写
int[] intArrays = [1, 2, 3, 4, 5]

println list - [3, 4]
println list + [3, 4]

//list的排序
def sortedList = [-9, 5, 2, -2, 4]
//java写法
//Comparator<Integer> comparator = {
//    a, b -> a == b ? 0 : Math.abs(a) - Math.abs(b)
//}
//Collections.sort(sortedList, comparator)
//groovy写法
sortedList.sort()
sortedList.sort {
    a, b -> Math.abs(a) - Math.abs(b)
}
//println(sortedList)

def stringList = ['abc', 'de', "efgh", 'i']
stringList.sort { item -> item.length() }
//println(stringList)

//查找
def findList = [-9, 5, 2, -2, 4]
def result = findList.find { it -> it % 2 == 0 }
//println result
def allResult = findList.findAll { it -> it % 2 == 0 }
//println allResult
def anyResult = findList.any { it -> it % 2 == 0 }
//println anyResult
def everyResult = findList.every { it -> it % 2 == 0 }
//println everyResult
def min = findList.min()
min = findList.min{ it -> Math.abs(it)}
//println(min)
def max = findList.max()
max = findList.max { it -> Math.abs(it)}
//println(max)
//统计
println findList.count { it -> it % 2 == 0 }