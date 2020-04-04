<%--
  Created by IntelliJ IDEA.
  User: 孙硕威
  Date: 2020/4/3
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function () {
    $.ajax({
        url:'show',
        type:'post',
        success:function (result) {
            if(result =="noLogin"){
                alert('错误')
                return;
            }
            alert(result)
        }






    })
})




</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
进入页面
</body>
</html>
