### 删除停止的容器
```
alias dockercleanc='docker rm $(docker ps -a -q)'

dockercleanc
```
### 删除所有镜像
```
docker rmi `docker images -q`
```

### 安装

```
sudo yum install -y yum-utils

sudo yum-config-manager \
    --add-repo \
    https://download.daocloud.io/docker/linux/centos/docker-ce.repo

yum install -y --setopt=obsoletes=0 \
  docker-ce-17.03.1.ce-1.el7.centos \
  docker-ce-selinux-17.03.1.ce-1.el7.centos

sudo systemctl enable docker

### 新建 /etc/docker/daemon.json 文件, 写入:
{
    "storage-driver":"devicemapper"
}

sudo systemctl start docker

```

### 安装完成后修改docker 172.17网段

```
systemctl stop docker

vi /etc/docker/daemon.json
添加:
{
  "bip": "99.99.99.1/16"
}

rm -rf /var/lib/docker/*

systemctl start docker

ip route 查看docker0路由 是否为: 99.99.0.0/16 dev docker0  proto kernel  scope link  src 99.99.99.1

```

### 部署应用时, 修改docker 172.18,19网段

```
编写yaml文件前, 先在宿主机执行: docker network create --driver=bridge --subnet=66.66.66.0/16 br0

然后在yaml的network中指定刚刚创建的network. 如下

version: '2'
services:
  pdadoctor:
    logging:
      driver: json-file
      options:
        max-file: '3'
        max-size: 100m
    image: daocloud.io/tdcare/tdnis_pda_doctor:2.0.0.20170830
    entrypoint: /setVersion.sh 2.0.0.2017080
    environment:
    - eureka.instance.hostname=pdadoctor
    networks:
    - demo-back-tier
networks:
  demo-back-tier:
    external:
          name: br0

应用创建完成后 查看docker容器ip:
[root@i-uy96hjjz ~]# docker ps
CONTAINER ID        IMAGE                                                COMMAND                  CREATED             STATUS              PORTS               NAMES
b24be87adc89        daocloud.io/tdcare/tdnis_pda_doctor:2.0.0.20170830   "/setVersion.sh 2...."   27 minutes ago      Up 27 minutes       80/tcp, 443/tcp     HENGYANG-NANHUA-FUER-YIYUAN-QingCloud1_pdadoctor_1
[root@i-uy96hjjz ~]# docker exec -it b24be87adc89 /bin/bash
root@b24be87adc89:/# ip addr
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host
       valid_lft forever preferred_lft forever
8: eth0@if9: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default
    link/ether 02:42:42:42:00:02 brd ff:ff:ff:ff:ff:ff
    inet 66.66.0.2/16 scope global eth0
       valid_lft forever preferred_lft forever
    inet6 fe80::42:42ff:fe42:2/64 scope link
       valid_lft forever preferred_lft forever
```

### 容器无法删除

```
grep id /proc/*/mountinfo
ps -p id -o comm=
```

### docker 安装mysql mongodb rabbitmq

```
docker run --name mysql -v /etc/my.cnf.d:/etc/mysql/conf.d -v /var/lib/docker/volume/_data/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=Tdcarefor123 -p 3306:3306 -d daocloud.io/mysql:5.6.38

more /etc/my.cnf.d/my.cnf 
# For advice on how to change settings please see
# http://dev.mysql.com/doc/refman/5.6/en/server-configuration-defaults.html

[mysqld]
#
# Remove leading # and set to the amount of RAM for the most important data
# cache in MySQL. Start at 70% of total RAM for dedicated server, else 10%.
# innodb_buffer_pool_size = 128M
#
# Remove leading # to turn on a very important data integrity option: logging
# changes to the binary log between backups.
# log_bin
#
# Remove leading # to set options mainly useful for reporting servers.
# The server defaults are faster for transactions and fast SELECTs.
# Adjust sizes as needed, experiment to find the optimal values.
# join_buffer_size = 128M
sort_buffer_size = 256M
innodb_buffer_pool_size=2G
# read_rnd_buffer_size = 2M

max_connections=1500
skip-name-resolve
slow-query_log=ON
slow_query_log_file=/var/lib/mysql/mysql-slow.log
long_query_time=5
datadir=/var/lib/mysql
socket=/var/lib/mysql/mysql.sock

# Disabling symbolic-links is recommended to prevent assorted security risks
symbolic-links=0

# Recommended in standard MySQL setup
sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES 

character-set-server = utf8    
collation-server = utf8_unicode_ci    
init_connect='SET NAMES utf8'    
skip-character-set-client-handshake = true

[mysqld_safe]
log-error=/var/lib/mysql/mysqld.log
pid-file=/var/run/mysqld/mysqld.pid

[client]  
default-character-set=utf8  
[mysql]  
default-character-set = utf8

docker run --name mongodb -v /var/lib/docker/volume/_data/mongo:/var/lib/mongodata -p 27017:27017 -d daocloud.io/mongo:3.5

docker run -d --hostname rabbitmq --name rabbitmq -p 5672:5672 -p 15672:15672 daocloud.io/rabbitmq:3-management

docker network connect networkName containerid

docker network inspect containerid
```
