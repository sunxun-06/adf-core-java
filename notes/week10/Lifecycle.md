# 1、Agent从main()到think()完整调用链

1. Main.java 的 main() 入口启动，解析命令行参数，创建 AgentLauncher 对象。

2. 执行 AgentLauncher.initConnector()，注册全部6种角色的Connector。

3. 调用 AgentLauncher.start()，启动 TCPComponentLauncher，每一个Connector开启独立线程，建立和仿真服务器TCP连接。

4. 连接服务器成功后，回调 Agent.postConnect()：完成WorldInfo、ScenarioInfo初始化，设置运行模式PRECOMPUTE / NON_PRECOMPUTE。

5. 服务器每一个tick下发感知数据，触发 processSense(KASense)。

6. processSense 更新世界信息，内部调用 think(time, changed, heard)。

7. think 第一tick：初始化通信模块、订阅消息频道；之后调用子类实现的抽象think()，执行业务逻辑；最后调用send()向服务器下发动作指令。

# 2、initConnector()注册的6种Connector与对应角色

1. FireBrigadeConnector：消防队，负责灭火

2. AmbulanceTeamConnector：救护车小队，救助、转运伤员平民

3. PoliceForceConnector：警察部队，清除道路障碍

4. FireStationConnector：消防站，消防队的指挥中心

5. AmbulanceCentreConnector：救护中心，救护车指挥中心

6. PoliceOfficeConnector：警察局，警察的指挥中心
   三类执行Agent：消防队、救护车、警察；三类中心指挥Agent：消防站、救护中心、警察局，合计6种。
#  3、postConnect() 和 think()，谁先调用？为什么？

postConnect()优先调用。
原因：
postConnect()是TCP连接刚建立完成的回调函数。连接成功之后，才会收到服务器tick感知数据包；只有收到sense数据包，才会进入processSense，进而调用think()。
postConnect做Agent全局初始化（世界信息、模式设置），必须在第一轮think执行之前完成，为think运行准备环境。

# 4、think()内部抛出异常会发生什么？


1. 用户写的think()抛出异常，会被捕获，打印异常堆栈日志。

2. 不会让整个Agent线程崩溃退出，本轮tick业务逻辑终止。

3. Agent继续存活，等待下一个仿真tick，下一轮依旧会正常调用think()继续运行。
   不会直接断开服务器连接，只是丢弃本次tick你写的业务逻辑，本轮不会发送动作指令。
   