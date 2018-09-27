模拟一个servlet的整个过程

1.server
2.request 客户端请求header 一般包括 method url param

Get类型 get 的参数在url后面 post参数在末尾

GET /?uname=%E6%9B%B9%E5%98%89%E7%90%A6 HTTP/1.1
Host: localhost:8889
Connection: keep-alive
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cookie: Idea-42982236=944aa7c8-14c9-47b1-8728-1070d53b906f

3.response 服务端返回的报文 包含header 和 body

HTTP/1.1 200 OK
Content-Type: text/html; charset=utf-8
Content-Length: 113

html代码

4.Dispatcher
该类用于分发请求 不同的url分发到不同的 servlet