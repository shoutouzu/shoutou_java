<#--
 	简单样式的分页模板2
 	样式如下：共5条 20条/页|第 1/1页  转到页
 -->
 
<#macro pagestyle2 page url param>
<b>共${page.total}条</b> ${page.pernum}条/页<span class='page_line'>|</span>第 ${page.currentPage}/${page.pages}页 
<span class="page_go">转到
<input type="text" id="page_text" size="4"
 onkeydown="if (event.keyCode==13){location.href ='${url}page='+this.value+'${param}}"
 value="1" onfocus="this.select()" />页</span>
 <input type="button" class="btn-action" value="确定"
 onclick="var pageId;pageId=document.getElementById('page_text').value;location.href ='${url}page='+pageId+'${param}';">

</#macro>  