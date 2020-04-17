package cn.diana.algorithm

import java.io.{BufferedReader, InputStreamReader}
import java.nio.charset.StandardCharsets

object ScalaCallPythonDemo {

  def main(args: Array[String]): Unit = {
    val arguments = Array[String]("/usr/bin/python3", "src/main/python/ScalaCallPythonDemo.py", "6", "10")
    try {
      val process = Runtime.getRuntime.exec(arguments)
      val bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream, StandardCharsets.UTF_8))
      var line = ""
      var flag:Boolean= true
      while (flag){
        line = bufferReader.readLine()
        //Scala在读取文件时，如果读到最后会返回一个null值，因此，此时我们将标志位改为false，以便下一次结束while循环
        if (line == null){
          flag = false
        }else{
          println(line)
        }
      }
      bufferReader.close()
      val res = process.waitFor
      System.out.println(res)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

}
