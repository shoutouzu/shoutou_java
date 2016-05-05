<#import "common/pagestyle1.ftl" as pagestyle1> 
<#import "common/pagestyle2.ftl" as pagestyle2>  

<#macro pagination page url map style>

<#assign pageurl=url>
<#assign param="" >

	<#list map?keys as key>
	    <#if map[key]??&&map[key]!="">
	    	<#assign value=map[key] >
		    <#if value?exists>
		    	<#assign param=param+"&"+key+"="+value >
		    </#if>
	    </#if>
	</#list>
	<#if pageurl?index_of("?") lt 0>
		<#assign pageurl=pageurl+"?">
	<#else>
		<#assign pageurl=pageurl+"&">
	</#if>
	<#assign nowCoolPage = (page.currentPage/8)?ceiling>
	<#assign totalPages = (page.total/page.pernum)?ceiling>
	<#assign linkPage="" >
	<#list 1..8 as i>
	    	<#assign page_=(nowCoolPage-1)*8+i >
		    <#if page_!=page.currentPage>
		    	<#if page_ lte totalPages>
		    		<#assign  linkPage = linkPage+"&nbsp;<a style='color: #666;text-decoration: none;outline: none;transition: all 0.3s ease-out' href='${pageurl}page=${page_}'>${page_}</a>" >
		    	</#if>
		    <#else>
		    	<#if page.total!=1>
		    		<#assign  linkPage =linkPage+ "&nbsp;<span style='padding: 1px 10px;color: #fff;border-radius: 3px;background: #007eab' href='#'>${page_}</span>" >
		    	</#if>
		    </#if>
	</#list>
	<#if style=="style1">
		 <@pagestyle1.pagestyle1 page=page url=pageurl param=param linkPage=linkPage/>
	<#elseif style=="style2" >
		 <@pagestyle2.pagestyle2 page=page url=pageurl param=param />
	<#else>
</#if>

</#macro>