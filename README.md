# api_examples

## 目的
调用倍罗(BelloAI)简历解析服务代码示例

### Python
1.  代码位置: /python/test\_resume_parse.py
2. 编辑上述代码, 分别填入:
	- 解析服务调用接口地址
	- 倍罗客服提供的 X-API-KEY
	- 待解析的简历文件路径
3. 运行: $ python3 test\_resume_parse.py

注: Python3均可, 推荐Python3.6+

### Java
1. Maven项目, 位置: /java/api-test/
2. 将上述项目(api-test)以Maven项目形式导入IDE, 比如Eclipse;
3. 在代码 src/main/java/demo/ResumeParsePost.java 中分别填入:
	- 解析服务调用接口地址
	- 倍罗客服提供的 X-API-KEY
	- 待解析的简历文件路径(可选)
4. 编译项目并运行(JavaApplication), 运行时也可将待解析简历文件路径以参数传入(可选).

注: Java8+均可
