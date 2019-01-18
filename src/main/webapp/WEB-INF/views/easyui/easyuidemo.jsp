<%--
  Created by IntelliJ IDEA.
  User: xucc
  Date: 2018/12/15
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title1778</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<%--<ul class="easyui-tree">
    <li>
        <span>Folder</span>
        <ul>
            <li>
                <span>Sub Folder 1</span>
                <ul>
                    <li><span>File 11</span></li>
                    <li><span>File 12</span></li>
                    <li><span>File 13</span></li>
                </ul>
            </li>
            <li><span>File 2</span></li>
            <li><span>File 3</span></li>
        </ul>
    </li>
    <li><span>File21</span></li>
</ul>--%>



<%--<div style="margin-bottom:10px">
    <a href="#" class="easyui-linkbutton" onclick="addTab('google','http://www.google.com')">google</a>
    <a href="#" class="easyui-linkbutton" onclick="addTab('jquery','http://jquery.com/')">jquery</a>
    <a href="#" class="easyui-linkbutton" onclick="addTab('easyui','http://jeasyui.com/')">easyui</a>
</div>
<div id="tt" class="easyui-tabs" style="width:400px;height:250px;">
    <div title="Home" closable="true">
    </div>
    <div title="Home2">
        
    </div>
</div>--%>




<%--<div class="easyui-tabs" style="width:400px;height:100px;">
    <div title="First Tab" style="padding:10px;">
        First Tab
    </div>
    <div title="Second Tab" closable="true" style="padding:10px;">
        Second Tab
    </div>
    <div title="Third Tab" iconCls="icon-reload" closable="true" style="padding:10px;">
        Third Tab
    </div>
</div>--%>






<%--<div class="easyui-layout" style="width:400px;height:200px;">
    <div region="west" split="true" title="Navigator" style="width:150px;">
        <p style="padding:5px;margin:0;">Select language:</p>
        <ul>
            <li style="list-style-type: circle"><a href="javascript:void(0)" onclick="showcontent('java')">Java</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('cshape')">C#</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('vb')">VB</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('erlang')">Erlang</a></li>
        </ul>
    </div>
    <div id="content" region="center" title="Language" style="padding:5px;">
    </div>
</div>--%>




<%--<div style="background:#ffffff;padding:5px;width:200px;border:1px solid #ccc;margin: 0px auto">
    <a href="#" class="easyui-menubutton" menu="#mm1" iconCls="icon-edit">Edit</a>
    <a href="#" class="easyui-menubutton" menu="#mm2" plain="true"  iconCls="icon-help">Help</a>
</div>
<div id="mm1" style="width:150px;">
    <div iconCls="icon-undo">Undo</div>
    <div iconCls="icon-redo">Redo</div>
    <div class="menu-sep"></div>
    <div>Cut</div>
    <div>Copy</div>
    <div>Paste</div>
    <div class="menu-sep"></div>
    <div iconCls="icon-remove">Delete</div>
    <div>Select All</div>
</div>
<div id="mm2" style="width:100px;">
    <div>Help</div>
    <div onclick="showmenu();">Update</div>
    <div>About</div>
</div>

<div style="padding:5px;background:#fafafa;width:500px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel">Cancel</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-reload">Refresh</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-search">Query</a>
    <a href="#" class="easyui-linkbutton">text button</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-print">Print</a>
</div>

<div style="padding:5px;background:#fafafa;width:500px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel">Cancel</a>
    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-reload">Refresh</a>
    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">Query</a>
    <a href="#" class="easyui-linkbutton" plain="true">text button</a>
    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-print">Print</a>
    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-help"></a>
    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-save"></a>
    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-back"></a>
</div>--%>


<%--<div>
    Click <a href="#" onclick="showmenu()">here</a> to show the menu.
</div>--%>

<%--<div id="mm" class="easyui-menu" style="width:120px;">
    <div onclick="javascript:alert('new')">New</div>
    <div>
        <span>Open</span>
        <div style="width:150px;">
            <div><b>Word</b></div>
            <div>Excel</div>
            <div>
                <span>OPEN_NO</span>
                <div style="width: 150px;">
                    <div><b>Word</b></div>
                    <div>Excel</div>
                </div>
            </div>
        </div>
    </div>
    <div>
        <span>Save</span>
        <div style="width: 150px;">
            <div><b>Word</b></div>
            <div>Excel</div>
        </div>
    </div>
    <div icon="icon-save">Save</div>
    <div class="menu-sep"></div>
    <div>Exit</div>
</div>--%>

<%--<div id="dd1" style="width: 100px;height: 100px; background-color: blue"></div>
<div id="dd2" style="width: 100px;height: 100px; background-color: yellow"></div>
<div id="dd3" style="width: 100px;height: 100px; background-color: red"></div>--%>
<%--
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">User Information</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>First Name:</label>
            <input name="userName" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>密码:</label>
            <input name="password" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>id:</label>
            <input name="id">
        </div>

    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>

--%>
<table id="dg" title="My Users" class="easyui-datagrid" style="width:80%;height:250px;margin: 0px 100px;"
       url="findUsersByPage"
       toolbar="#toolbar" idField="id" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="userName" width="50">用户名</th>
        <th field="password" width="50">密码</th>
        <th field="password" width="50" title="操作" align="center" ></th>

        <%--<th field="id" width="50">id</th>--%>

    </tr>
    </thead>

</table>

<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
    <input class="easyui-datebox" style="width:80px">
</div>



<script>
/*function newUser() {
    alert("555");
    ryx.jumpToLogin("");
}*/

    /*function addTab(title, url) {
        if ($('#tt').tabs('exists', title)){
            $('#tt').tabs('select', title);
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
            $('#tt').tabs('add',{
                title:title,
                content:content,
                closable:true
            });
        }
        
    }
    
    
    
    function showcontent(language){
        $('#content').html('Introduction to ' + language + ' language');
    }
    $(function(){
        $(document).bind('contextmenu',function(e){
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
            return false;
        });
    });
    function showmenu(){
        $.messager.show({
            title: 'Error',
            msg: "睿睿是个好孩子"
        });
        // $('#mm').menu('show', {
        //     left: 200,
        //     top: 100
        // });
    }*/



    /*$('#dd1').draggable();
    $('#dd2').draggable({
        proxy:'clone'
    });
    $('#dd3').draggable({
        proxy:function(source){
            var p = $('<div id="dd1" style="width: 100px;height: 100px; background-color: blue">');
            p.appendTo('body');
            return p;
        }
    });

    var url='saveUser';
    function saveUser() {
        $('#fm').form('submit',{
            url: url,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){
                var result = JSON.parse(result);
                $.messager.show({
                    title: 'Result',
                    msg: result.success
                });
                if (result.success!='true'){
                    $.messager.show({
                        title: 'Error',
                        msg: result.success
                    });
                } else {
                    $('#dlg').dialog('close');		// close the dialog
                    $('#dg').datagrid('reload');	// reload the user data
                }
            }
        });

    }
    function newUser(){
        $('#dlg').dialog('open').dialog('setTitle','New User');
        $('#fm').form('clear');

    }
    function editUser(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('setTitle','Edit User');
            $('#fm').form('load',row);
            url='editUser';
        }
    }
    function destroyUser(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                if (r){
                    $.post('destroy_user.php',{id:row.id},function(result){
                        if (result.success){
                            $('#dg').datagrid('reload');	// reload the user data
                        } else {
                            $.messager.show({	// show error message
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        }
                    },'json');
                }
            });
        }else{
            $.messager.show({
                title: '标题',
                msg: "未选中"
            });
        }
    }*/
</script>
</body>
</html>
