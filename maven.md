﻿### 将jar做成pom

`mvn install:install-file  -DgroupId=taobao -DartifactId=sms -Dversion=1.0 -Dpackaging=jar -Dfile=/Users/admin/Downloads/sdk-java-2016-06-07/taobao-sdk-java-auto_1455552377940-20160607.jar`





### jar包发布到nexus

```

<id>thirdparty</id>

<username>admin</username>

<password>admin123</password>

</server>



mvn deploy:deploy-file -DgroupId=com.alibaba -DartifactId=alipay-sdk -Dversion=20170307171631 -Dpackaging=jar -Dfile=/Users/admin/Downloads/alipay-sdk-java20170307171631.jar -Durl=http://192.168.10.250:8081/nexus/content/repositories/thirdparty/ -DrepositoryId=thirdparty

```

