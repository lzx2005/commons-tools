package com.lzx2005.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parsii.eval.*;
import parsii.tokenizer.ParseException;

import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

/**
 * 公式计算器（基于parsii组件）
 * 目前支持+、-、*、/、sum、count、avg、log、min、max、ceil(向上取整)、
 * floor(向下取整)、round(四舍五入取整)、random（随机数）、^(幂运算)、
 * ( )（小括号）、[ ]（中括号）等英文运算符,百分比请转换成小数。
 * Created by hzlizx on 2018/11/12
 */
public class MathExpressionCalculator {
    private static final Logger logger = LoggerFactory.getLogger(MathExpressionCalculator.class);

    static {
        Parser.registerFunction("count", new Count());      // 计算总量 count(1,3,4) = 3
        Parser.registerFunction("sum", new Sum());          // 计算和 sum(2,3,4) = 9
        Parser.registerFunction("avg", new Avg());          // 计算平均数 avg(1,2,3) = 2
        Parser.registerFunction("random", new Random());    // 获得随机数 random(x) = y
    }

    /**
     * 公式计算
     *
     * @param expression         表达式，例如：x+y
     * @param variablesAndValues 变量和值，例如：{x:1.0, y:2.0}，以Map格式传入
     * @return 计算后的值
     * @throws ParseException 公式渲染错误
     */
    public static Double evaluate(String expression, HashMap<String, Double> variablesAndValues) throws ParseException {
        Scope scope = Scope.create();
        Expression exp = Parser.parse(expression, scope);
        variablesAndValues.forEach((key, value) -> {
            Variable variable = scope.getVariable(key);
            variable.setValue(value);
        });
        double evaluate = exp.evaluate();
        logger.info("计算公式：{} = {}", expression, evaluate);
        return evaluate;
    }

    /**
     * 自定义一个函数
     *
     * @param name     函数名称
     * @param function 函数实现
     */
    public static void registerFunction(String name, Function function) {
        Parser.registerFunction(name, function);
    }

    /**
     * 多参数函数定义
     */
    private static abstract class MultipleVariablesFunction implements Function {
        @Override
        public int getNumberOfArguments() {
            return -1;
        }

        @Override
        public boolean isNaturalFunction() {
            return true;
        }
    }


    /**
     * 计算参数一共有多少个
     */
    private static class Count extends MultipleVariablesFunction {
        @Override
        public double eval(List<Expression> list) {
            return list.size();
        }
    }

    /**
     * 计算总数
     */
    private static class Sum extends MultipleVariablesFunction {
        @Override
        public double eval(List<Expression> list) {
            return list.stream().mapToDouble(Expression::evaluate).sum();
        }
    }

    /**
     * 计算平均数
     */
    private static class Avg extends MultipleVariablesFunction {
        @Override
        public double eval(List<Expression> list) {
            OptionalDouble average = list.stream().mapToDouble(Expression::evaluate).average();
            if (average.isPresent()) {
                return average.getAsDouble();
            } else {
                return 0.0;
            }
        }
    }

    /**
     * 获得随机数
     */
    private static class Random extends UnaryFunction {
        @Override
        protected double eval(double a) {
            return Math.random() * a;
        }
    }

}
