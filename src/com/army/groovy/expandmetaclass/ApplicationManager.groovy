package com.army.groovy.expandmetaclass

import com.army.groovy.People

class ApplicationManager {
    static void init() {
        //调用此方法，是为了让下面的为类添加静态方法对所有的调用处生效
        //否则动态添加的方法只对当前脚本生效
        ExpandoMetaClass.enableGlobally()
        People.metaClass.static.createPeople = { name, age -> new People(name: name, age: age) }
    }
}
