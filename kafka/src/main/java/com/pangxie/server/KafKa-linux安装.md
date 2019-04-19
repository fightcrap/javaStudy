# kafka安装-linux

1. 下载kafka

    在Apache Kafka官网中有很多版本的Kafka可以自己选择一个 下载地址为:http://kafka.apache.org/downloads.html

    这边选择是目前最新版本2.2.0
    ```
    wget 'https://www-eu.apache.org/dist/kafka/2.2.0/kafka-2.2.0-src.tgz '
    ```
2. 解压

    安装包下载完成后，解压安装包
    ```
    tar -zxvf kafka-2.2.0-src.tgz
    ```
3. 启动

    解压完后可以看到kafka文件的目录

    ![kafka文件目录](https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D220/sign=571122a7b07eca8016053ee5a1229712/8d5494eef01f3a29c8f5514a9925bc315c607c71.jpg)
    
    其中bin是命令集所在的文件，config是基本的一些配置，log是我自己配置的。。。不用管

    KafKa启动需要依赖zookeeper的，所以启动前需要先启动zookeeper。KafKa自带了zookeeper，可以直接基于Kafka命令启动，一般来说，不太建议用自带的，毕竟都是在一起的，要宕机就一起啦～但是对于单机应用那就没关系了。
    使用自带的zookeeper。(当然需要安装自己的要求编辑zookeeper的配置文件咯，config文件夹中已经给了一份简单的配置)
    ```
    bin/zookeeper-server-start.sh config/zookeeper.properties & 
    ```

    执行Kafka启动命令（同样要自己去配置Kafka配置文件)
    ```
    bin/kafka-server-start.sh config/server.properties & 
    ```
    这边对配置文件就不细讲了，因为太多了，推荐一篇配置文件的博客哈[KafKa配置](https://my.oschina.net/remainsu/blog/1557023)

    到处位置如果没有报错那就说明启动成功了
4. 测试KafKa

    启动起来后就可以用控制台来进行测试了，首先当然是要创建Topic了(zookeeper的默认端口是2181，这边用了自带的就是localhsot了。如果是其他机器的就要修改啦)
    ```
    bin/kafka-topics.sh --list --zookeeper localhost:2181
    ```

    启动生产者
    ```
    bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
    ```

    新开一个窗口,启动消费者
    ```
    bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --from-beginning --topic test
    ```

    然后在生产者发送消息，消费者这边就能看到啦，所以KafKa没有问题哦，这边就结束了，可以开心的使用了

5. 问题复盘

    在安装过程中遇到三个问题：
    1. 启动Kafka的时候报错：
    ```
    ERROR Error while electing or becoming leader on broker 0 (kafka.server.ZookeeperLeaderElector)
    java.net.ConnectException: Connection timed out
    ```
    这个时候说明zookeeper没有连上需要查看zookeeper是不是启动了，server.properties中的zookeeper.connect是否配置错误

    2. 启动消费者版本问题
    在Kafka 0.90版本的时候把--zookeeper指令换了，在学习的时候查到的命令还是老的，着实被坑了不少。0.90版本后被更换为了--bootstrap-server。而且两者含义不一样。--zookeeper是指向zookeeper的，--bootstrap-server是指向broker的。也就是一个指向zookeeper，一个指向了kafka。
    3. KafKa启动一会后自动关闭了。
    这个问题主要是在于启动KafKa的时候没有用守护线程,把启动命令变成如下，就好了
    ```
    ./kafka-server-start.sh  -daemon  config/server.properties  &
    ```




