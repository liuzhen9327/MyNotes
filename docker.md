### 删除停止的容器
```
alias dockercleanc='docker rm $(docker ps -a -q)'

dockercleanc
```