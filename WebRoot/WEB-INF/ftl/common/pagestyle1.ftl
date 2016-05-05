<#--
 	简单样式的分页模板1
 	样式如下：共19条 首页 上一页 下一页 尾页
 -->
 
<#macro pagestyle1 page url param linkPage>
<span class="pageclass">共${(page.total)?c}条${page.pages!0}页</span>
<#if page.pages gt 1>
	&nbsp;<a class="pageclass" href="${url}page=1${param}">首页</a>
<#else>
	&nbsp;<span class="pageclass">首页</span>
</#if> 
<#if page.hasPreview() >
	&nbsp;<a class="pageclass" href="${url}page=${(page.currentPage-1)?c}${param?default("")}">上一页</a>
<#else>
	&nbsp;<span class="pageclass">上一页</span> 
</#if>
&nbsp;<span>${linkPage }</span> 
<#if page.hasNext() >
	&nbsp;<a class="pageclass" href="${url}page=${(page.currentPage+1)?c}${param}">下一页</a>
<#else>
	&nbsp;<span class="pageclass">下一页</span> 
</#if><#if page.pages gt 1>
	&nbsp;<a class="pageclass" href="${url}page=${(page.pages)?c}${param}">尾页&nbsp;</a>
<#else>
	&nbsp;<span class="pageclass">尾页</span>
</#if>
<span class="page_go">转到
<input type="text" id="page_text" size="4"
 onkeydown="if (event.keyCode==13){location.href ='${url}page='+this.value+'${param}}"
 value="${page.currentPage!1}" onfocus="this.select()" />页</span>

 <input type="button" style="width: 50px; margin: 0 15px; padding: 0; border: 1px solid #d7d7d8; font-size: 16px; color: #666;
    border-radius: 3px;cursor: pointer; background-color: #fdfdfd" value="确定"
 onclick="var pageId;pageId=document.getElementById('page_text').value;location.href ='${url}page='+pageId+'${param}';">
</#macro>  