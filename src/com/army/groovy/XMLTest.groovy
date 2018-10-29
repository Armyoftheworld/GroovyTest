package com.army.groovy

import groovy.xml.MarkupBuilder

def xml = '''\
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent xsi:xmlns="http://www.w3.org/2001/XMLSchema-instance">
    <groupId id="123">com.google.code.gson</groupId>
    <artifactId>gson-parent</artifactId>
    <version>2.8.2</version>
  </parent>
  <xsi:child name="Army" age="18"></xsi:child>
  <artifactId>gson</artifactId>
  <name>Gson</name>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <configuration>
          <includePackageNames>com.google.gson</includePackageNames>
          <excludePackageNames>com.google.gson.internal:com.google.gson.internal.bind</excludePackageNames>
          <links>
            <link>http://docs.oracle.com/javase/6/docs/api/</link>
          </links>
        </configuration>
      </plugin>
      <plugin>
        <groupId>biz.aQute.bnd</groupId>
        <artifactId>bnd-maven-plugin</artifactId>
        <version>3.1.0</version>
        <executions>
          <execution>
            <goals>
              <goal>bnd-process</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</project>
'''

def xmlSlurper = new XmlSlurper()
def project = xmlSlurper.parseText(xml)
//project的属性不知道怎么取
println project.parent.@"xsi:xmlns"
//取节点的值
println project.parent.groupId.text()
//取节点的属性
println project.parent.groupId.@id
//取命名空间声明的节点的属性
println project.child.@name
//遍历节点，
project.build.plugins.plugin.each {
    plugin -> println "groupId = ${plugin.groupId}, artifactId = ${plugin.artifactId}"
}
//这个深度遍历的结果返回的是符合条件的节点的所有子节点的值，个人认为适用于根据节点的属性来找符合条件的节点的例子
//闭包里面声明的是plugin，结果返回的也都是plugin节点
//depthFirst()可以用'**'代替
println project.depthFirst().findAll {
    plugin -> plugin.groupId.text().contains("apache")
}

//广度遍历，用children()，可以用'*'替代
println project.build.plugins.children().findAll {
    node -> node.name() == 'plugin'
}.collect {
    node -> node.groupId.text()
}

/**
 * 生成xml字符串
 <langs type='current' count='3' mainstream='true'>
 <language flavor='static' version='1.8'>Java</language>
 <language flavor='dynamic' version='1.6'>Groovy</language>
 <language flavor='dynamic' version='1.9'>JavaScript</language>
 </langs>
 */
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw)
xmlBuilder.langs(type: "current", count: "3", mainstream: "true") {
    language(flavor: "static", version: "1.8", "Java")
    language(flavor: "dynamic", version: "1.6", "Groovy")
    language(flavor: "dynamic", version: "1.9", "JavaScript")
}

def langs = new Langs()
xmlBuilder.langs(type: langs.type, count: langs.count, mainstream: langs.mainstream) {
    langs.languages.each {
        lang -> languages(flavor: lang.flavor, version: lang.version, lang.value)
    }
}
println sw

class Langs {
    String type = "current"
    int count = 3
    boolean mainstream = true
    def languages = [
            new Language(flavor: "static", version: "1.8", value: "Java"),
            new Language(flavor: "dynamic", version: "1.6", value: "Groovy"),
            new Language(flavor: "dynamic", version: "1.9", value: "JavaScript")
    ]
}

class Language {
    String flavor
    String version
    String value
}



