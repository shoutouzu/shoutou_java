<#setting classic_compatible=true>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<#assign web_title="${articleCategory.type_name}">
<#assign web_description="${articleCategory.type_name}">
<#assign meta_keywords="${articleCategory.type_name}">
<head>
<#include "include/resource.ftl"> 
<#include "include/header.ftl"> 

</head>
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
<body>
<!--中部结束-->
<!--中部开始-->
<#include "common/date.ftl"> 
<div class="cms_page"> 
  <div class="cms_frame cf"> <#include "include/home_left.ftl"> 
    <div class="cms_content">
      <div class="cms-title-1">
        <h2>${articleCategory.type_name}</h2>
      </div>
      <div class="cms-details">
        <div class="article-list-wrap mgt">
          <table width="720" border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
            <tr>
              <td height="35" align="center" valign="middle" style="font-size:16px; font-weight:bolder">${articleDTO.title}</td>
            </tr>
            <tr>
              <td height="30" align="center" valign="middle" style="border:1px solid #CCC; background-color:#F9F9F9">发布时间：${number_to_ymdhms(articleDTO.art_time)}</td>
            </tr>
            <tr>
              <td>${articleDTO.art_content}</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
    <div style="clear:both"></div>
  </div>
</div>
</body>
<#include "include/footer.ftl"> 
</html>