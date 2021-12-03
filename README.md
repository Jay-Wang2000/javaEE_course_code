# javaEE_course_code

javaee大作业最终代码，附history
11.4晚上：

​	完成了页面设计，配置了pom文件

11.5早上：

​	完成了工程结构的布置和要写的文件，完成了JavaBean及对应的repository

​	初步写了controller要写的网页函数声明，但并未实现

​	下一步计划完成注册部分的controller和jsp设计

11.5晚上：

​	修改了工程结构，service面向用户，只保留了一个普通用户和管理员的操作

​	进一步细化了controller的结构，一个controller的网页太多，看上去杂乱

​	配置了properties，初步了解html并写了一个jsp表单，

​	发现应该先从serveice开始写起，再写view，最后写controller，因为controller是view中按键功能的后端，

​	而且controller许多功能依赖service实现

​	逻辑：数据结构bean(对象)+repository(容器)-》可能的用户操作(service)-》view中的操作-》controller后端支持

​	完成了两个service，对autowire和自己new对象的差别不是很懂，

​	还需要进一步了解transactional注解的用途，为什么不涉及读写的功能就不需要该注解

先写的AccountService：

​	了解了crudrepository类的方法和返回类型，了解了optional类的用法，

​	以及repositrory的ID类型实际上对应对应bean中主键的类型，操作时用主键去找就行了

AdminService

​	使用时间作为主键来记录管理员的action，使用sdf+date生成

​	hibernate无法实现修改部分关系，修改书的数量采用了先删除原来的表项，再添加一个除时间之外与原来都相同的表项

计划在有了大致的思路后看一下老师是怎么做的，再作最后一次大的修改

11.11

​	终于调试好了ide，说下几个要点

​	1、学会看run和logcat的报错，通常可以直接解决问题，不会的复制粘贴到sf上问

​	2、文件夹的属性在project_structure中修改

​	3、pom配置不同的springboot版本也不一样没有写常用的就直接内置了，不用设置，设置了反而会出错，如mysql.driver就不用设置，如果和default冲突反而用不了

​	关于操作

​	1、在创建表时各选项要设定默认值，否则hiberate无法使用

​	2、jsp是html+servelet，jsp表单的跳转和el中的跳转方式不同，前者提交的数据不包含该jsp文件中request请求体的参数
​	
11.12

​	session.getAttribute的返回值类型是Object，Attribute的意思是属性，特质 说明session中几乎可以存任何类型

  而request.getParameter的返回值类型是String，Paramter的字面意思是参数，变量，说明request中只能存字符串

