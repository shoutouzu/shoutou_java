<style>
.zixunbox {
    background: none repeat scroll 0 0 #fff;
    left: 50%;
    margin-left: -116px;
    margin-top: -256px;
    position: fixed;
    top: 50%;
    z-index: 1004;
}



.zixunbox ul li {
    border-bottom: 1px dashed #c8c8c8;
    height: 47px;
    line-height: 47px;
    margin: 0 20px;
    overflow: hidden;
}
.zixunbox .over_icon{
	background-image:url("${webroot}${theme_dir}/Style/H/images/over_icon.png");

    height: 21px;
    position: absolute;
    right: -10px;
    top: -10px;
    width: 20px;
    z-index: 1003;
}

.zixunbox ul li a {
    background-image: url("${webroot}${theme_dir}/Style/H/images/qq_icon.png");
	background-repeat:no-repeat;
	background-position:0px center;
    color: #858585;
    display: inline-block;
    height: 47px;
    text-indent: 20px;
    width: 92px;
}
.zixunbox p {
    background: url("${webroot}${theme_dir}/Style/H/images/dianh.png");
	background-repeat:no-repeat;
	background-position:40px center;
    color: #2382ba;
    font-size: 16px;
    padding-bottom: 20px;
    padding-left: 30px;
    padding-top: 20px;
    text-align: center;
}
.zixunbox h3 {
    margin-bottom: 10px;
    margin-top: 20px;
    text-align: center;
}
.zixunbox span {
    display: block;
    padding-bottom: 20px;
    
    text-align: center;
}

</style>
<!--导航-->

<div class="top">
	<div class="top_main">
    	<span class="top_l"><img src="${webroot}${theme_dir}/Style/H/qimages/phone.png"/>客服热线：400-047-5588&nbsp;&nbsp;(工作日9:00-18:00)</span>
        <span class="top_r">
			<a   href="/help/help" >帮助中心</a>
		<a  href="member/index" style="color:#ff9900;" >Admin</a>&nbsp;&nbsp; 
				<a   href="/member/msg#fragment-1" >消息(0)</a>
				<a  href="/Member/common/actlogout" >退出</a></span>
    </div>
</div>
  <div class="nav">
	<div class="nav_main">
    	<div class="logo"><a href="${webroot}"><img alt="" style="float:none;margin:0px;" src="http://cts.ishoutou.cn//UF/Uploads/Article/20150717164251.jpg"></a> </div>
        <div class="nav_list">
        	<div id="topnavbar" style="display: block;">
              <div id="topnanv">
			  <div class="my_zh">
        	</div>
			
			 <div class="defu"> <a href="${webroot}/index.html">首页</a> </div>
                <div class="defu"> <a href="${webroot}/freestock/index" target="_blank">热销活动</a> </div>
                <div id="anvlfteb">
                  <div selec="bbs" class="posbox"> <a href="${webroot}/invest/index">我要理财</a> <i></i></div>
                  <div  class="defu"><a href="${webroot}/capital/index">我要融资</a> <i></i></div>
				   <div class="defu"> <a href="${webroot}/Help/novice" target="_blank">新手指引</a> </div>
                <!--   <div selec="post" class="posbox"><a href="/Help/novice">新手指引</a> <i></i></div> -->
                  <div selec="youhui" class="posbox"><a href="${webroot}/aboutus/jianjie.html">关于我们</a> <i></i></div>
                  <div id="seledbox" class="posiabox" style="display: none; left: 1px;">
                  </div>
                </div>
              </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

/* 导航 */
$(function(){
	var $anvlfteb=$('#anvlfteb'),
		$posbox=$anvlfteb.find('div.posbox'),
		$seledbox=$("#seledbox"),
		anvjson={
			bbs:'<a href="/invest/index?type=search&&stock_type=1">天天盈</a>'+
				'<a href="/invest/index?type=search&&stock_type=2">月月盈</a>'+
				'<a href="/invest/index?type=search&&stock_type=4">打新宝</a>'+
                '<a href="/debt/index">债权转让</a>',
				//'<a href="/debt/index">债权转让</a>',
        	news:'<a href="/daystock/index">按天融资</a>'+
				'<a href="/Monthstock/index">按月融资</a>'+
				'<a href="/Imtrader/index">我是操盘手</a>',
        	 post:'<a href="/Help/novice">新手指引</a>',
			youhui:'<a href="/aboutus/jianjie.html">公司简介</a>'+
			'<a href="/aboutus/anquan.html">安全保障</a>'+
			'<a href="/aboutus/tdjs.html">团队介绍</a>'+
			'<a href="/aboutus/zizhi.html">证件资质</a>'+
			'<a href="/aboutus/licheng.html">发展历程</a>'+
			'<a href="/aboutus/lianxi.html">联系我们</a>'+
			'<a href="/aboutus/yingcai.html">诚聘英才</a>'+
			'<a href="/aboutus/partner.html">合作伙伴</a>'
		};
		 

		$posbox.mouseover(function(){
			var i=$(this).index();
			$(this).addClass("anvh").siblings().removeClass("anvh");
			var selec=$(this).attr("selec");
			if($seledbox.is(":hidden")){
				$seledbox.show().css("left",100*i+1).html("<div>"+anvjson[selec]+"</div>")
			}else{
				$seledbox.stop().animate({left:100*i+1},200,function(){
					$("#seledbox").html("<div>"+anvjson[selec]+"</div>")
				})
			}
		});
		$anvlfteb.mouseleave(function(){
			$seledbox.hide();
			$posbox.removeClass("anvh");
		})
})

/*微博二维码显示效果*/

$(document).ready(function() {
 	$(".footer .footerC .guanzhu span a").hover(function() {
 		$(this).children('img').show()
 	}, function() {
 		$(this).children('img').hide()
 	});

 })

</script>
<script type="text/javascript">

    var dl_num=$(".header .main dl").length;
    for(var i=0;i<dl_num;i++){
        var dd_num=$(".header .main dl:eq("+i+") dd").length;
        if(dd_num<=1){
            $(".header .main dl:eq("+i+") dd").remove();
            $(".header .main dl:eq("+i+") dt em").remove();
        }
    }

</script>


<script type="text/javascript">
    function bodyTop(){
        $("html,body").animate({
            scrollTop:"0px"
        },1000);
    }
	$(".header .main .fr dl dd").css("float","none");
</script>
<script type="text/javascript">
$(function(){
	$(".kefu").click(function(){
		$(".zixunbox").fadeIn("slow");
		$(".body_box").fadeIn("slow");
	});
	$(".liuyan").click(function(){
		$(".liuy_box").fadeIn("slow");
		$(".body_box").fadeIn("slow");
	});
	
	$(".over_icon").click(function(){
		$(".zixunbox").fadeOut("slow");
		$(".body_box").fadeOut("slow");
		$(".liuy_box").fadeOut("slow");
	});
	
	$(".over_cionn").click(function(){
		$(".video").fadeOut("slow");
	});
});

    $(".header .fr dl").hover(function(){
        $(".header .fr dl dd").stop();
        $(".header .fr dl dd").hide();
        $(this).children("dd").fadeIn(500);
    },function(){
        $(this).children("dd").fadeOut(500);
    });
$(window).scroll(function(){
    var topnum=$(window).scrollTop();
    if(topnum>510){
        $(".header").addClass("header-on");
    }else{
        $(".header").removeClass("header-on");
    }
});
</script>



<div class="float-box"></div>
<script type="text/javascript">
    var w_width= $(window).width();
    $(window).resize(function(){
        w_width= $(window).width();
        fix_hie(w_width);
    });
    function fix_hie(w_wid){
        if(w_wid<1340){
            $("body").addClass("body-small");
            $(".float-login").fadeOut(500);
        }else{
            $("body").removeClass("body-small");
            $(".float-login").fadeIn(500);

        }
    }
    fix_hie(w_width);

    $(".float-box").click(function(){
        if($(".float-login").css("display")=="none"){
            $(".float-login").fadeIn(500);
        }else{
            $(".float-login").fadeOut(500);
        }
    });
</script>



<!--页眉end-->