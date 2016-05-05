<!DOCTYPE html>
<html>
<title>用户登录--</title>
<body >
<include file="default:Public:_header_login" group="Home"/>
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/H/css/registerreset.css" />
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/H/css/registerstyle.css" />
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/Login/css/index.css" />

<style type="text/css">
body{}
.popbox{ width:350px; height:auto; overflow:hidden; float:left;}
.popbox li{ width:350px; height:auto; float:left;}
.popbox li span{ width:300px; height:30px; line-height:30px; float:left;}
.popbox li span.ln{ width:20px; height:20px; line-height:20px; text-align:center; color:#fff; background:#ccc; margin:5px;}
.popbox li span.user{ width:100px;}
.popbox li span.money{ width:200px;}
</style>
<script type="text/javascript">
var imgpath="${webroot}${theme_dir}/Style/M/";
var curpath="${webroot}";
</script>

<script language="javascript">
function keypress(e)
{
	var currKey=0,e=e||event;
	if(e.keyCode==13){
		document.getElementById("btnReg").click();  //调用登录按钮的登录事件
	}
}
document.onkeypress=keypress;
</script> 
<script type="text/javascript" src="${webroot}${theme_dir}/Style/M/js/login.js"></script>



<div class="login_main" style="width:100%;  /*background:url(/Style/H/images/login-bj.png) no-repeat top;*/ background-color:#f5f5f5; margin-top:0;">
	<div class="login_form" >
<div class="index-o">
	<div class="head-login">
		<div class="form" style="background:#fff;">
			<h2><span style="font-size:1.2em; color:#f06201;">登录手投网</span></h2>
			<p>
				<input type="text" placeholder="用户名/邮箱/手机号" id="txtUser" size="15" class="login_text" style=" border-radius:4px; width:230px; height:36px; line-height:36px;"/>
			</p>
			<p>
				<input type="password" size="15" class="login_pass" placeholder="请输入密码" id="txtPwd" style=" border-radius:4px; width:230px; height:36px; line-height:36px;"/>
			</p>
			<p> <span>验证码&nbsp;:</span>
				<input type="text" class="login_check" id="txtCode" style=" border-radius:4px; width:90px; height:36px; line-height:36px;"/>
			<div style="height:28px; width:240px;">
				<div  id="dvUser"></div>
			</div>
			<input type="image" src="${webroot}${theme_dir}/Style/H/images/login_submit.png" class="login_submit"  onclick="LoginSubmit(this);" id="btnReg"/>
			<div style="text-align:center; height:30px; margin-top:10px;float: right;">没有账号?<a href="__APP__/member/common/register/" style="color:#f06201; text-decoration:underline;">免费注册</a></div>
			<div style="text-align:center; height:30px; margin-top:10px;float: left;"> 　<a href="javascript:getPassWord();">忘记密码?</a> </div>
			<!--<p style=" text-align:left; padding-top:14px;border-top:1px dashed #b9b9b9; height:40px;">
                 使用合作账户登录：
                <if condition="$loginconfig['qq']['enable'] eq '1'"><img src="${webroot}${theme_dir}/Style/H/images/qq_n.png">&nbsp;<a href="__APP__/member/oauth/qq/"></a></if>
                &nbsp;
                <if condition="$loginconfig['sina']['enable'] eq '1'"><img src="${webroot}${theme_dir}/Style/H/images/sina_n.png">&nbsp;<a href="__APP__/member/oauth/sina/"></a></if>
              </p>-->
		</div>
	</div>
	<div class="hd" style="display: none">
		<ul class="num">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<div class="bd">
		<ul class="pic" >
			<li> <a href="/freestock/index" target="_blank"><img src="${webroot}${theme_dir}/Style/Login/images/banner1.png" width="800" height="280" /></a> </li>
			<li> <a href="/freestock/index"  target="_blank"><img src="${webroot}${theme_dir}/Style/Login/images/banner2.jpg"  width="800" height="280" /></a></li>
			<li> <a href="/freestock/index" target="_blank"><img src="${webroot}${theme_dir}/Style/Login/images/banner1.png"  width="800" height="280" /></a></li>
			<li> <a href="/freestock/index"  target="_blank"><img src="${webroot}${theme_dir}/Style/Login/images/banner2.jpg"  width="800" height="280" /></a></li>
		</ul>
	</div>

	<div class="pnBtn prev"> <span class="blackBg"></span> <a class="arrow" href="javascript:void(0)"></a> </div>
	<div class="pnBtn next"> <span class="blackBg"></span> <a class="arrow" href="javascript:void(0)"></a> </div>
</div>
	</div>
</div>

<script type="text/javascript" src="${webroot}${theme_dir}/Style/Login/js/fan.js"></script>

<script type="text/jscript">
            $("#m1").attr("class", "dv_header_4");
            $("#a1").attr("class", "a_h_o");
            $("#m7").attr("class", "dv_header_2");
            $("#a7").attr("class", "a_h_m");
            $("#b1").css("display", "none");      
        </script>
<script type="text/javascript">
var step = 0;
function getPassWord() {
	step = 1;
	$.get("__APP__/member/common/getpassword/",function(html){
		$.artDialog({
			title:'找回密码',
			content:html,
			okVal:'下一步',
			ok:function(){
				if(1 == step){
					ss = step1();
				}else if(2 == step){
					ss = step2();
				}else if(3 == step){
					ss = step3();
				}
				return ss;
			},
			cancelVal:'关闭',
			cancel: true
		});
	});
}
function step3(){
	var ss = false;
	var pa1 = $('#password1').val();
	var pa2 = $('#password2').val();
	$('#p1tip').html('');
	$('#p2tip').html('');
	var str = pa1;
	if('' == pa1){
		$('#p1tip').html('请填写密码!')
		return false;
	}
	if('' == pa2){
		$('#p2tip').html('请填写密码!')
		return false;
	}
    if (str.indexOf(' ')== -1&&str.length>5&&str.length<17) {
        //格式正确
    }
    else {
        $('#p1tip').html('新密码6-16个字符，空格除外');
		return false;
    }
	if(pa1.length < 6){
		$('#p1tip').html('最少6位字符!')
		return false;
	}
	if ($.trim(pa1) != $.trim(pa2)) {
		$('#p2tip').html('两次密码不一致!')
		return false;
	}
	$.ajax({
		url: "__URL__/setpassword",
		type: "post",
		dataType: "json",
		async:false,
		data: {psw:pa1,psw1:pa2},
		success: function(d) {
			if (d.status==1) {
				ss=true;
				$.jBox.tip(d.message,'tip');
			} else {
				$("#p1tip").html(d.message);
			}
		}
	});
	return ss;
}
function step2(){
	var ss = false;
	var verCodes = $('#verCodes').val();
	$('#vetip').html('');
	if('' == verCodes){
		$('#vetip').html('请填写验证码')
	}
	var code = $('#verCodes').val();
	if(code.length != 6){
		$('#vetip').html('验证码不正确')
		return ss;
	}
	$.ajax({
		url: "__URL__/validatephonev2",
		type: "post",
		dataType: "json",
		data: {"code":code},
		success: function(d) {
			if (d.status==1) {
				step = 3;
				$('#step2').hide();
				$('#step3').fadeIn(200);
			} else {
				$("#vetip").html('验证失败!');
			}
		}
	});

	return ss;
}
function step1(){
	var ss = false;
	var ux = $("#usernames").val();
	var code = $('#txtCodes').val();
	$('#utip').html('');$('#vtip').html('');
	if(ux==""){
		$('#utip').html('请填写用户名');
	}
	if(code==""){
		$('#vtip').html('请填写验证码');
	}
	$.ajax({
		url: "__APP__/member/common/dogetpass/",
		data: {"u":ux,v:code},
		//timeout: 5000,
		cache: false,
		type: "post",
		async:false,
		dataType: "json",
		success: function (d) {
			if(d.status==1){
				$('#step1').hide();
				$('#step2').fadeIn(200);
				$('#userphone').text(d.message);
				step = 2;
			}else if(d.status==2){
				$('#vtip').html(d.message);
			}else if(d.status==3){
				$('#utip').html(d.message);
			}else if(d.status == 4) {
				$.jBox.tip(d.message,'error');
				ss = true;
			}else {
				$('#utip').html(d.message);
			}
		}
	});
	return ss;
}
</script>
</html>