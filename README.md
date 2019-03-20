# commons-tools

本项目是我在平时的工作开发中积累的常用方法，类，功能，整合出来的一个综合项目。
你可以把这个项目当做是一个工具包。

开发此包的目的是为了避免我在不同的项目中重复写已经写过的业务代码，加快开发速度。

本项目尽量避免重复造轮子，同时也会整合部分轮子为我所用，简化使用。


## todos

- [X] 常用Service层返回类，构造方法，Builder类，Register方法。

- [ ] 文件读取工具包

- [ ] 数字计算包

- [ ] 排序包

## features

目前已完成的功能如下：

#### 常规功能包
- CommonUtils : 快速调用包，包括调换数组中的数字等

#### 字符串相关
- StringUtilsExt : 多字符串判断空

```java
import io.github.lzx2005.string.StringUtilsExt;

boolean hasEmpty = StringUtilsExt.hasEmpty("a","","c");
System.out.println(hasEmpty);

--> true
```

#### 常用枚举
- BrowserType : User-Agent中浏览器对应的中文名枚举

```java
import io.github.lzx2005.constants.BrowserType;

BrowserType browserType = BrowserType.valueOf("Chrome");
System.out.println(browserType.getName());

--> 谷歌浏览器
```


- ChinaIdCardPrefixMap : 中国身份证开头与城市对应表

```java
import io.github.lzx2005.constants.ChinaIdCardPrefixMap;

String city = ChinaIdCardPrefixMap.getProvinceCityByCode("310000");
System.out.println(city);

--> 上海市
```

#### 数字数学相关
- ConvertRadix : 10位数字与N位数字互相转换工具
- MathExpressionCalculator : 根据字符串公式表达式计算值 


```java
import io.github.lzx2005.math.MathExpressionCalculator;

String exp = "a^b";
HashMap<String, Double> map = new HashMap<>();
map.put("a", 2.0);
map.put("b", 10.0);
Double evaluate = MathExpressionCalculator.evaluate(exp, map);
System.out.println(exp + " = " + evaluate);

--> a^b = 1024.0
```
[MathExpressionCalculator完整使用文档](https://github.com/lzx2005/commons-tools/blob/master/docs/MathExpressionCalculator.md)

#### 接口调用相关
- TaobaoIpQueryer : 快速调用淘宝IP地理位置查询API