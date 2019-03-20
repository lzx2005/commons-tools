### 公式计算器

MathExpressionCalculator公式计算器

目前已经支持

- +、-、*、/
- sum
- count
- avg
- log
- min
- max
- ceil(向上取整)
- floor(向下取整)
- round(四舍五入取整)
- random（随机数）
- ^(幂运算)
- ( )（小括号）
- [ ]（中括号）

#### 使用方法

引入包
```java
import MathExpressionCalculator;
```

1. 幂运算

```java
String exp = "a^b";
HashMap<String, Double> map = new HashMap<>();
map.put("a", 2.0);
map.put("b", 10.0);
Double evaluate = MathExpressionCalculator.evaluate(exp, map);
System.out.println(exp + " = " + evaluate);

--> a^b = 1024.0
```

2. 平均数计算

```java
String exp = "avg(x,y,z)";
HashMap<String, Double> map = new HashMap<>();
map.put("x", 2.0);
map.put("y", 3.0);
map.put("z", 4.0);
Double evaluate = MathExpressionCalculator.evaluate(exp, map);
System.out.println(exp + " = " + evaluate);

--> avg(x,y,z) = 3.0
```

3. 获取随机数

```java
String exp = "random(a)";
HashMap<String, Double> map = new HashMap<>();
map.put("a", 10.0);
Double evaluate = MathExpressionCalculator.evaluate(exp, map);
System.out.println(exp + " = " + evaluate);

--> random(a) = 6.135870336392974
```

4. 复杂公式

实现了复杂公式嵌套调用

```java
String exp = "sum(1,2,x)+avg(sum(a,b),3)*4/2+5";
HashMap<String, Double> map = new HashMap<>();
map.put("a", 1.0);
map.put("b", 1.0);
map.put("x", 3.0);
Double evaluate = MathExpressionCalculator.evaluate(exp, map);
System.out.println(exp + " = " + evaluate);

--> sum(1,2,x)+avg(sum(a,b),3)*4/2+5 = 16.0
```



#### 自定义函数

可以指定自定义的函数计算，例如我们指定 abc(x,y) 为 x + y：

1. 首先我们实现Function接口

```java
Function abc = new Function() {
    @Override
    public int getNumberOfArguments() {
        return 2; // 这里指定需要的参数的个数，如果不限个数，则返回-1
    }

    @Override
    public double eval(List<Expression> args) {
        double x = args.get(0).evaluate(); // 获得第一个参数
        double y = args.get(1).evaluate(); // 获得第二个参数
        return x + y; // 计算
    }

    // 当相同的输入值一定返回相同的结果，则这个计算为Natural，反之不为Natural
    // 例如 sum(a,b)为Natural，random(x)不为Natural
    @Override
    public boolean isNaturalFunction() {
        return true;
    }
};
```

2. 将函数注册到类中，并调用即可

```java
MathExpressionCalculator.registerFunction("abc", abc);
MathExpressionCalculator.evaluate("abc(a,b)", map);
```

