# Git常用命令
## 什么是Git
> Git是一个版本控制软件。在进行软件开发时，一个团队的人靠使用Git，就能轻松管理好项目版本，做好项目的追踪和辅助进度控制。确切的讲，Git是一款分布式版本控制系统。这个“分布式”，要和“集中式”放在一起理解。

## Git常用指令列举
- git init 初始化git项目
- git pull 拉取分支内容
- git push 推送内容到分支
- git commit 提交内容到本地分支
- git merge 合并分支
- git add 添加未进入git中的文件
- git checkout 切换分支
- git fetch 获取远程分支的变更
- git clone 下载远程git
- git config 获取配置
- git status 显示有变更的文件
- git log 显示当前分支变更的
- git reset 撤销回退版本

## 远程仓库-本地仓库-暂存区-工作区三者关系图
![远程仓库-本地仓库-暂存区-工作区三者关系图](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/git-1-relation.png)

### 详细指令介绍
- 代码库相关操作
    ``` 
    1. git init [project-name] 初始化一个git项  目，一般用于项目初始化操作
    2. git clone [url] 下载远程git,把远程项目下载到本地中
    ```
- git 配置操作
    ```
    1. git config --list 显示当前git配置
    2. git config -e [-- globa] 编辑[当前/全局]配置文件
    3. git config [--global] user.name "[name]" 设置提交代码时的用户信息，对应git上传的账号信息，同理邮件信息也可以这样编辑
    ```

    ```
  git的配置文件优先级:
    项目仓库配置的优先级高于系统默认配置文件
    项目仓库配置的配置会覆盖系统默认配置文件的配置
  ```
- 增加/删除暂存区中文件
    ```
    1. git add [file1 ...]  添加指定文件到暂存区中
    2. git add [dir]  添加文件夹到暂存区
    3. git add . 将当前目录下所有文件放到暂存区中
    4. git rm [file1 ...] 删除工作区文件，
    ```
- 代码提交/拉取
    ```
    1. git commit -m [message] 提交暂存区到仓库区
    2. git commit [file1 ...] -m [message] 指定文件提交暂存区到仓库区
    3. git pull [remote] [branch] 拉取远程仓库的变化，并合并本地分支
    4. git push [remote] [branch] 上传本地指定分支到远程仓库
    5. git push [remote] --all 推送所有分支到远程仓库
    6. git push [remote] --force 强制忽视冲突，上传到远程分支（不推荐，除非特殊情况)
    ```
- 状态/信息查看
    ```
    1. git status 显示变更的文件
    2. git log 查看当前分支的历史版本信息
    ```
- 分支操作
    ```
    1. git fetch [remote]  获取远程仓库的变更
    2. git checkout [branch] 切换分支
    3. git checkout [commit] [file] 恢复某个commit的指定文件到暂存区
    4. git reset --hard 回退分支到上一个commit记录
    5. git stash 未提交的变化暂存移除，
    6. git stash pop 暂存未提交的变化移入
    ```

综上：常见的指令列举了部分，虽然不是完整的，如果需要查看可以用git --help查看完整的信息。

### Git使用问题以及解决方法
#### 问题1：如果提交本地项目到Github/其他远程仓库?
> 首先进入GitHub,创建一个远程仓库 **如果已有忽略下步**
>
> ![创建远程仓库](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/git-2-create-responstory.png)
>
>然后获取对应的url
>
>![获取url](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/git-3-get-url.png)
>
>进入本地项目目录,并初始化
>
>![初始化](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/git-4-into-project.png)
>关联远程仓库
>
>![g关联远程仓库](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/git-5-git-related.png)
>拉取远程代码
>![pull代码](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/git-6-git-pull.png)
>上传代码
>![push代码](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/git-7-git-push.png)
>
>**ps:在pull哪一步有时候会出现一个错误：refusing to merge unrelated histories git pull 这个错误只要在git pull命令加一个 --allow-unrelated-histories 就可以了完整的命令：git pull --allow-unrelated-histories**