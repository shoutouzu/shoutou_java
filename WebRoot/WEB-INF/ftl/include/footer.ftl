<#setting classic_compatible=true>
<div class="VdFooter">
		<div class="footer">
			<div class="footerT">
				<span class="yqlj">友情链接:</span>
				<p>
				<#list friendlist as friend>
					<span>
						<a href="${friend.link_href}" target="_blank"><img src="http://cts.ishoutou.cn/${friend.link_img}" border="0" alt="${friend.link_txt }"> </a>
					</span>
				</#list>
                </p>
			</div>
			<div class="footerC">
				<div class="f_l">
                    <p><span><a href="/aboutus/partner.html" target="_blank">合作伙伴</a></span>
					<span><a href="/aboutus/yingcai.html" target="_blank">诚聘英才</a></span>
					<span><a href="/aboutus/lianxi.html" target="_blank">联系我们</a></span>
                    <span style="display: none"><a href="/Index/download" target="_blank">交易软件</a></span>
					<span><a href="/aboutus/anquan.html" target="_blank">安全保障</a></span>
					<span><a href="/xueyuan/redian.html" >文投学院</a></span>
					</p>
                    <div class="guanzhu">
                        <span class="txt1">关注我们</span>
                        <span><a class="wb" >${wb.content}</a></span>
                        <span><a class="wx" >${wx.content}</a></span>
                    </div>
                </div>
                <div class="kefu">
					<span>客服电话</span><br/>
					<span class="nber">400-047-5588</span><br/>
					<span class="wangzhi">${wangzhi.content}</span>
				</div>
			</div>
			<div class="footerB">
				<p>
                    <span style="display: none"><a class="tu1" href="http://http://webscan.360.cn/" target="_blank"></a></span>
                    <span style="width: 130px;"><a style="width: 130px;" class="tu2" id='___szfw_logo___' href='https://credit.szfw.org/CX20150725010868110192.html' target='_blank'></a></span>
                    <span><a class="tu6" href="http://si.trustutn.org/info?sn=535150827000267215688" target="_blank"></a></span>
                    <span><a class="tu7" href="https://webverify.cfca.com.cn/WebVerify/webVerifyServlet?domain=www.ishoutou.com" target="_blank"></a></span>
				    <span style="display: none"><a class="tu3" href="http://kx.zw.cn" target="_blank"></a></span>
				    <span style="display: none"><a class="tu4" href="http://www.cec9000.com" target="_blank"></a></span>
				    <span style="display: none;"><a class="tu5" href="http://www.ccig.org.cn" target="_blank"></a></span></p>
				<p></p>
				<p>${address.content}</p>
			</div>
		</div>
	</div>
	
<!-- new kefu -->
<div class="tools_bar">
    <ul class="kfBox">
        <li class="qqKf">
            <a class="icon1" href="javascript:;"></a>
            <div class="qqKf_list" style="display:none;">
                <#list qq as vq>
                    <p><a href="tencent://Message/?Uin={${vq.qq_num}&websiteName=${vq.qq_title}&Menu=yes">${vq.qq_title}</a></p>
                </#list>
                <span></span>
                <#list qun as vq>
                <p class="last"><a target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=0b54bf9b1e47d54b596651b0539ef7ee0a04c8f7cdcab2d03a3a1da1b1a32c7a">QQ群：${vq.qq_num}</a></p>
                </#list>
            </div>
        </li>
        <li class="hotLine">
            <a class="icon2" href="javascript:;"></a>
            <div class="qqKf_list2" style="display:none;">
                <volist name=":get_qq(2)" id="vq">
                <p class="first">529269539</p>
                </volist>
                <span></span>
                <p>每个工作日9:00-18:00</p>
            </div>
        </li>
    </ul>
</div>
<script type='text/javascript'>(function(){document.getElementById('___szfw_logo___').oncontextmenu = function(){return false;}})();</script>
<link type="text/css" rel="stylesheet" href="${webroot}${theme_dir}/Style/css/kf.css"/>
<script>
    $(function(){

        $(".kfBox .qqKf").hover(
                function(){
                    $(this).find(".icon1").addClass("on");
                    $(this).find(".qqKf_list").show();
                },
                function(){
                    $(this).find(".icon1").removeClass("on");
                    $(this).find(".qqKf_list").hide();
                }
        );

        $(".kfBox .hotLine").hover(
                function(){
                    $(this).find(".icon2").addClass("on");
                    $(this).find(".qqKf_list2").show();
                },
                function(){
                    $(this).find(".icon2").removeClass("on");
                    $(this).find(".qqKf_list2").hide();
                }
        );

    });
</script>

