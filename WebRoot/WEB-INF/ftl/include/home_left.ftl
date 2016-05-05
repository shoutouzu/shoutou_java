
<div class="cms_nav">
  <ul class="cn-nav-1-1ist">
    <#list leftlist as articleCategoryDTO>
      <li class="cn1l-item <#if articleCategoryDTO.id = articleDTO.type_id>current</#if> "> <a href="${webroot}/article/gonggao?flag=${articleCategoryDTO.type_nid}" title="${articleCategoryDTO.type_name}" class="cn1l-item-name"  style=" background-image:none;">${articleCategoryDTO.type_name}</a> </li>
    </#list>
  </ul>
</div>
