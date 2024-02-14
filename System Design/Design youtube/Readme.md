## Step1 Ask questions ! Gathering requirements/features, do calculation and estimation

### Functional Requirements

- 主要功能：上传和观看视频， log in/sign up, like
  - [ ] 哪些功能需要在SD里涉及
- system 数据： 视频 + metadata

- 考虑全球用户



### Non functional

- 使用行为： 观看：上传 = 90% ： 10%  - read heavy

- DAU：1million？ （b站DAU约100million）（永远从用户量开始）

  计算qps：10^6 * 10（每天10个request）/86400 * 3（高峰） =  350

  上传数据量：每天100k用户上传视频，每个100M = 10T/d

  - [ ] 需要多大的数据库？

- - [ ] 延迟：看视频算不算latency？

- storage heavy

- 数据库选型

- repsonse time：尽量快一点能开始播放  < 1s

- reliability time：99.9%

- 移动端，网页端

- 需要auth，需要analytics（推荐算法），部署在aws上，推荐系统交给做data的公司

- 单个视频1G，存储时间5年为周期考虑，近的存s3，久的用glacier

  - [ ] 算一下五年一共有多少数据





## Step2 Create a high level abstract design - Design Goals (high-level trade-offs: Keep in mind that everything is a trade-off.)

- Performance vs. **Scalability**

- Latency(流的速度) vs. Throughput(水管流量)  需要trade off

- Consistency： Eventual

  - [ ] Availbility：

  - [ ] Availability vs Consistency (DBs)

![image-20240212145417072](C:\Users\Hanyun\OneDrive\桌面\chuwa java batch\assignments\chuwa1206\System Design\Design youtube\typora_images\Readme\image-20240212145417072.png)



## Step3 Design Core components

重要功能：首先考虑前两点（怎么存，怎么发）

- （最重要）格式处理，分片上传并保证顺序（重要），处理上传中断和继续

- transcode service然后存到cdn和s3里，把uri等视频的metadata存数据库（关系型）

  - 近的久的
  - 主从数据库

  

- 用户查询视频，这步涉及cache（优化1），考虑还有没有别的优化

- 更新视频时怎么只更新部分分片

- [ ] 要不要设计api

## Step4 Scale the design → find bottleneck(s)

移动端，网页端

全球用户

10million用户





## 其他 

画图







我的部分：

In the deep design, I'll first introduce how we upload video with proper machanism.

When user upload the videos, it is not garanteed that all of them can be smoothly played on other devices. Also, raw videos can be heavy load for our storage. In addition, audiences with higher bandwidth would possibly expect higher resolution when watching video, while lower bandwidth user would not. Last but quite importantly, uploading can be interrupted due to many uncertainties. Therefore, for the reasoning above, it's necessary to design a mechanism that support uploading with multiple format, efficient storage, flexible resolution, and breakpoint resume.

Our solution is, on client side, we split the videos into small chunks, usually several seconds length each. For each chunk we transcode it into a unified format that is supported by Youtube player, and friendly to our storage. Also we generate the metadata for each chunk, including chunk index, chunk size, chunk status and so on. The metadata would garantee each chunk are uploaded successfully and can be merged in correct order. If users' local device is not capable of transcoding, we also provides online transcoding server. Of course the uploading can be done in parallel, the chunks finishing encoding will be pushed into a message queue, and the uploader consumes this queue to upload them. The server  gathers all uploaded chunks from another message queue. Finally, when all chunks from one video is uploaded, it merge them and store it in CDN according to geological locations, and the metadata of the whole video like uri is put into our metadata DB. 

(Most popular videos can be stored in CDNs, while other videos may have less replicas, or stored in cheaper storages.)

看视频的时候用streaming flow

![image-20240213151240077](C:\Users\Hanyun\OneDrive\桌面\chuwa java batch\assignments\chuwa1206\System Design\Design youtube\typora_images\Readme\image-20240213151240077.png)







Improvements:

注意watch包含了searching，commenting等

1M DAU有点小？

DB table设计

blob通常不shard

面试的时候问下面试官，step1设计这样的数值是否合理