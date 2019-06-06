### 查看端口占用情况
rsync -av dir targetdir
```

netstat -anp|grep 8080
yum install net-tools

```

### telnet安装

```
yum -y install xinetd telnet telnet-server
```

### crontab 定时执行脚本

```
clear-docker-log.sh :
#!/bin/sh
truncate -s 0 /var/lib/docker/containers/*/*-json.log

crontab -u root -e
0 0 * * 0 /root/clear-docker-log.sh
```

### 防火墙

```
Failed to Setup IP tables: Unable to enable SKIP DNAT rule: iptables -t filter -N DOCKER
防火墙状态: firewall-cmd --state
systemctl stop firewalld.service
systemctl disable firewalld.service

firewall-cmd --zone=public --add-port=3306/tcp --permanent
firewall-cmd --reload
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



rpm -ivh http://nginx.org/packages/centos/7/noarch/RPMS/nginx-release-centos-7-0.el7.ngx.noarch.rpm

yum install -y nginx

service nginx start

```

### 安装service

```

yum install -y system-config-services

```

### 安装redis

```
6.5

http://www.cnblogs.com/haoxinyue/p/3620648.html

http://www.cnblogs.com/haoxinyue/p/3620648.html

开机自动启

http://www.tuicool.com/articles/aQbQ3u

7
yum install -y epel-release
yum install -y redis
vi /etc/redis.conf
找到下面这一行并注释
bind 127.0.0.1
service redis start  
chkconfig redis on
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

### docker安装sqlserver
```

sudo docker pull microsoft/mssql-server-linux:2017-latest

sudo docker run -e 'ACCEPT_EULA=Y' -e 'MSSQL_SA_PASSWORD=Tdcarefor123!@#' -p 1401:1433 -v /var/lib/docker/volumes/sqlserver:/var/opt/mssql --name sqlserver -d microsoft/mssql-server-linux:2017-latest
```
