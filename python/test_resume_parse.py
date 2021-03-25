# coding: utf-8

## python3.6+

import os, sys
import requests
import base64

# 倍罗SAAS简历解析服务地址, 具体请咨询倍罗技术支持团队
parser_url = '<resume parse URL>'
# 倍罗SAAS服务账号权限相关, 具体请咨询倍罗技术支持团队
x_api_key = '<your api key>'

file_path = '</path/to/your/resume.pdf>'
# 准备解析请求的content参数, str类型
with open(file_path, 'rb') as f:
    f_content = f.read()
b64_content = base64.b64encode(f_content).decode('utf-8')

# 准备解析请求的filename参数, str类型, 注意需带有正确的文件后缀
file_name = os.path.basename(file_path)

# body的数据类型: 'application/json'
headers = {
    'content-type': 'application/json',
    'X-API-KEY': x_api_key
}

params = {
    'filename': file_name,
    'content': b64_content,
    # 返回接口带有meta{}部分; 建议设为True, 使得倍罗SAAS简历解析各个接口返回结果结构保持一致.
    'need_meta': True
}

res = requests.post(
    parser_url,
    json=params,
    headers=headers
)

if res.status_code == 200:
    json = res.json()
    print(json)
else:
    print(res)
