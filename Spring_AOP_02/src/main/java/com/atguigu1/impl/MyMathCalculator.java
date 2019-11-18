package com.atguigu1.impl;

import com.atguigu1.inter.Calculator;
import org.springframework.stereotype.Service;

@Service
public class MyMathCalculator{// implements Calculator
    public int add(int i,double j){
        return 0;
    }

    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
