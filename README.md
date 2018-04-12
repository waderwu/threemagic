# threemagic

## 引诱下载安装模块
- 伪装成一个微信/qq自动回复的软件、自动抢红包、并且提供详细的教程指导安装（主要是为了让受害者开启相应的权限)
- 主要通过android的辅助功能来实现

## 触发模块
- 可以在走完指导后，立即触发
- 收集一定的聊天信息后，远程触发
- 安装固定时间后触发

## 破坏模块
- 激活设备管理器，修改android6.0以下的锁屏密码，防止开机不自启动
- 允许出现在其他应用上面，就是个锁屏勒索病毒(和上面组合之后防止卸载)
- 加密文件

# TODO
- [ ] 增加抢红包功能(qq,和微信)
- [ ] 增加解析聊天记录并上传服务器的功能
- [ ] 增加远程触发的功能
- [ ] 增加文件加密的功能

能够获取的聊天记录类似这样
```
04-11 21:27:46.608 2081-2081/cn.sometimenaive.threemagic D/text: gg: 哈哈哈
04-11 21:27:46.608 2081-2081/cn.sometimenaive.threemagic D/end: ---------------
04-11 21:27:46.608 2081-2081/cn.sometimenaive.threemagic I/maptrix: sender name =gg
04-11 21:27:46.608 2081-2081/cn.sometimenaive.threemagic I/maptrix: sender content =哈哈哈
04-11 21:27:46.896 2081-2081/cn.sometimenaive.threemagic D/mylog: get envnet = 32
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.FrameLayout,null,14
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=向上导航
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,null,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.LinearLayout
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=ggTIM移动在线 - WiFi
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=0 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.LinearLayout,null,2
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,gg,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=TIM移动在线 - WiFi
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,TIM移动在线 - WiFi,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=聊天设置
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.view.ViewGroup
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.view.ViewGroup,null,8
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=我说正在忙,稍后回复你
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,正在忙,稍后回复你,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入我的资料卡
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=gg说ggggf
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=0 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入gg的资料卡
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=2 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,ggggf,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=我说正在忙,稍后回复你
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,正在忙,稍后回复你,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入我的资料卡
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=gg说你好啊
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=0 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入gg的资料卡
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=2 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,你好啊,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=我说正在忙,稍后回复你
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,正在忙,稍后回复你,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入我的资料卡
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=我说hao a
04-11 21:27:47.613 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,hao a ,0
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入我的资料卡
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=gg说很尴尬
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=0 cindex=-1
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入gg的资料卡
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=2 cindex=-1
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,很尴尬,0
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.RelativeLayout
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=gg说哈哈哈
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=0 cindex=3
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.RelativeLayout,null,2
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.ImageView
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=进入gg的资料卡
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=2 cindex=-1
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic I/mylog: find node info
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.ImageView,null,0
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.TextView
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=null
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: root class= android.widget.TextView,哈哈哈,0
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic D/mylog: class=android.widget.EditText
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: ds=文本框  连按两次来编辑
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic E/mylog: nindex=-1 cindex=-1
04-11 21:27:47.614 2081-2081/cn.sometimenaive.threemagic I/maptrix: ==================
```
