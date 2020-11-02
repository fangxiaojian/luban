<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java 后端 WebSocket 的 Jetty 实现</title>
</head>
<body>
Welcome<br/>
<input id="text" type="text" />
<button onclick="send()" > 发送消息</button>
<hr/>
<button onclick="closeWebSocket()" > 关闭 webSocket 连接</button>
<hr/>
<div id="message"></div>
</body>

<script type="text/javascript">
    var websocket = null;
    // 判断当前浏览器是否支持 WebSocket
    if ('WebSocket' in window) {
        // conn server
        websocket = new WebSocket("ws://localhost:8080/simpleWebSocket");
    } else {
        alert('当前浏览器 No Support WebSocket');
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket 连接发生错误！")
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket 连接成功！")
    };

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    };

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket 连接关闭！");
    };

    // 监听窗口关闭事件，当窗口关闭时，主动去关闭 webSocket 连接，防止连接还没
    window.onbeforeunload = function () {
        closeWebSocket();
    };

    // 将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    // 关闭 WebSocket 连接
    function closeWebSocket() {
        websocket.close();
    }

    // 发送消息
    function send() {
        const message = document.getElementById('text').value;
        websocket.send(message);
    }
</script>
</html>
