<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Complex Layout - jQuery EasyUI Demo</title>
		<link rel="stylesheet" type="text/css" href="../../script/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../../script/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="../demo.css">
		<script type="text/javascript" src="../../script/jquery.min.js"></script>
		<script type="text/javascript" src="../../script/jquery-form.js"></script>
		<script type="text/javascript" src="../../script/jquery.easyui.min.js"></script>
		
		<script>
			$(function(){
				var index = 0;
				var t = $('#tt');
				var tabs = t.tabs('tabs');
				setInterval(function(){
					t.tabs('select', tabs[index].panel('options').title);
					index++;
					if (index >= tabs.length){
						index = 0;
					}
				}, 3000);
			});
			
			function pass(){
				$("#Form").submit(); 
			}
			
			function uploadPic2(){  
            	if($("#filename").val()==""){  
                    $.messager.alert("提示","请填写文件名");  
                    return false;  
                }  
            	
            	var options = { 
            			//target: '#mydiv', // 需要刷新的区域 
            			//beforeSubmit: showRequest, // 提交前调用的方法 
            			//success: showResponse // 返回后笤俑的方法 
            			// other available options: 
            			//url: url // 提交的URL, 默认使用FORM ACTION 
            			//type: type // 'get' or 'post', override for form's 'method' attribute 
            			//dataType: null // 'xml', 'script', or 'json' (expected server response type) 
            			//clearForm: true // 是否清空form 
            			resetForm: true // 是否重置form 
            			// $.ajax options can be used here too, for example: 
            			//timeout: 3000 
            	};  
            	
            	$("#p").ajaxSubmit(options);     
            	showCheckProgress();
             }  
			
			 var timerId;  
			 function showCheckProgress(){  

				$('#progressDlg').dialog('open')
			   //想要修改进度条的颜色去css文件中去修改    
			     $('#p2').progressbar({    
			         value : 0,          
			         text : '{value}%'   
			     });   
			   timerId = window.setInterval(getCheckProgress,1000);  
			 }
			 
			//通过post请求得到进度  
			  function getCheckProgress(){  
			       $.ajax({  
			           type:"post",
			           url:"/uitest/uploadprogress",
			           timeout:3000,
			           dataType:"json",
			           success:function(data){  
				             if(data.progressValue>=100){  
				            	 $('#progressDlg').dialog('close')
				                 window.clearInterval(timerId);  
				                 $('#dg').datagrid('load');  
				                 $('#importBtn').css('display','inline-block');  
				                 $('#showProgress').css('display','none');  
				             } 
			           		$("#p2").progressbar('setValue',data.progressValue);  
			            },  
			            //请求出错的处理  
			            error:function(){  
			             window.clearInterval(timerId);  
			             //alert("请求出错");  
			            }  
			        });  
			  }  
		</script>
		
	</head>
<body class="easyui-layout">
	<div class="easyui-layout" data-options="region:'north',border:false" style="height: 120px">
		<div data-options="region:'north',border:false" style="height:68px;background-image: url(images/logo.png)"></div>
		<div data-options="region:'south',border:false,split:true" style="height:55px;">
			<div class="easyui-panel" style="padding: 10px;">
				<a href="http://localhost:8080/xiaowei" class="easyui-linkbutton" data-options="plain:true">首页</a>
				<a id="btn-edit" href="#" class="easyui-menubutton"
					data-options="menu:'#mm1',iconCls:'icon-edit'">编辑</a> <a href="#"
					class="easyui-menubutton"
					data-options="menu:'#mm2',iconCls:'icon-help'">帮助</a> <a href="#"
					class="easyui-menubutton" data-options="menu:'#mm3'">关于</a>
			</div>
			<div id="mm1" style="width: 150px;">
				<div data-options="iconCls:'icon-undo'">任务接收</div>
				<div data-options="iconCls:'icon-redo'">成员召回</div>
				<div class="menu-sep"></div>
				<div>驻点分布</div>
				<div>入驻申请</div>
				<div>成员申请</div>
				<div class="menu-sep"></div>
				<div>
					<span>更多</span>
					<div>
						<div>Address</div>
						<div>Link</div>
						<div>Navigation Toolbar</div>
						<div>Bookmark Toolbar</div>
						<div class="menu-sep"></div>
						<div>New Toolbar...</div>
					</div>
				</div>
			</div>
			<div id="mm2" style="width: 100px;">
				<div>入驻流程</div>
				<div>最新消息</div>
				<div>联系我们</div>
			</div>
			<div id="mm3" class="menu-content"
				style="background: #f0f0f0; padding: 10px; text-align: left">
				<img src="http://www.jeasyui.com/images/logo1.png"
					style="width: 150px; height: 40px">
				<p style="font-size: 14px; color: #444;">Try jQuery EasyUI to
					build your modern, interactive, javascript applications.</p>
			</div>
		</div>
	</div>
	
	<div class="easyui-layout" data-options="region:'south',split:true" style="height: 120px;">
		<div data-options="region:'east',split:true" title="签到" style="width:220px;">
			<div style="text-align:center; padding:10px;background:#fafafa;width:90%;border:0px solid #ccc" >今日已签到：${person} 人</div>
			<div style="text-align:center; padding:10px;background:#fafafa;width:90%;border:0px solid #ccc">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#sign').window('open')">打卡签到</a>
				<div id="sign" closed="true" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save'" style="width:500px;height:200px;padding:5px;">
					<div class="easyui-layout" data-options="fit:true">
						<div data-options="region:'center'" style="padding:10px;">
							<form  action="/uitest/sign" name="Form" id="Form" method="post" >
								请输入您的用户名：<input type="text" name="bankcardnumber"
									id="bankcardnumber" value="" title="账号号码" />
							</form>
						</div>
						<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="pass();" "width:80px">Ok</a>
							<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#sign').window('close')" style="width:80px">Cancel</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div data-options="region:'center',iconCls:'icon-ok'" title="版块链接" style="padding:0px">
			<div style="text-align:center; padding:20px;background:#fafafa;width:96%;border:0px solid #ccc">
				<a href="http://www.beryoo.cn" target="_blank" class="easyui-linkbutton" plain="true">友情链接</a>
				<a href="http://www.cnhonkerarmy.com" target="_blank" class="easyui-linkbutton" plain="true">新闻动态</a>
				<a href="http://www.cnhonkerarmy.com/purpose.htm" target="_blank" class="easyui-linkbutton" plain="true">网站宗旨</a>
				<a href="http://www.cnhonkerarmy.com/post.htm" target="_blank" class="easyui-linkbutton" plain="true">职位申请</a>
			</div>
		</div>
	</div>
	
	<div data-options="region:'east',split:true" title="文件浏览器"
		style="width: 180px;">
		<ul class="easyui-tree"
			data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
	</div>
	<div data-options="region:'west',split:true" title="工具"
		style="width: 275px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="邮编" style="padding: 10px;">
				<form id="p" method="POST" enctype="multipart/form-data" accept="image/gif, image/jpeg,image/jpg, image/png" action="/uitest/fileupload">   
					<div style="margin:20px 0;"></div>
					<div style="margin-bottom:20px">
						<div>文件名:</div>
						<input id="filename" name="filename" class="easyui-textbox" style="width:100%" />
					</div>
					<div style="margin-bottom:20px">
						<div>任务文件:</div>
						<input class="easyui-filebox" id="file" name="file" data-options="prompt:'Choose a file...'" style="width:100%" />
					</div>
					<div>
						<a href="#" class="easyui-linkbutton" style="width:100%" onclick="uploadPic2()">提交</a>
					</div>
					
					<div id="progressDlg" class="easyui-dialog" title="执行进度" style="width: 600px;hight:400px;" data-options="iconCls:'icon-save',closed:true,resizable:true,modal:true,collapsible:true, buttons: '#progressDlgBtns'">  
				        <div style="padding: 10px 60px 20px 60px">  
				          <div id="p2" class="easyui-progressbar" style="width:400px;"></div>  
				        </div>  
				    </div>  
				    <div id="progressDlgBtns" style="width: 600px;">  
				        <a href="javascript:void(0)" class="easyui-linkbutton" style="padding: 4px;" onclick="javascript:$('#progressDlg').dialog('close')">关闭</a>  
				    </div> 
				</form>
			</div>
			
			<div title="日历" style="padding: 10px;">
				<div style="margin:20px 0"></div>
				<div class="easyui-calendar" showWeek="true" weekNumberHeader="Wk" 
				data-options="months:['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']" 
				style="width:250px;height:250px;"></div>
			</div>
			
			<div title="赞助商" data-options="selected:true" style="padding: 0px">
				<div id="tt" class="easyui-tabs" style="width:263px;height:400px;">
					<div title="云云" style="padding:10px;">
						<img src="images/yun.jpg">
					</div>
					<div title="强强" style="padding:10px;">
						<img src="images/qiang.jpg">
					</div>
					<div title="腾腾" style="padding:10px;">
						<img src="images/teng.jpg">
					</div>
					<div title="林林" style="padding:10px;">
						<img src="images/lin.jpg">
					</div>
				</div>	
			</div>
		</div>
	</div>
	<div
		data-options="region:'center',title:'信息数据',iconCls:'icon-ok'">
		<div class="easyui-tabs"
			data-options="fit:true,border:false,plain:true">
			<div title="中国红客" data-options="href:'_content.html'"
				style="padding: 10px"></div>
			<div title="已入驻城市信息" style="padding: 5px">
				<table class="easyui-datagrid"
					data-options="url:'datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
					<thead>
						<tr>
							<th data-options="field:'itemid'" width="80">Item ID</th>
							<th data-options="field:'productid'" width="100">Product ID</th>
							<th data-options="field:'listprice',align:'right'" width="80">List
								Price</th>
							<th data-options="field:'unitcost',align:'right'" width="80">Unit
								Cost</th>
							<th data-options="field:'attr1'" width="150">Attribute</th>
							<th data-options="field:'status',align:'center'" width="50">Status</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>