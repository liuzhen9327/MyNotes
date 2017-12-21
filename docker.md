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