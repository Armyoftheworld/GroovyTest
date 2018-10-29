package com.army.groovy

def file = new File("../../../../GroovyTest.iml")
/**
 * 获取文件的内容
 */
//file.eachLine {
//    println(it)
//}

//println file.getText()
//每一行内容的集合
//def lines = file.readLines()
//println(lines)

//读取文件部分内容
//println file.withReader { reader ->
//    char[] buffer = new char[100]
//    reader.read(buffer)
//    return buffer
//}

//copy("../../../../GroovyTest.iml", "../../../../GroovyTest2.iml")

/**
 * 复制文件
 */
void copy(String sourcePath, String destPath) {
    def sourceFile = new File(sourcePath)
    if (!sourceFile.exists()) {
        return
    }
    def destFile = new File(destPath)
    if (!destFile.exists()) {
        destFile.createNewFile()
    }
    //写法一：
    sourceFile.withReader { reader ->
        def lines = reader.readLines()
        destFile.withWriter { writer ->
            lines.each {
                writer.append("$it\n")
            }
        }
    }
    //写法二：
//    destFile.write(sourceFile.text)
}

/**
 * 把对象写入文件
 */
void saveObject(Object obj, String destPath) {
    def destFile = new File(destPath)
    if (!destFile.exists()) {
        destFile.createNewFile()
    }
    destFile.withObjectOutputStream {
        os -> os.writeObject(obj)
    }
}

/**
 * 从文件读取对象
 */
def readObject(String sourcePath) {
    def obj
    def sourceFile = new File(sourcePath)
    if (!sourceFile.exists()) {
        return null
    }
    sourceFile.withObjectInputStream {
        is -> obj = is.readObject()
    }
    return obj
}

//saveObject(new PersonBean(name: "Army", age: 18), "../../../../PersonBean.bin")
println readObject("../../../../PersonBean.bin")












