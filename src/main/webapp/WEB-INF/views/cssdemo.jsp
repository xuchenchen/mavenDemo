<%--
  Created by IntelliJ IDEA.
  User: xucc
  Date: 2018/12/21
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/easyui/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <style>
        .test{position: absolute;width: 200px;height: 200px;background-color: blue;text-align: center}
        .test:hover{background-color: #cccccc}
    </style>
</head>
<body>
<%--<div id="vue_det">
    <h1>site : {{site}}</h1>
    <h1>url : {{url}}</h1>
    <h1>{{details()}}</h1>
</div>--%>
<div id="app">
    <ul>
        <li v-for="value in object">
            {{ value }}{{reversedMessage(value)}}
        </li>
    </ul>
</div>

<script type="text/javascript">
    new Vue({
        el: '#app',
        data: {
            object: {
                name: '菜鸟教程',
                url: 'http://www.runoob.com',
                slogan: '学的不仅是技术，更是梦想！'
            }
        },
        methods:{
            reversedMessage:function (msg) {
                // return this.object.slogan.reverse();
                console.log(msg);
                return msg;
            }
        }
    })


    // new Vue({
    //     el: '#app',
    //     data: {
    //         message: '<h1>菜鸟教程</h1>'
    //     }
    // })

    // var data={site:"网站",url:"www.baidu.com",alexa:"100"};
    // var vm =new Vue({
    //     el:'#vue_det',
    //     data:data,
    //     methods:{
    //         details:function () {
    //             return this.site+'网址是'+this.url;
    //         }
    //     }
    // });
    // vm.site="测试"


    // var tmp = new Date();
    //
    // function f() {
    //     console.log(tmp);
    //     if (false) {
    //          tmp = 'hello world';
    //     }
    // }
    //
    // f(); //

    // var name = "The Window";
    // var object = {
    //     name : "My Object",
    //     getNameFunc : function(){
    //         name='2222222';
    //         return function(){
    //             return this.name;
    //         };
    //     }
    // };
    // alert(object.getNameFunc()());//result:The Win
    // var num = 1;            //声明一个全局变量
    // function func() {
    //     var num = 2;        //声明一个局部变量
    //     return num;
    // }
    // console.log(num);
    // console.log(func());    //输出：2


    // $(".trigger").click(function () {
    //     alert($(".trigger").text("text"));
    // });
    // $(function () {
    //
    // });
    // var a = [];
    //
    //     for (var num = 0; num < 10; num++) {
    //         a[num] = function () {
    //             var b=num+'==';
    //             console.log(b);
    //         };
    // }
    // a[6]();
    // a[6](); // 10
</script>

</body>
</html>
