<#setting classic_compatible=true>
<!DOCTYPE html><#assign web_title="我要投资_${borrowinfo.borrow_name }">
<#assign web_description="我要投资_${borrowinfo.borrow_name }">
<#assign meta_keywords="我要投资_${borrowinfo.borrow_name }">
<head>
<#include "include/resource.ftl"> 
<#include "include/header.ftl"> 
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/css/base.css"/>
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/css/style.css"/>
<link rel="stylesheet" href="${webroot}${theme_dir}/Style/css/fancybox.css"/>
<script type="text/javascript" src="${webroot}${theme_dir}/Style/css/jquery.fancybox-1.3.1.pack.js"></script>
<script type="text/javascript" src="${webroot}${theme_dir}/Style/H/qjs/jquery.min.js"></script>
<script src="${webroot}${theme_dir}/Style/Js/circles.js"></script>
<style>
    .anquan ol dl ,.anquan ol dd {
        float: none;
        text-align: left;
    }
    .anquan ol dd{
        margin-left: 30px;
    }
    .tabpic a{
        display: block;
        width: 110px;
        height: 110px;
        padding: 9px;
        float: left;
    }
    .tabpic a img{
        width: 110px;
        height: 110px;
    }

    .new_add{width:148px;line-height:40px;position:relative;}
    .new_wechat_tit{float:left;margin-left:50px;}
    .new_wechat{float:left;margin:8px 0 0 5px;padding:12px;background:url(/Style/img/w_icon1.png) no-repeat;}
    .new_wechat.over{float:left;margin:8px 0 0 5px;padding:12px;background:url(/Style/img/w_icon2.png) no-repeat;}
    .h_tab_con p.sweep_wechat{width:140px;height:auto;line-height: 26px; text-indent:0; text-align:center;padding:8px;border:2px solid #949494;border-radius:10px; position:absolute;left:125px;top:-5px;background:#fff;z-index:9999;}
    .h_tab_con p.sweep_wechat .point1{display:block;width:10px;height:16px; position:absolute;left:-10px;top:15px;background:url(/Style/img/point1.png) no-repeat;}
    .h_tab_con p.sweep_wechat span{line-height:26px;font-size:14px;color:#949494;}
    .h_tab_con p.sweep_wechat span i{color:#fb6458;}
    .wrap{overflow: visible}
</style>
<script src="${webroot}${theme_dir}/Style/Js/tab.js"></script>
</head>
<body>
<div class="h_main wrap">
    <div class="fix_wrap">
        <!--月月盈-->
        <div class="h_laya">
            <h1><span class="<#if borrowinfo.stock_type == 2>h_month<#elseif borrowinfo.stock_type == 4/>h_tbao<#else>h_day</#if>"><#if borrowinfo.borrow_name?length lt 20>${borrowinfo.borrow_name}<#else>${borrowinfo.borrow_name[0..10]}...</#if></span>
                <#if borrowinfo.reward_num gt 0>
                    <i class="h_prize">奖：${borrowinfo.reward_num}%</i>
                </#if>
                <#if borrowinfo.password != ''><i class="blue_icon">定向标</i></#if><em>借款编号：${borrowinfo.id}</em></h1>
            <ul class="fl">
                <li class="h_borrow_top">
                    <span class="fl h_borrow_total"><b>借款金额</b><em><i>${borrowinfo.borrow_money}</i>&nbsp;元</em></span>
                    <span class="fl h_borrow_rate"><b>年利率</b><em>
                        <i class="red">${borrowinfo.borrow_interest_rate}</i>%</em></span>
                <span class="fl h_borrow_date"><b>借款期限</b><em><i class="red">${borrowinfo.borrow_duration}</i>
                    <#if borrowinfo.repayment_type == 1>天<#else>个月</#if>
                </em></span>
                    <span class="fl h_borrow_speed red"><div class="rote0" id="rote0"></div></span>
                </li>
                <li class="h_borrow_down">
                    <span><em>还款方式：<i>${repaytype}</i></em><em>最低投标限额：<i>${borrowinfo.borrow_min}元</i></em></span>
                    <span><em>投标奖励：<i>
                        <#if borrowinfo.reward_num gt 0>${borrowinfo.reward_num}%
                            <#else>
                            无
                        </#if>
                    </i></em><em>最高投标限额：<i><#if borrowinfo.borrow_max==0>无限制<#else>${borrowinfo.borrow_max} 元</#if></i></em></span>
                <span>


                        <em>开始招标时间：
                        	<#include "common/date.ftl"> 
                            <i>${number_to_ymdhm(borrowinfo.first_verify_time)}</i>
                        </em>
                    <em>剩余时间：
                    <i>
                        <div class="c1" id="endtime">
                            <div id="loan_time">
                                <strong>--</strong>
                                天
                                <strong>--</strong>
                                时
                                <strong>--</strong>
                                分
                                <strong>--</strong>
                                秒
                            </div>
                        </div>
                    </i>
                </em>


                </span>
                </li>
            </ul>
            <ul class="fr">
                <li class="h_arow"></li>
                <li class="h_toubiao">
                    <span><em class="fl"><b>剩余可投金额：</b><i>${borrowinfo.need}元</i></em></span>
                    <span style="padding-bottom:13px;"><em class="fl"><b>您的可用资金：</b><i class="font22">
                        <#if 1 == 1>￥0.00
                         <#else>
                            ${memberMoney.account_money + memberMoney.back_money}
                        </#if>
                    </i>元</em><a href="/Member/charge#fragment-1" class="fr">充值</a></span>
                    <#if borrowinfo.borrow_status == 3>
                        <a class="h_toubiao_btn grey">已流标</a>
                        <#elseif borrowinfo.borrow_status == 4 >
                        <a class="h_toubiao_btn grey">复审中</a>
                        <#elseif borrowinfo.borrow_status == 6>


                        <a class="h_toubiao_btn grey">还款中</a>
                        <#elseif borrowinfo.borrow_status gt 6>

                        <a class="h_toubiao_btn grey">已完成</a>
                        <#else>

                        <span class="h_submit">
                        <input class="fl" id="enter_value" placeholder="请输入投资金额" type="text"/>
                        <a id="jx_payment" class="fl" style="width:90px;" onclick="validate_enter({$vo.id});">填入可用资金</a>
                        </span>
                        <p class="jx_notice" id="jx_notice" style="width:260px;margin-top:1px"></p>
                        <span><a onclick="invest(${borrowinfo.id});" class="h_toubiao_btn">立即投标</a></span>
                    </#if>
                </li>
            </ul>
        </div>
        <!--end-->

        <!--新增活动弹窗 B-->
        <div class="h_tab1">
            <ul class="add_activity" style="width: 1068px;">
               <li style="position: relative;overflow:initial;margin-right: 55px;">
                    <span class="activity_icon">活动</span>
                    <span class="activity_con"><a href="javascript:;" onclick="showPop('#areaPop1','areaPop')" >加权投标奖，上不封顶</a></span>
                </li>
               <li style="position: relative;overflow:initial;margin-right: 55px;">
                    <span class="activity_icon">活动</span>
                    <span class="activity_con"><a href="javascript:;" onclick="showPop('#areaPop2','areaPop')" >邀请好友改版啦！现金天天奖</a></span>
                </li>
                <li>
                    <span class="activity_icon">活动</span>
                    <span class="activity_con"><a href="javascript:;" onclick="showPop('#areaPop3','areaPop')" >一马当先，一锤定音</a></span>
                </li>
                <li>
                    <span class="activity_icon">活动</span>
                    <span class="activity_con"><a href="javascript:;" onclick="showPop('#areaPop4','areaPop')" >微信投标奖励</a></span>
                </li>
                <li style="margin-right: 0">
                    <span class="activity_icon">活动</span>
                    <span class="activity_con"><a href="javascript:;" onclick="showPop('#areaPop5','areaPop')" >新手专享福利</a></span>
                </li>
            </ul>
        </div>
        <!--新增活动弹窗 B-->

        <!--tab-->
        <div class="h_tab1">
            <ul class="h_tab_tit">
                <li class="h_tab_s">借款详情</li>
                <li>投资记录</li>
            </ul>
            <div class="clear"></div>
            <div class="h_tab_con">
                <ul>
                    <li>
                        <h1><span>借款人信息</span></h1>
                        <table class="h_table">
                            <tr>
                                <th>姓名</th>
                                <th>身份证号</th>
                                <th>身份验证</th>
                            </tr>
                            <tr>
                                <td>${borrowinfo.capital_name }</td>
                                <td>${borrowinfo.capital_card!'未绑定'}</td>
                                <td><#if borrowinfo.capital_card !=''> 已通过公安身份认证</#if></td>
                            </tr>
                        </table>
                    </li>
                    <li>
                        <h1><span class="h_tabiconb">借款用途</span></h1>
                        <p>
                            本项目借款用于文化藏品（邮币卡）电子盘交易<if condition="$vo['stock_type'] eq 4">，主要用于新产品申购</if>。
                        </p>
                    </li>
                    <li>
                        <h1><span class="h_tabiconc">资金安全保障</span></h1>
                        <div style="line-height: 30px;">
                            <div class="anquan" style="padding: 0px;margin: 0px;">
                                <ol>
                                    <dl>1、已上市的邮币卡现货质押：</dl>
                                    <!-- <dd>• 经文交所专业鉴定机构评估，借款人所质押的电子现货价值<b style="color: red; font-family: "Verdana", "arial", "微软雅黑", "宋体"">{$vo['stock_bond_money']}</b>元。质押物已经办理冻结质押手续。</dd> -->
                                    <dd>• 平台借款项目的质押物都是已经公开上市的、可以电子化交易的邮币卡。邮币卡上市需经过文交所等第三方机构严格评审，评审通过后质押物的实物交由文交所监管，确保了质押物的真实性和安全性。</dd>
                                    <dd>• 手投网按照质押物发行价的约40%-60%放款，成数合理，风险可控，充分保障了本金、收益安全。</dd>
                                    <dd>• 借款人融资后所使用的交易账户是由手投网指定的，只能操盘无法提现，整个资金交易全程由手投网平台掌控，资金安全有保障。</dd>
                                </ol>
                                <ol>
                                    <dl>2、还款来源：</dl>
                                    <dd>• 手投网贷后管理部门会及时提醒借款人按期还款，并将资金转入平台向投资人还款。</dd>
                                    <dd>• 如果借款人无能力按时还款，则由平台的风险准备金先向投资人垫付，以保障投资人的权益；然后手投网按照约定对借款人的质押物进行处理。</dd>
                                </ol>
                                <ol>
                                    <dl>3、手投网风险准备金：</dl>
                                    <dd>• 风险准备金是手投网所设立的用于保障投资人利益，在借款人无法顺利还款的情况下对投资人先行垫付，是避免投资人利益损失的一项强有力的措施。</dd>
                                    <dd>• 手投网以自有资金出资100万作为风险准备金的初始资金；后续运营中，手投网会根据每月的新增待收金额，追加1%的金额到风险准备金账户。</dd>
                                </ol>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h1><span class="h_tabpic">借款资料</span></h1>
                        <div class="tabpic">
                        	<#if imgs?exists>
                            <#list imgs as vb>
                                <a rel="group" href="${vb.img}" title="${vb.img}"><img  alt="" src="http://cts.ishoutou.cn/${vb.img}" /></a>
                            </#list>
                            </#if>
                        </div>
                    </li>
                </ul>
                <ul style="display:none;">
                    <li class="h_tabl fl">
                        <table>
                            <thead>
                            <tr>
                                <th width="148">投标人</th>
                                <th width="148">投标类型</th>
                                <th width="158">投标金额</th>
                                <th width="198">投标时间</th>
                            </tr>
                            </thead>
                            <tbody  id="investrecord" class="tender-list">
                                <tr>
                                    <td  colspan="4"></td>
                                </tr>
                            </tbody>
                        </table>
                    </li>
                    <li class="h_tabr fr">
                        <table>
                            <tr><td class="font16">已投标金额</td></tr>
                            <tr><td><i class="font26">${borrowinfo.has_borrow?string('#.##')}</i>元</td></tr>
                            <tr><td height="10px">&nbsp;</td></tr>
                            <tr><td class="font16">加入人次</td></tr>
                            <tr><td><i class="font26">${borrowinfo.borrow_times!'0'}</i>人</td></tr>
                        </table>
                    </li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <!--end-->
    </div>
</div>
<div class="clear"></div>
<input id="hid" type="hidden" value="${lefttime}"/>
<script type="text/javascript"><!--
    var investmoney = 0;
    var borrowidMS = 0;
    var borrow_min = 0;
    var borrow_max = 0;
    var rand = Math.round(Math.random()*10+1); //生成1-10之间的随机数
    function PostData() {
        money = $("#enter_value").val(),    // 输入投资金额
                borrow_id = $('#borrow_id').val(),    // 投标编号
                borrow_pass = $("#borrow_pass");    // 定向标密码
        pin = $("#pin").val();

        if (borrow_pass.length && !borrow_pass.val()) {
            $.jBox.tip("请输入定向标密码");
            return false;
        }

        var flag = validate_enter();
        if (!flag) {
            return;
        }
        $.ajax({
            url: "__URL__/investcheck",
            type: "post",
            dataType: "json",
            data: {"money": money, 'borrow_id': borrow_id, "borrow_pass": borrow_pass.val(), "pin": pin},
            success: function (d) {
                if (d.status == 1) {
                    investmoney = money;
                    var content = '<div class="jbox-custom"><p>' + d.message + '</p><div class="jbox-custom-button"><span onclick="$.jBox.close()">取消</span><span onclick="isinvest(true)">确定投标</span></div></div>';
                    $.jBox(content, {title: '会员投标提示'});
                }
                else if (d.status == 2)// 无担保贷款多次提醒
                {
                    var content = '<div class="jbox-custom"><p>' + d.message + '</p><div class="jbox-custom-button"><span onclick="$.jBox.close()">取消</span><span onclick="ischarge(true)">去充值</span></div></div>';
                    $.jBox(content, {title: '会员投标提示'});
                }
                else if (d.status == 3)// 无担保贷款多次提醒
                {
                    $.jBox.error(d.message, '提示');
                } else {
                    $.jBox.error(d.message, '提示');
                }
            }
        });
    }
    // 提交支付当前要投标表单
    function isinvest(d) {
        if (d === true) document.forms.investForm.submit();
    }
    function ischarge(d) {
        if (d === true) location.href = '/member/charge#fragment-1';
    }
    $(document).ready(function () {
        ajax_show(1);
    });
    function ajax_show(p) {
        $.ajax({
                url: "investRecord",
                type: "post",
                dataType: "json",
                data: {"bid":${borrowinfo.id},"pageno":p},
                success: function(d) {
                    if (d.success) {
                        $("#investrecord").html(d.msg);
                    }
                    else{
                    	$("#investrecord").html("无");
                    }
                }
            });
    }

    function showht() {
        var status = '{$invid}';
        if (status == "no") {
            $.jBox.error("您未投此标");
        } else if (status == "login") {

            $.jBox.error("请先登录");
            window.location.href = "__APP__/member/common/login.html";
        } else {
            window.location.href = "__APP__/member/agreement/downfile?id=" + status;
        }
    }

    var seconds;
    var pers = ${progres}/100;
    var timer = null;
    function setLeftTime() {
        seconds = parseInt($("#hid").val(), 10);
        timer = setInterval(showSeconds, 1000);
    }

    function showSeconds() {
        var day1 = Math.floor(seconds / (60 * 60 * 24));
        var hour = Math.floor((seconds - day1 * 24 * 60 * 60) / 3600);
        var minute = Math.floor((seconds - day1 * 24 * 60 * 60 - hour * 3600) / 60);
        var second = Math.floor(seconds - day1 * 24 * 60 * 60 - hour * 3600 - minute * 60);
        if (day1 < 0) {
            clearInterval(timer);
            $("#endtime").html("投标已经结束！");
            $("#endtime").next().remove();
        } else if (pers >= 1) {
            clearInterval(timer);
            $("#endtime").html("投标已经结束！");
            $("#endtime").next().remove();
        } else {
            $("#loan_time").html("<strong>" + day1 + "</strong> 天 <strong>" + hour + "</strong> 时 <strong>" + minute + "</strong> 分 <strong>" + second + "</strong> 秒");
        }
        seconds--;
    }
    if (pers >= 1) {
        $("#endtime").html("投标已经结束！");
        $("#endtime").next().remove();
    } else {
        setLeftTime();
    }
    var _validate_enter_flag = false;
    function invest(id) {
        var flag = validate_enter(), num = $('#enter_value').val();
        if (!_validate_enter_flag || !flag) {
            return;
        }
        $.get("__URL__/ajax_invest", {'id': id, 'num': num},
                function (msg) {
                    if (msg.status == 1) {
                        $.jBox("get:__URL__/ajax_invest?id=" + id + '&num=' + num, {title: "立即投资"});
                    }else if (msg.status == 2) {
                         var notice = document.getElementById('jx_notice');
                          notice.innerHTML = '请把机会留给新手吧！';
                          notice.className = 'jx_notice jx_error';
                    }else{
                        $.jBox.error(msg.message, '提示');
                    }
                }, "json"
        );

    }

    function validate_enter() {

        var getId = function (ele) {
            return document.getElementById(ele);
        }, need_max = ${borrowinfo.needc?c},
    allow_max = (${borrowinfo.borrow_max?c} == 0 ? need_max : ${borrowinfo.borrow_max?c}),
    allow_min = ${borrowinfo.borrow_min?c},
    notice = getId('jx_notice'), owner = getId('enter_value'), payment = getId('jx_payment');

    if (!owner) {
        return null; // 在金额输入框为禁用状态
    }
    else {
        value = owner.value;
    }

    if (isNaN(value)) { // 不是数字
        notice.innerHTML = '投资金额不正确，默认最小投资金额！'
        notice.className = 'jx_notice jx_error';
        //payment.className = 'jx_payment';
        owner.value = need_max;
        _validate_enter_flag = false;
    }
    else {
        //if (int % allow_min != 0) {
        if (!value) {
            //notice.innerHTML = '投资金额为起投金额的整数倍！'
            notice.className = 'jx_notice jx_error';
            owner.value = need_max;
            _validate_enter_flag = false;
        } else {
            if (value > allow_max || value > need_max) {
                if(${borrowinfo.borrow_max?c} == 0 || value > need_max){
                    notice.innerHTML = '最多可投'+ (value > need_max ? need_max : allow_max);
                }else{
                    notice.innerHTML = '最大投资限额'+allow_max;
                }
                notice.className = 'jx_notice jx_error';
                owner.value = need_max;
                _validate_enter_flag = false;
            } else if (value < allow_min) {
                notice.innerHTML = '最小投资限额'+allow_min
                notice.className = 'jx_notice jx_error';
                owner.value = need_max;
                _validate_enter_flag = false;
            }
            else {
                _validate_enter_flag = true;
                notice.className = 'jx_notice jx_success';
                notice.innerHTML = '输入正确！';
                //payment.className = 'jx_payment';
            }
        }
    }

    return _validate_enter_flag;
    }
    function contract() {
        $.get('__URL__/contract', function (html) {
            $.artDialog({
                title: '操盘协议',
                lock: true,
                content: html,
                okVal: '我已阅读',
                ok: true,
                padding: '0px 0px'
            });
        });
    }
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
            }, 5)
        }

        $(".rote").each(function (index, element) {
            //loadImg($(element), {$vo.progress});
    });
    })

   
</script>

<!--弹出层 开始-->
<div class="popWrap" id="areaPop1">
    <iframe class="popIframe" scrolling="0" frameborder="0"></iframe>
    <div class="popWrap_sub"></div>
    <div class="popBox">
        <h3>加权投标奖，上不封顶<a href="javascript:;" class="popClose" title="关闭" onclick="hidePop('#areaPop1','areaPop')"></a></h3>
        <div class="areaList">
            <p>3月16日 至 4月30日：</p>
            <p>（1）加权投标奖励分三个统计周期，您有3次机会冲击榜首。</p>
            <p>（2）加权投标前十名可获得统计周期内投标总额0.1%-0.2%的现金奖励。</p>
            <p>（3）投的多，奖的多，上不封顶。
            </p>
            <p><a href="/freestock/index#actOne" target="_blank">查看详情</a></p>
        </div>
    </div>
</div>
<div class="popWrap" id="areaPop2">
    <iframe class="popIframe" scrolling="0" frameborder="0"></iframe>
    <div class="popWrap_sub"></div>
    <div class="popBox">
        <h3>邀请好友改版啦！现金天天奖<a href="javascript:;" class="popClose" title="关闭" onclick="hidePop('#areaPop2','areaPop')"></a></h3>
        <div class="areaList">
            <p>3月16日 至 4月30日：</p>
            <p>（1）首次奖：好友首次投标，最高奖您200元！</p>
            <p>（2）天天奖：只要好友有待收，您天天有奖励，上不封顶！</p>
            <p><a href="/freestock/index#actTwo" target="_blank">查看详情</a></p>
        </div>
    </div>
</div>
<div class="popWrap" id="areaPop3">
    <iframe class="popIframe" scrolling="0" frameborder="0"></iframe>
    <div class="popWrap_sub"></div>
    <div class="popBox">
        <h3>一马当先，一锤定音<a href="javascript:;" class="popClose" title="关闭" onclick="hidePop('#areaPop3','areaPop')"></a></h3>
        <div class="areaList">
            <p>3月16日 至 4月30日：</p>
            <p>第一个投标人，奖励投标金额的1‰；</p>
            <p>最后一个投标人（满标），奖励投标金额的1‰</p>
            <p><a href="/freestock/index#actThree" target="_blank">查看详情</a></p>
        </div>
    </div>
</div>
<div class="popWrap" id="areaPop4">
    <iframe class="popIframe" scrolling="0" frameborder="0"></iframe>
    <div class="popWrap_sub"></div>
    <div class="popBox">
        <h3>微信投标奖励<a href="javascript:;" class="popClose" title="关闭" onclick="hidePop('#areaPop4','areaPop')"></a></h3>
        <div class="areaList">
            <p>3月16日 至 4月30日：</p>
            <p>（1）关注手投网微信号，微信注册领100元红包</p>
            <p>（2）首次使用微信投标，奖励投标金额的2‰</p>
            <p><a href="/freestock/index#actFour" target="_blank">查看详情</a></p>
        </div>
    </div>
</div>
<div class="popWrap" id="areaPop5">
    <iframe class="popIframe" scrolling="0" frameborder="0"></iframe>
    <div class="popWrap_sub"></div>
    <div class="popBox">
        <h3>新手专享福利<a href="javascript:;" class="popClose" title="关闭" onclick="hidePop('#areaPop5','areaPop')"></a></h3>
        <div class="areaList">
            <p>3月16日 至 4月30日：</p>
            <p>注册后未投资过的用户，都可投资新手专享标</p>
            <p>期限7天、年利率10%、奖励8‰</p>
            <p>100元起投，最高限额2000元</p>
            <p><a href="/freestock/index#actFive" target="_blank">查看详情</a></p>
        </div>
    </div>
</div>
<!--弹出层 结束-->

<!--背景遮罩层 开始-->
<iframe id="bgIframe" class="bgIframe" frameborder="0"></iframe>
<div id="bgDiv" class="bgDiv"></div>
<!--背景遮罩层 结束-->

<script>
    //通用弹出层触发动作 begin
    function showPop(id,className){
        $(".bgIframe").css({
            "filter":"alpha(opacity=0)",
            "opacity":"0"
        });
        $(".bgDiv").css({
            "filter":"alpha(opacity=50)",
            "opacity":"0.5"
        });
        $(id).addClass(className).fadeIn(10,function(){
            var popHeight = $(''+id+'.popWrap,'+id+' .popWrap_sub,'+id+' .popIframe');
            var h=$(''+id+' .popBox').height();//获取高度
            popHeight.height(h+12);
            $(".bgIframe,.bgDiv").fadeIn(200);
        });
        return false;
    }

    //关闭弹层窗口
    function hidePop(id,className){
        $(''+id+',.bgIframe,.bgDiv').fadeOut(function(){
            $(this).removeClass(className);
            $(''+id+'.popWrap,'+id+' .popWrap_sub,'+id+' .popIframe').height('');
        })
    }
    //---------- end

</script>
<script>
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
   arr.push(${progres});
	
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
<#include "include/footer.ftl" /> 
</html>