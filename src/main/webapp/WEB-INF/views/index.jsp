<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: xucc
  Date: 2018/11/6
  Time: 8:49
  To change this template use File | Settings | File Templates.

--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
<head>
    <title>瑞银信测试包下载页2</title>
</head>
<body>
<script src="/jss/jquery-3.3.1.js"></script>
<script src="/jss/json2.js"></script>
<h1>${uid}11111</h1>
<h2 id="h2id">测试乱码</h2>
<h2>${pageContext.request.servletPath}</h2>
<%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
<%--<form:form modelAttribute="user" action="/home/register2">
<table>
    <tr>
        <td>姓名</td>
        <td><form:input path="loginname"></form:input></td>
        <td><form:errors path="loginname" cssClass="color:red"></form:errors></td>
    </tr>
    <tr><td><input type="submit" value="提交"></td></tr>
</table>


</form:form>--%>



<%--<h1>欢迎${name}密码${password}路径${path}</h1>
<table>
    <tr>
        <td>姓名</td>
        <td>${requestScope.user.loginname}</td>
    </tr>
    <tr>
        <td>生日</td>
        <td><fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
    </tr>
    <tr>
        <td>百分比</td>
        <td>${requestScope.user.discount}</td>
    </tr>
</table>--%>


<%--<form action="/home/register2" method="post">
    <table>
        <tr>
            <td>登录名</td>
            <td><input type="text" name="loginname"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>百分比</td>
            <td><input type="text" name="discount"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>--%>


<%--<form:form modelAttribute="user" method="post" action="checkboexForm">
    <table>
        <tr>
            <td>性别</td>
            <td>
                <form:radiobutton path="sex" value="男"/>男
                <form:radiobutton path="sex" value="女"/>女
            </td>
        </tr>
        <tr>
            <td>性别2</td>
            <td>
               <form:radiobuttons path="sex" items="${sexs}"></form:radiobuttons>
            </td>
        </tr>
    </table>

</form:form>
<form:form modelAttribute="user" method="post" action="checkboxesForm" >
    <table>
    <tr>
        <td>选择课程</td>
        <td><form:checkboxes path="courses" items="${courseList}"></form:checkboxes></td>
    </tr>
    </table>

</form:form>

<form:form modelAttribute="commandw" action="register" method="post">
    <table>
    <tr>
        &lt;%&ndash;<td>FORM姓名</td><td><form:input path="name"/></td>&ndash;%&gt;
    </tr>
        <tr><td>性别</td>
            <td>
                <form:input path="id"></form:input>
            &lt;%&ndash;<form:options>
                <form:option  value="男"></form:option>
                <form:option value="女"></form:option>
            </form:options>&ndash;%&gt;
            </td>
        </tr>
        <tr><td>年龄</td><td><form:input path="age"></form:input></td></tr>
        <tr><td><form:textarea path="name" cols="5" rows="10"></form:textarea></td></tr>
        <tr><td>
            <form:checkbox path="courses" value="Java" label="Java"></form:checkbox>
            <form:checkbox path="courses" value="Spring" label="Spring"></form:checkbox>
            <form:checkbox path="courses" value="PHP" label="PHP"></form:checkbox>
        </td></tr>
    </table>

</form:form>


<form action="/home/testIndex" method="post">

    <table>
        <tr>
            <td>姓名</td>
            <td><input name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr><td><input type="submit" value="提交是"></td></tr>
    </table>

</form>
<button onclick="ajaxPost()">Ajax</button>
<table>
    <tr><td>id</td><td id="id"></td></tr>
    <tr><td>id</td><td id="name"></td></tr>
    <tr><td>id</td><td id="age"></td></tr>
</table>--%>
<%--<input id="name" type="text" style="width: 200px;height: 100px" >
<input id="btn" type="button" value="Ajax请求" >--%>
<%--<h2>Hello,${namelist}</h2>
<a href="/home/pkg">下载</a>--%>

<%--<h1>${kkk.age}</h1>
<div style="display: block"><h1 style="margin-left: 50px;margin-top: 100px">瑞刷<button>自动生成瑞刷最新包</button> </h1> </div>
<h4>最新下载地址</h4>
<div style="margin: 30px auto;display: block">
    <ul>
        <li><a href="${newpkg}">${newpkg}</a></li>
    </ul>
</div>
<h4>瑞刷历史包</h4>
<ul>
    <li><span>最新下载地址</li>
    <li><a href="http://www.baidu.com">你好</a></li>
</ul>--%>
<script>



    function ajaxPost() {
      var jsonStr=  JSON.stringify({age:11,name:"XUcc",id:"ids"});
        $("#id").html(jsonStr);

        $.ajax("${pageContext.request.contextPath}/home/ajaxRequest",{
            // dataType:"JSON",
            type:"POST",

            contentType:'application/json;charset=utf-8',
            data:jsonStr,
            // traditional:true,
            // data:{name:"kkkk"},
            async:false,
            success:function (data) {
                console.log(data)
                var dataObj=JSON.parse(data);
                $("#id").html(dataObj.id);
                $("#name").html(dataObj.name);
                $("#age").html(dataObj.age);
            },
            error:function (error) {
                alert(error.toString())
            }
        })
    }
   /* $(function () {
        // $("#btn").click(function () {
        //     var nameVal=$("#name").val();
        //     alert("请求=="+nameVal)
        //     $.post("/home/show",{name:nameVal},function (data) {
        //         alert(data)
        //     });
        // });

        <%--var nameList='${namelist}';--%>
        alert(nameList);
    }

    );*/

</script>
</body>
</html>
