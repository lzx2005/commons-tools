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
- com.lzx2005.common.CommonUtils : 快速调用包，包括调换数组中的数字等

#### 字符串相关
- com.lzx2005.string.StringUtilsExt : 多字符串判断空

#### 常用枚举
- com.lzx2005.constants.BrowserType : User-Agent中浏览器对应的中文名枚举

#### 数字数学相关
- com.lzx2005.math.ConvertRadix : 10位数字与N位数字互相转换工具
- com.lzx2005.math.MathExpressionCalculator : 根据字符串公式表达式计算值

#### 接口调用相关
- com.lzx2005.apicaller.TaobaoIpQueryer : 快速调用淘宝IP地理位置查询API