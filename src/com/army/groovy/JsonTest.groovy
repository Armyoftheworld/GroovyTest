package com.army.groovy

import com.google.gson.Gson
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def list = [
        new PersonBean(name: 'Army', age: 18),
        new PersonBean(name: 'John', age: 20)
]
def json = JsonOutput.toJson(list)
//println JsonOutput.prettyPrint(json)

def jsonSlurper = new JsonSlurper()
list = jsonSlurper.parseText(json) as ArrayList<PersonBean>
//println list

def gson = new Gson()
//println gson.toJson(list)

def response = getNetworkJson("https://api.github.com/users/JakeWharton")
println response.login


def getNetworkJson(String url) {
    def connect = new URL(url).openConnection()
    connect.setRequestMethod("GET")
    connect.connect()
    def text = connect.content.text
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(text)
}

