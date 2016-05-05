<!DOCTYPE html>
<#assign web_title="【网贷_网贷平台_p2p网贷_P2P网贷平台】">
<#assign web_description="p2p网贷，实物抵押贷款借贷，安全可靠！设置严格的风控体系，并设立'风险保障金'，借款逾期时，先行垫付借款本金，保障投资人资金安全">
<#assign meta_keywords="网贷,网贷平台,p2p网贷,P2P网贷平台,">
<head>
<#include "include/resource.ftl"> 
<#include "include/header.ftl"> 
<#include "common/function.ftl"> 

<style type="text/css">
<!--
.STYLE1 {
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    font-size: 36px;
    color: #FF0000;
}
.STYLE13 {font-size: 24}
.STYLE15 {font-family: Arial, Helvetica, sans-serif; font-size: 24px; }
-->
</style>
	<link rel="stylesheet" href="${webroot}${theme_dir}/Style/css/base.css?11111"/>
	<link rel="stylesheet" href="${webroot}${theme_dir}/Style/css/style.css?00000000"/>
	<script src="${webroot}${theme_dir}/Style/Js/tab.js"></script>
	<script src="${webroot}${theme_dir}/Style/Js/banner.js"></script>
	<script src="${webroot}${theme_dir}/Style/Js/circles.js"></script>
</head>

<body>
<div class="h_ban">
   <ul style="background:#00CCFF">
         <li style="background: url(${webroot}${theme_dir}/20151222113932311.jpg) center no-repeat">
         <a target="_blank" href="${webroot}" >&nbsp;</a> </li>
   </ul>
   <div class="fix_wrap" style="position:relative;">
      <div class="h_loginbg"></div>
      <div class="h_login">
         <p class="font18">手投网年化收益率</p>
         <p>最高<i class="red font40">18.00%</i></p>
         <p><span class="fl" style="color: #666"><i class="red">51.43</i>倍活期存款</span><span class="fr"><i class="red">6.00</i>倍定期存款</span></p>
         <#if '1' =='1'>
            <p style="clear: both"></p>
            <p>欢迎您，<i class="red">admin</i></p>
            <#else>
            <p class="h_login_btn"><a href="/member/common/register.html">立即注册<em class="font16" style="color: #fff;margin-left: 10px;">领红包</em></a></p>
            <p class="h_long2">已有账号？<a href="/member/common/login.html"><u>立即登录</u></a></p>
         </#if>
      </div>
   </div>
</div>
<div style="clear: both;"></div>
<div class="h_ban_btm">
   <ul class="fix_wrap">
      <li class="fl h_ban_btm1" style="margin-left:50px;"><p><b class="red font26">${memberCount}</b>人</p><p>服务用户数</p></li>
      <li class="fl h_ban_btm2" style="margin-left:50px;"><p><b class="red font26">${borrow_sum}</b>元</p><p>成交金额</p></li>
      <li class="fl h_ban_btm3" style="margin-left:50px;"><p><b class="red font26">${investorProfit}</b><cite class="red"> </cite>元</p><p>理财收益</p></li>
      <li class="fr h_ban_mor" style="display: none"><a href="/invest/index">更多>></a></li>
   </ul>
</div>
<div class="h_main wrap">
   <div class="fix_wrap">
      <div class="h_left fl">
         <ul class="h_left_top">
            <li><a href="/aboutus/jianjie.html" target="_blank"><i class="h_licona"></i><span class="fl" style="font-size: 22px;"><br><h2 class="font22">国资背景</h2><p>理财安心</p></span></a></li>
            <li><a href="/aboutus/jianjie.html#wenhua" target="_blank"><i class="h_liconb"></i><span class="fl" style="font-size: 22px;"><br><h2 class="font22">文化金融</h2><p>潜力之选</p></span></a></li>
            <li><a href="/aboutus/jianjie.html#hangye" target="_blank"><i class="h_liconc"></i><span class="fl" style="font-size: 22px;"><br><h2 class="font22">创新模式</h2><p>趋零风险</p></span></a></li>
         </ul>
         <div class="h_left_main">
            <h1><b>理财项目</b><em class="fl">轻松投标，便捷理财，100%本息保障。</em><a href="/invest/index" class="fr">更多>></a></h1>
            <table>
               <#list borrowList as borrowInfoDTO>
                  <tr><th colspan="5"><h2>
                  <i class="<#if borrowInfoDTO.stock_type == 1 >h_day<#elseif borrowInfoDTO.stock_type == 4/>h_tbao<#else>h_month</#if>"></i>
                  <a title="${borrowInfoDTO.borrow_name}" href="${webroot}/invest/detail?id=${borrowInfoDTO.id}">${borrowInfoDTO.borrow_name}</a>
                  <#if borrowInfoDTO.reward_num gt 0>
                     <b class="h_prize">奖：${borrowInfoDTO.reward_num}%</b>
                     </#if></h2></th></tr>
                  <tr>
                     <td width="190px"><p><em>年利率：</em><i class="font22 red">${borrowInfoDTO.borrow_interest_rate}%</i></p><p><em>还款方式：</em>
                     	<i>
                     		<@repayStatus status = borrowInfoDTO.repayment_type/>
                     	</i>
                     </p></td>
                     <td width="156px"><p><em>借款期限：</em><i class="font22 color3">${borrowInfoDTO.borrow_duration} </i><cite><#if borrowInfoDTO.repayment_type == 1>天<#else>个月</#if></cite></p>
                     <p><em>投标奖励：</em><i>
                     <#if borrowInfoDTO.reward_num gt 0>
                     		${borrowInfoDTO.reward_num}%
                        <#else>
                        	无
                     </#if>
                     </i></p></td>
                     <td width="210px"><p><em>金额：</em><i class="font22 color3">${borrowInfoDTO.borrow_money}</i><cite>元</cite></p></td>
                     <td><div class="rote" id="rote${borrowInfoDTO_index}"></div></td>
                     <td width="133px">
                        <#if borrowInfoDTO.borrow_status ==3 > <a href="#" class="css1 an">已流标</a>
                           <#elseif borrowInfoDTO.borrow_status == 4 />
                           <a  href="${webroot}/invest/detail?id=${borrowInfoDTO.id}" class="h_touzi_btnno">复审中</a>
                           <#elseif borrowInfoDTO.borrow_status ==6/>
                           <a  href="${webroot}/invest/detail?id=${borrowInfoDTO.id}" class="h_touzi_btnno">还款中</a>
                           <#elseif borrowInfoDTO.borrow_status gt 6/>
                           <a  href="${webroot}/invest/detail?id=${borrowInfoDTO.id}" class="h_touzi_btnno">已完成</a>
                           <#else>
                           <a  href="${webroot}/invest/detail?id=${borrowInfoDTO.id}"  class="h_touzi_btn">立即投标</a>
                        </#if>
                     </td>
                  </tr>
                  <tr><th colspan="5"><div class="h_line"></div></th></tr>
               </#list>
            </table>
         </div>
      </div>
      <div class="h_right fr">
         <div class="h_right_top">
            <h1></h1>
            <ul>
               <li class="h_right_topl"><a target="_blank" href="/aboutus/jianjie.html"><i></i><p style="text-align: center">认识手投网</p><span><em>选择手投</em><br/><em class="font18">钱途无忧</em></span></a></li>
               <li class="h_right_topr"><a target="_blank" href="/Help/novice"><i></i><p style="text-align: center">玩转理财</p><span><em class="font18">1分钟</em><br/><em>教你玩转理财</em></span></a></li>
            </ul>
         </div>
         <div class="h_pub">
            <h1 class="h_title"><b class="font18">网站公告</b><a href="article/gonggao?flag=gonggao" class="fr">更多>></a></h1>
            <ul>
               <#list gonggaoList as article >
               <li><a href="article/view?id=${article.id?c}&type_id=${article.type_id?c}">${article.title}</a></li>
               </#list>
            </ul>
         </div>
         <div class="h_move">
            <h1 class="h_title" style="margin-bottom: 10px;"><b class="font18">i 主播</b><a href="/Help/videos" class="fr">更多>></a></h1>
            <ul>
               <li><a href="/Help/videos" target="_blank"><img src="${webroot}${theme_dir}/Style/img/izhubo2.jpg" border="0"></a>
               </li>
               <li><a href="/Help/videos" class="h_move_txt">了解更多如何安全高效理财</a></li>
            </ul>
         </div>
         <div class="h_img"><a href="/tools/tool2.html"><img src="${webroot}${theme_dir}/Style/img/a_45.jpg" width="274px" height="127px"/></a></div>
      </div>
   </div>
   <div class="clear"></div>
</div>
<div class="clear"></div>
<div class="media">
   <div class="media_main">
      <h3>媒体报道</h3>

      <#list mediaList as media>
         <a href="${media.link_href}" target="_blank">
            <img src="http://cts.ishoutou.cn/${media.link_img}"/>
            <div class="media-tip">
               <p>${media.link_txt}</p>
            </div>
         </a>
      </#list>




   </div>
</div>
<style>
 .circles-text{ position: absolute; top: 0px; left: 0px; text-align: center; width: 100%; font-size: 11px; height: 60px; line-height: 60px;}
</style>
<script type="text/javascript">	
var width = document.body.offsetWidth;
$(".h_ban").yxMobileSlider({width:width,during:3000})
$(function () {
   function loadImg(obj, data) {
      var i = 0;
      setInterval(function () {
         i++
         if (i > data) {
            i = data
         }
         var imgLeft = -(i * 59 + (i * 6)) + 'px';
         var imgLeft = imgLeft + '\t' + '0px';
         obj.css("backgroundPosition", imgLeft);
         obj.html(i + '%');
      }, 1)
   }
   var arr = new Array();
   <#list progress as str>
   		arr.push(${str});
   </#list>
	
	var colors = [
						['#EEE', '#DA471C']
					],
			circles = [];

		for (var i = 0; i < arr.length; i++) {
			var child = document.getElementById('rote' + (i)),
				//percentage = 31.42 + (i * 9.84),
				
				circle = Circles.create({
					id:         child.id,
					value:      arr[i],
					radius:     getWidth(),
					width:      4,
					colors:     colors[0],
					textClass: 'prosser'
				});

			circles.push(circle);
		}

		window.onresize = function(e) {
			for (var i = 0; i < circles.length; i++) {
				circles[i].updateRadius(getWidth());
			}
		};

		function getWidth() {
			return 30;
		}
})


</script>
</body>
<#include "include/footer.ftl"> 
</html>