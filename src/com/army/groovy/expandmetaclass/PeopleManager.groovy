package com.army.groovy.expandmetaclass

import com.army.groovy.People

class PeopleManager {

    static People createPeople(String name, int age) {
        return People.createPeople(name, age)
    }
}
