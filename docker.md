### 删除停止的容器
```
alias dockercleanc='docker rm $(docker ps -a -q)'

dockercleanc
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

sudo systemctl start docker

docker info |grep d_type
```


docker stop a761111daee5
docker stop 486d8e019e01
docker stop 0ea5b2994999
docker stop ea5bc123409a
docker stop b88cdc1e3dd1
docker stop 0a0a4f03119a
docker stop 497ac338c01b
docker stop 479bd971b728
docker stop 1aab6886e51c
docker stop e7cb0938ee0b




docker start a761111daee5
docker start 486d8e019e01
docker start 0ea5b2994999
docker start ea5bc123409a
docker start b88cdc1e3dd1
docker start 0a0a4f03119a
docker start 497ac338c01b
docker start 479bd971b728
docker start 1aab6886e51c
docker start e7cb0938ee0b