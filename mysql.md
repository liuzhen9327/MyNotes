### centos7安装
```

rpm -Uvh http://dev.mysql.com/get/mysql-community-release-el7-5.noarch.rpm

yum repolist enabled | grep "mysql.*-community.*"

yum -y install mysql-community-server

systemctl enable mysqld

systemctl start mysqld

mysql_secure_installation


```

### 创建用户

```
create user 'tdnis'@'%' identified by 'Tdcarefor123';

grant all privileges on *.* to 'tdnis'@'%' identified by 'Tdcarefor123';

flush privileges;

```