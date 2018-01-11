### java基础

```
foreach和for的区别(编译之后)

线程池如何调优
线程池的最大线程数目根据什么确定

有没有可能2个不相等的对象有相同的hashcode
HashMap原理. hash碰撞时怎么获取value

LinkedHashMap和treeMap的区别

java 浅拷贝,深拷贝


反射中Class.forName和ClassLoader区别
```

### jvm

```
类的实例化顺序

JVM内存分代
老年代 新生代分别是存什么的
新生代和老生代的内存回收策略

有哪几种主要的jvm参数

有哪些常用jvm调试工具

tomcat结构，类加载器流程


```

### 并发相关

```
ThreadLocal用过么，原理是什么，用的时候要注意什么

Synchronized和Lock的区别

concurrenthashmap具体实现及其原理，jdk8下的改版

并发环境下为什么使用ConcurrentHashMap

volatile 有什么用?

CountDownLatch 有什么用

concurrent包中使用过哪些类？使用在什么场景？为什么要使用？
```

### spring
```
Spring AOP与IOC的实现原理

为什么CGlib方式可以对接口的实现进行代理？

RMI与代理模式

spring的controller是单例还是多例，怎么保证并发的安全
```

### 分布式

```
Dubbo的底层实现原理和机制

消息中间件如何解决消息丢失问题

Dubbo的服务请求失败怎么处理 重连机制

用过哪些MQ，怎么用的，和其他mq比较有什么优缺点

MQ系统的数据如何保证不丢失

列举出你能想到的数据库分库分表策略；分库分表后，如何解决全表查询的问题。
```

### 数据库

```
MySQL InnoDB存储的文件结构

索引树是如何维护的？

mysql索引为什么使用B+树

数据库自增主键可能的问题

索引失效场景

MySQL里有2000w数据，redis中只存20w的数据，如何保证redis中的数据都是热点数据

如何限制1小时内每ip最多只能发送5次短信

redis的数据淘汰策略
```

### 其他

```
说说你知道的几种HTTP响应码

restful

如何从线上日志发现问题

线上bug处理流程

秒杀系统, 30分钟没付款就自动关闭交易
--创建订单的时候 创建一个 30 分钟后执行的异步任务 如果支付成功取消这个任务 如果没有支付 就会自动执行
--用 redis 被动过期，客户端查询订单就从 redis 里取判断，redis 里的 key 过期，就取消订单
--用户进行查询订单时，去触发

```