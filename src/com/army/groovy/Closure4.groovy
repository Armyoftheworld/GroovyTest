package com.army.groovy
//闭包的三个重要变量：this，owner，delegate

def closure = {
    //this代表闭包定义处的类
    println "this = " + this
    //owner代表闭包定义处的类或者对象
    println "owner = " + owner
    //delegate代表任意对象，默认与owner一样
    println "delegate = " + delegate
}
closure.call()

//查看静态方法和静态变量的三个变量的值
class StaticPerson {

    def static closure = {
        println "this = " + this
        println "owner = " + owner
        println "delegate = " + delegate
    }

    def static say() {
        def closure2 = {
            println "this = " + this
            println "owner = " + owner
            println "delegate = " + delegate
        }
        closure2.call()
    }
}
//指向的是类的字节码
//StaticPerson.closure.call()
//StaticPerson.say()

//查看普通方法和普通变量的三个变量的值
class Person {

    def closure = {
        println "this = " + this
        println "owner = " + owner
        println "delegate = " + delegate
    }

    def say() {
        def closure2 = {
            println "say this = " + this
            println "say owner = " + owner
            println "say delegate = " + delegate
        }
        closure2.call()
    }

    def testClosure(groovy.lang.Closure closure1) {
        //修改delegate为当前Person对象
        closure1.delegate = this
        closure1.call()
    }
}
//指向的是类的对象
def person = new Person()
//person.closure.call()
//person.say()
person.testClosure {
    println "testClosure this = " + this
    println "testClosure owner = " + owner
    println "testClosure delegate = " + delegate
    //因为修改了delegate为Person对象，所以可以调用Person的方法
    say()
}

//闭包中定义闭包
def nestClosure = {
    def innerClosure = {
        //指向Closure4这个类的对象
        println "this = " + this
        //指向nestClosure这个闭包对象
        println "owner = " + owner
        //指向person对象
        println "delegate = " + delegate
    }
    //手动修改delegate
    innerClosure.delegate = person
    innerClosure.call()
}
nestClosure.call()

/**
 * 闭包的委托策略
 */
class Student {
    String name

    def desc = {"my name is $name"}

    @Override
    String toString() {
        return desc.call()
    }
}

class Teacher {
    String name
}

def student = new Student(name: "student")
def tea = new Teacher(name: "teacher")
student.desc.delegate = tea
student.desc.resolveStrategy = groovy.lang.Closure.DELEGATE_FIRST
println student.toString()

