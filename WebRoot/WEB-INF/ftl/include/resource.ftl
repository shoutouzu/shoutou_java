<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    -->
    <!--shoutou -->
    <title>${web_title!"借贷网 - p2p网络借贷平台_安全可靠的网贷平台"}</title>
    <link type="text/css" rel="stylesheet" href="${webroot}${theme_dir}/Style/H/qcss/y_style.css"/>
    <script type="text/javascript" src="${webroot}${theme_dir}/Style/H/qjs/jquery.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="ie-comp">
    <meta name="viewport"content="width=1100, initial-scale=0.9"/>
    <link rel="Shortcut icon" href="${webroot}${theme_dir}/Style/H/images/ico.png"/>
    <meta name="renderer" content="ie-stand">
    <link rel="stylesheet" type="text/css" href="${webroot}${theme_dir}/Style/H/css/index.css" />
    <link rel="stylesheet" type="text/css" href="${webroot}${theme_dir}/Style/H/css/css.css" />
    <link rel="stylesheet" type="text/css" href="${webroot}${theme_dir}/Style/H/css/kefu.css" />
    <link rel="stylesheet" type="text/css" href="${webroot}${theme_dir}/Style/H/css1/style.css" />
    <link type="text/css" rel="stylesheet" href="${webroot}${theme_dir}/Style/JBox/Skins/Currently/jbox.css"/>
    <link rel="stylesheet" type="text/css" href="${webroot}${theme_dir}/Style/H/css/style.css" />

    <link rel="stylesheet" type="text/css" href="${webroot}${theme_dir}/Style/Stock/css/index.css">
    <link rel="stylesheet" type="text/css" href="${webroot}${theme_dir}/Style/Stock/css/style.css">
    <script type="text/javascript" src="${webroot}${theme_dir}/Style/H/js/jquery.min.js"></script>
    <script type="text/javascript" src="${webroot}${theme_dir}/Style/Js/jquery.js"></script>
    <script  src="${webroot}${theme_dir}/Style/JBox/jquery.jBox.min.js" type="text/javascript"></script>
    <script  src="${webroot}${theme_dir}/Style/JBox/jquery.jBoxConfig.js" type="text/javascript"></script>
    <script type="text/javascript" src="${webroot}${theme_dir}/Style/Js/utils.js"></script>
    <script language="javaScript" type="text/javascript" src="${webroot}${theme_dir}/Style/H/js/backtotop.js"></script>
    <script src="${webroot}${theme_dir}/Style/Stock/js/jquery.darktooltip.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${webroot}${theme_dir}/Style/artDialog/jquery.artDialog.source.js?skin=blue"></script>
    <script src="${webroot}${theme_dir}/Style/H/js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        var browser=navigator.appName;
        var b_version=navigator.appVersion;
        var version=b_version.split(";");
        if(version.length>1) var trim_Version=version[1].replace(/[ ]/g,"");

        if(browser=="Microsoft Internet Explorer" && (trim_Version=="MSIE5.0" || trim_Version=="MSIE6.0"))
            alert("您正在使用的浏览器版本过低，有些网站效果会显示不出来，建议升级后再使用本网站。");

        function makevar(v){
            var d={};
            for(i in v){
                var id = v[i];
                d[id] = $("#"+id).val();
                if(!d[id]) d[id] = $("input[name='"+id+"']:checked").val();
                if(!d[id]) d[id] = $("input[name='"+id+"']").val();
                if(typeof d[id] == "undefined") d[id] = "";
            }
            return d;
        }
        function addBookmark(title, url) {
            if (window.sidebar) {
                window.sidebar.addPanel(title, url, "");
            }
            else if (document.all) {
                window.external.AddFavorite(url, title);
            }
            else if (window.opera && window.print) {
                return true;
            }
        }
        function SetHome(obj, vrl) {
            try {
                obj.style.behavior = 'url(#default#homepage)'; obj.setHomePage(vrl);
                NavClickStat(1);
            }
            catch (e) {
                if (window.netscape) {
                    try {
                        netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                    }
                    catch (e) {
                        alert("抱歉！您的浏览器不支持直接设为首页。请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为“true”，点击“加入收藏”后忽略安全提示，即可设置成功。");
                    }
                    var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                    prefs.setCharPref('browser.startup.homepage', vrl);
                }
            }
        }

        // 修复 IE 下 PNG 图片不能透明显示的问题
        function fixPNG(myImage) {
            var arVersion = navigator.appVersion.split("MSIE");
            var version = parseFloat(arVersion[1]);
            if ((version >= 5.5) && (version < 7) && (document.body.filters))
            {
                var imgID = (myImage.id) ? "id='" + myImage.id + "' " : "";
                var imgClass = (myImage.className) ? "class='" + myImage.className + "' " : "";
                var imgTitle = (myImage.title) ? "title='" + myImage.title   + "' " : "title='" + myImage.alt + "' ";
                var imgStyle = "display:inline-block;" + myImage.style.cssText;
                var strNewHTML = "<span " + imgID + imgClass + imgTitle

                        + " style=\"" + "width:" + myImage.width

                        + "px; height:" + myImage.height

                        + "px;" + imgStyle + ";"

                        + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"

                        + "(src=\'" + myImage.src + "\', sizingMethod='scale');\"></span>";
                myImage.outerHTML = strNewHTML;
            } }


    </script>
</head>