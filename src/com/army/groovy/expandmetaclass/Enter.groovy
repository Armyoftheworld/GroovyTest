package com.army.groovy.expandmetaclass

//入口类
class Enter {
    static void main(String[] args) {
        println('应用程序正在启动...')
        ApplicationManager.init()
        println('应用程序初始化成功')
        def people = PeopleManager.createPeople("amy", 20)
        println(people)
    }
}
