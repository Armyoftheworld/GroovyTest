package com.army.groovy

//默认是LinkedHashMap，可以通过as HashMap来转换
def colorMap = [
        red  : "ff00ff",
        blue : "ffff00",
        green: "ff0000"
]
println(colorMap)
//获取元素
println(colorMap.red)
println(colorMap['red'])
//添加元素
colorMap.yellow = '00ff00'
//添加一个map
colorMap << [white: 'ffffff']
println(colorMap)
//可以添加任意类型的value
colorMap.black = 1
colorMap.complex = [1: 1, 2: 2]
println(colorMap)

//map操作详解
def students = [
        1: ['number': '0001', 'name': 'Bob', 'score': 56, 'sex': 'male'],
        2: ['number': '0002', 'name': 'Tom', 'score': 76, 'sex': 'female'],
        3: ['number': '0003', 'name': 'David', 'score': 66, 'sex': 'male'],
        4: ['number': '0004', 'name': 'Army', 'score': 88, 'sex': 'female'],
]
students.each {
//    student -> println "the key is ${student.key}, the value is ${student.value}"
}
//直接遍历key和value
students.each {
//    key, value -> println "the key is ${key}, the value is ${value}"
}
students.eachWithIndex { student, index ->
//    println "this index is $index, the key is ${student.key}, the value is ${student.value}"
}

//map的查找
def result = students.find { student -> student.value.score >= 60 }
//println(result)

result = students.findAll { student -> student.value.score >= 60 }
//println(result)

def count = students.count {
    student -> student.value.score >= 60 && student.value.sex == 'male'
}
//println(count)

result = students.findAll { student -> student.value.score >= 60 }.collect { it.value.name }
println(result)

result = students.groupBy {
    student -> student.value.score >= 60 ? '及格' : '不及格'
}
println(result)

//map的排序，返回一个新的map
result = students.sort{
    stu1, stu2 -> stu1.value.score - stu2.value.score
}
println(result)
