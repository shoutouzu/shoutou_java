<!DOCTYPE html>
<#assign web_title="我要投资">
<#assign web_description="我要投资">
<#assign meta_keywords="我要投资">
<head>
<#include "../include/resource.ftl"> 
<#include "../include/header.ftl"> 
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/css/base.css?11111"/>
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/css/style.css?00000000"/>
<script src="${webroot}${theme_dir}/Style/Js/tab.js"></script>
	<script src="${webroot}${theme_dir}/Style/Js/banner.js"></script>
	<script src="${webroot}${theme_dir}/Style/Js/circles.js"></script>
</head>

<body>
<div class="h_main wrap">
    <div class="fix_wrap">
        <div class="invest_product">
            <i class="product_title">理财产品</i>便捷理财，选择适合您的理财产品！
        </div>
        <ul class="product_list fn-clear">
            <li class="pro_blue fn-clear">
                <p class="pro_left">${search['stockType']}新手专享</p>
                <div class="pro_right">
                    <p>年利率10%，奖励8‰</p>
                    <p>100元起投，期限7天</p>
                    <p>没投过标的新用户专属福利</p>
                </div>
            </li>
            <li class="pro_red fn-clear">
                <p class="pro_left">月月盈</p>
                <div class="pro_right">
                    <p>预期年化收益10%-14%</p>
                    <p>100元起投，期限1-12个月</p>
                    <p>每月还息到期还本</p>
                </div>
            </li>
            <li class="pro_yellow fn-clear">
                <p class="pro_left">打新宝</p>
                <div class="pro_right">
                    <p>预期年化收益18%</p>
                    <p>1000元起投，期限6-12个月</p>
                    <p>每月还息到期还本</p>
                </div>
            </li>
        </ul>


        <div class="h_layb">
            <ul class="fl">

                <li><em class="fl">理财产品</em><span class="fl">
                <#list stockTypeMap?keys as key>
                	<#if key == search['stockType'] >
                		<a class="h_class_s">${stockTypeMap[key]}</a>
                	<#else>
                		<a href="index?stock_type=${key}&borrow_status=${search['stockType'] }&borrow_duration=${search['duration'] }">${stockTypeMap[key]}</a>
                	</#if>
                </#list>

             </span></li>
                <li><em class="fl">投标状态</em>

                <span class="fl">
                	<#list statusMap?keys as key>
                	<#if key == search['status'] >
                		<a class="h_class_s">${statusMap[key]}</a>
                	<#else>
                		<a href="index?stock_type=${search['stockType'] }&borrow_status=${key}&borrow_duration=${search['duration'] }">${statusMap[key]}</a>
                	</#if>
                	</#list>
                </span>
                </li>
                <li><em class="fl">借款期限</em><span class="fl">
					<#list durationMap?keys as key>
                	<#if key == search['duration'] >
                		<a class="h_class_s">${durationMap[key]}</a>
                	<#else>
                		<a href="index?stock_type=${search['stockType'] }&borrow_status=${search['status'] }&borrow_duration=${key}">${durationMap[key]}</a>
                	</#if>
                	</#list>
             </span></li>
            </ul>
            <ul class="fr"><li><a target="_blank" href="/tools/tool2.html">投资计算器</a></li></ul>
        </div>





        <div class="h_touzi_list">
            <h1 class="font22"><span>投资列表</span></h1>
            <table class="h_touzi">
                <tr>
                    <th>借款标题</th>
                    <th>借款金额</th>
                    <th>年利率</th>
                    <th>期限</th>
                    <th>进度</th>
                    <th></th>
                </tr>
                <#list borrowList as borrowInfoDTO>
                    <tr>
                        <td class="font16">
                            <!--{:getIco($vb)}-->
                            <#if borrowInfoDTO.stock_type  == 2>
                                <i class="h_month"></i>
                                <#elseif borrowInfoDTO.stock_type == 4/>
                                <i class="h_tbao"></i>
                                <#else />
                                <i class="h_day" ></i>
                            </#if>
                            <a href="detail?id=${borrowInfoDTO.id }" title="${borrowInfoDTO.borrow_name}"><#if borrowInfoDTO.borrow_name?length lt 20>${borrowInfoDTO.borrow_name}<#else>${borrowInfoDTO.borrow_name[0..10]}...</#if> </a>
                            <#if borrowInfoDTO.reward_num gt 0>
                                <b class="h_prize">奖：${borrowInfoDTO.reward_num}%</b>
                             </#if>
                        </td>
                        <td><em class="font22 color3">${borrowInfoDTO.borrow_money}</em>元</td>
                        <td class="red font22">${borrowInfoDTO.borrow_interest_rate}%</td>
                        <td><em class="font22 color3">${borrowInfoDTO.borrow_duration} </em>
                        <#if borrowInfoDTO.repayment_type == 1>天<#else/>个月</#if></td>
                        <td><span class="rote" id="rote${borrowInfoDTO_index}" ></span></td>
                        <td width="133px">
                            <#if borrowInfoDTO.borrow_status == 3> 
                            	<a href="detail?id=${borrowInfoDTO.id }" class="css1 an">已流标</a>
                                <#elseif borrowInfoDTO.borrow_status == 4 />
                                <a href="detail?id=${borrowInfoDTO.id }" class="h_touzi_btnno">复审中</a>
                                <#elseif borrowInfoDTO.borrow_status == 6/>
                                <a href="detail?id=${borrowInfoDTO.id }" class="h_touzi_btnno">还款中</a>
                                <#elseif borrowInfoDTO.borrow_status gt 6/>
                                <a href="detail?id=${borrowInfoDTO.id }" class="h_touzi_btnno">已完成</a>
                                <#else/>
                                <a href="detail?id=${borrowInfoDTO.id }"  class="h_touzi_btn">立即投标</a>
                            </#if>
                        </td>
                    </tr>
                </#list>
            </table>
            <div class="page_box">
               
            </div>
        </div>
    </div>
</div>

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
<#include "../include/footer.ftl" /> 
</html>