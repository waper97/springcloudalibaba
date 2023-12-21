<%--
  Created by IntelliJ IDEA.
  User: waper
  Date: 2020/8/17
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="static/layui/css/layui.css">
</head>
<body>
    <div class="demoTable">
        搜索
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <img src="static/images/hero_picture/105.jpg">
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
    <table id="demo" lay-filter="test"></table>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
            <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <script src="static/jquery-3.5.1.js"></script>
    <script src="static/layui/layui.js"></script>
    <script type="text/javascript">

   layui.use('table', function(){
       var table = layui.table;


       //第一个实例
       table.render({
           elem: '#demo'
           ,height: 600
           ,url: 'http://localhost:8888/waper/api/hero/listItems' //数据接口
           ,page: true //开启分页
           ,dataType:"application/json"
           ,toolbar: '#toolbarDemo'
           ,totalRow: true //开启合计行
           ,cols: [[ //表头
               {type: 'checkbox', fixed: 'left'}
               ,{field: 'itemId', title: '武器id', width:100, sort: true ,align: 'center'}
               ,{field: 'itemName', title: '武器名称', width:150 ,align: 'center'}
               , {
                   field: 'cname_image', title: '图片', width: 700, align: 'center', templet: function (t) {
                       return "<div> <img src=\"static/images/itemimg/"+t.itemId+".jpg\" style='height: 150px'></div>"
                   }
               }
               ,{field: 'itemType', title: '武器类型', width:150, sort: true ,align: 'center'}
               ,{field: 'price', title: '价格', width:100 ,align: 'center'}
               ,{field: 'totalPrice', title: '总价', width: 80 ,align: 'center'}
               ,{field: 'des1', title: '描述1', width: 100, sort: true ,align: 'center'}
               ,{field: 'des2', title: '描述2', width: 130, sort: true ,align: 'center'}
               ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}

           ]]
           ,id: 'testReload'
           ,limit:20
           ,limits: [1, 2, 3,4]
           // 数据重载
           ,parseData : function (res){
                return {
                    "code": 0, //解析接口状态
                    "msg": "fuckyou", //解析提示文本
                    // "data":JSON.parse(res.data),//解析数据列表
                    "data":res.data,//解析数据列表
                    "count": 200
                }
           }
       });
       // 搜索
       var $ = layui.$, active = {
           reload: function(){
               let demoReload = $('#demoReload').val();
               console.log(demoReload)
               //执行重载
               table.reload('testReload', {
                   url:'http://localhost:8888/waper/api/hero/listItems',
                   method:'get',
                   page: {
                       curr: 1 //重新从第 1 页开始
                   }
                   ,where: {
                       cname: demoReload

                   }
               }, 'data');
           },
       };

       $('.demoTable .layui-btn').on('click', function(){
           var type = $(this).data('type');
           active[type] ? active[type].call(this) : '';
       });

       //工具栏事件
       table.on('toolbar(test)', function(obj){
           var checkStatus = table.checkStatus(obj.config.id);
           switch(obj.event){
               case 'getCheckData':
                   var data = checkStatus.data;
                   layer.alert(JSON.stringify(data));
                   break;
               case 'getCheckLength':
                   var data = checkStatus.data;
                   layer.msg('选中了：'+ data.length + ' 个');
                   break;
               case 'isAll':
                   layer.msg(checkStatus.isAll ? '全选': '未全选')
                   break;
           }
       });


   });



    </script>

</body>
</html>
