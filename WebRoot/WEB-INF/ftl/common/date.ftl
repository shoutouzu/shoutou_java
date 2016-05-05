<#function number_to_ymdhms date>

 <#if date != null>

   <#setting datetime_format="yyyy-MM-dd HH:mm:ss"/>

    <#return (date+"000")?number?number_to_datetime/>

 </#if>

 <#return ""/>

</#function>
<#function number_to_ymdhm date>

 <#if date != null>

   <#setting datetime_format="yyyy-MM-dd HH:mm"/>

    <#return (date+"000")?number?number_to_datetime/>

 </#if>

 <#return ""/>

</#function>
<#function number_to_ymd date>

 <#if date != null>

   <#setting datetime_format="yyyy-MM-dd"/>

    <#return (date+"000")?number?number_to_datetime/>

 </#if>

 <#return ""/>

</#function>


<#function date_to_ymdhms date>

 <#if date != null>

    <#return date?string('yyyy-MM-dd hh:mm:ss')/>

 </#if>

 <#return ""/>

</#function>