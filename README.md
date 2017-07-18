### README

为了提高工作效率在通过mybatis-generator插件生成实体类时就自动生成swagger需要的注解信息，修改了org.mybatis.generator.core-1.3.5的源码。

主要修改内容如下：
1、屏蔽mybatis-generator生成的实体类中默认的注释；
2、添加swagger API文档需要的字段注释；
3、添加接收日期参数和将返回日期数据格式化所需的注释；