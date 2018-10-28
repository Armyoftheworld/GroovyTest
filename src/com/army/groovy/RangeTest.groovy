package com.army.groovy

def range = 1..10
println(range[0])
println(range.contains(1))
println(range.from)
println(range.to)

range.each {
    println(it)
}

def getGrade(Number num) {
    def result
    switch (num) {
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<80:
            result = '良好'
            break
        case 80..100:
            result = '优秀'
            break
        default:
            result = 'unknow'
            break
    }
    return result
}

println getGrade(75)