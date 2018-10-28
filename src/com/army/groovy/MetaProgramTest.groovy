package com.army.groovy
/**
 * 元编程
 */
class People {
    String name
    int age

    /**
     * 一个方法找不到时，会调用他代替
     * @param name
     * @param args
     * @return
     */
    @Override
    def invokeMethod(String name, Object args) {
        return "the method is $name, the param is ${args}"
    }

    /**
     * 一个方法找不到时，会调用他代替，优先级高于invokeMethod
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name, def args) {
        return "the method($name) is missing"
    }


    @Override
    String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}

def people = new People(name: 'Army', age: 18)
println people.cry()

//为类动态的添加属性，为People的对象默认添加值为male的sex属性
People.metaClass.sex = 'male'
people = new People(name: 'Army', age: 18)
println("people.sex = ${people.sex}")
people.sex = 'female'
println("people.sex = ${people.sex}")

//为类动态的添加方法
People.metaClass.sexUpperCase = { -> sex.toUpperCase() }
people = new People(name: 'Army', age: 18)
println people.sexUpperCase()

////为类动态的添加静态方法
People.metaClass.static.createPeople = { name, age -> new People(name: name, age: age) }
people = People.createPeople('NewName', 18)
println(people)


