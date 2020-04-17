package cn.diana.algorithm;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.io.*;

public class JpythonDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("src/main/python/JavaCallPythonAdd.py");
        PyFunction func = (PyFunction)interpreter.get("sum",PyFunction.class);
        int a = 10;
        int b = 10;
        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("sum = " + pyobj.toString());
    }
}
