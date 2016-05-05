<#setting classic_compatible=true>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<#assign web_title="网站公告">
<#assign web_description="网站公告">
<#assign meta_keywords="网站公告">
<head>
<#include "include/resource.ftl"> 
<#include "include/header.ftl"> 
<style type="text/css">
.cms-details img,.cms-details a img{ 
border:0; 
margin:0; 
padding:0; 
max-width:710px; 
width:expression(this.width>710?"710px":this.width); 
}
.cms-details p{ width:710px; overflow:hidden;}
</style>

</head>

<body>
<!--中部结束-->
<div class="cms_page">
  <div class="cms_frame cf"> <#include "include/home_left.ftl"> 
    <div class="cms_content">
      <div class="cms-title-1">
        <h2>${articleCategory.type_name}</h2>
      </div>
      <div class="cms-details">
        <div class="article-list-wrap mgt">
          <div class="article-list mgt">
            <ul>
              <#include "common/date.ftl"> 
              <#list gonggaoList as articleDTO>
                <li class="changecolor"> <span class="item-title"><a href="view?id=${articleDTO.id?c}&type_id=${articleCategory.id?c}"  >${articleDTO.title}</a></span> <span class="release-time"> ${number_to_ymd((articleDTO.art_time) )}</span> </li>
              </#list>
            </ul>
          </div>
          <div class="list_bottom">
            <div class="list_bottom_right">
              <ul>
                <!--分页开始-->
					<#if (gonggaoList?exists)&&(gonggaoList?size>0)>
					<div style="line-height:26px; font-size:14px; text-align:left; width:830px;white-space:nowrap; padding-top:20px; "  >
						<table class="list_table_page">
							<#import "common/page.ftl" as pager>  
							<#assign url="${webroot}/article/gonggao?flag=${articleCategory.type_nid}" />
		         	 		<@pager.pagination page=page url=url map=param style="style1" />
						</table>
					</div>
					<#else>
					暂无记录
					</#if>
					<!--分页结束-->
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div style="clear:both"></div>
  </div>
</div>
</body>
<#include "include/footer.ftl"> 
</html>