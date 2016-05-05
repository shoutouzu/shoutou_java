<#macro repayStatus status>
	<#if status==1>
		按天到期还款
	<#elseif status==2 />
		按月分期还款
	<#elseif status==4 />
		每月还息到期还本
	<#elseif status==5 />
		一次性还款
	</#if>
</#macro>