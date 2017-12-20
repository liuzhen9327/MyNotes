### 查看端口占用情况

```

netstat -anp|grep 8080

```

### 文件夹赋权给用户

```

chown -R dev:dev /dir

chmod 775 /dir

chmod 777 /dir

7 拥有者有 读取，写入，执行权限
7 组用户有 读取，写入，执行权限
5 其他用户有 读取，执行权限(4+1 = 5)

777 与 775的区别是
其他用户有写入权限，而775的没有。

```

### sh可执行权限

```

chmod 777 xxx.sh

```

### 卸载openjdk

```

rpm -qa | grep java

rpm -e --nodeps java-1.4.2-gcj-compat-1.4.2.0-40jpp.115
rpm -e --nodeps java-1.6.0-openjdk-1.6.0.0-1.7.b09.el5

```

### 安装JDK

```

wget --no-check-certificate --no-cookie --header "Cookie: oraclelicense=accept-securebackup-cookie;" http://download.oracle.com/otn-pub/java/jdk/8u45-b14/jdk-8u45-linux-x64.rpm



rpm -ivh jdk

```

### tomcat

```

wget http://apache.fayea.com/tomcat/tomcat-8/v8.5.5/bin/apache-tomcat-8.5.5.tar.gz

```

### 安装nginx

```

rpm -ivh http://nginx.org/packages/centos/6/noarch/RPMS/nginx-release-centos-6-0.el6.ngx.noarch.rpm



http://nginx.org/packages/centos/7/noarch/RPMS/nginx-release-centos-7-0.el7.ngx.noarch.rpm

yum install -y nginx

service nginx start

```

### 安装service

```

yum install -y system-config-services

```

### 安装redis

```

http://www.cnblogs.com/haoxinyue/p/3620648.html

http://www.cnblogs.com/haoxinyue/p/3620648.html

开机自动启

http://www.tuicool.com/articles/aQbQ3u

```

### 清空redis所有key

```

redis-cli -a ! keys "*" | xargs redis-cli -a ! del

```

### 开启端口给外网

```

http://chwshuang.iteye.com/blog/1881391

```

### FTP搭建

```

https://segmentfault.com/a/1190000002926477

```