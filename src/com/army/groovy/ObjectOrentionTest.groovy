package com.army.groovy
//面向对象
//默认都是public
class PersonBean implements Action, DefaultAction, Serializable {
    String name
    int age

    //def相当于object类型
    def increaseAge(int years) {
        age += years
    }

    @Override
    String toString() {
        return "PersonBean{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}'
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }

    @Override
    void watch() {

    }
}

def person = new PersonBean(name: 'Army', age: 18)
//用.调用属性，最后还是调用get/set方法，自动生成的
println(person.age)
println(person)

/**
 * 接口中不允许定义非public的方法
 */
interface Action {
    void eat()

    void drink()

    void play()
}

/**
 * trait定义的类型，既类似于接口，又类似于抽象类
 * 继承的话用implements
 * 可以有抽象方法，用abstract修饰，也可以有具体的方法体
 */
trait DefaultAction {
    abstract void watch()

    void listen() {
        println('listen')
    }
}