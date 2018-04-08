<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Hello Welcome To locaBack.xml</title>
    <script src="<%=path%>/js/jquery-3.3.1.min.js"></script>
    <style>
        .overAnner {
            top: 0;
            position: fixed;
            width: 100%;
            opacity: .9;
            background-color: #000;
            display: block;
            z-index: 100000;
            height: 45px;
        }

    </style>

</head>


<body>
<h1 style="position: absolute;left: 100px;top: 50px;">欢迎来到logbackSSM整合页面</h1>
<div class="overAnner">
    <a href="javascript:void(0)" id="wxggalink" onclick="tok()" style="display: block;width: 100%;height: 100%;">
        <img src="http://www.360doc.cn/images/Document/zhaishou_1.png" style="width: 55px;position: absolute;left: 8px;top: 0px;" />
        <span class="pic"><img src="http://www.360doc.cn/images/Document/zhaishou_2.png" style="width: 153px;position: absolute;left:73px;top: 0;"/><img src="http://www.360doc.cn/images/Document/zhaishou_3.png" style="width: 65px;top: 0;right: 15px;position: absolute;"/></span><span class="pic"><img src="http://www.360doc.cn/images/Document/zhaishou_2_2.png" style="width:192px;position: absolute;top: 0;left: 73px;" /></span>
    </a>
</div>


</body>
<script>



    function setOuserDataWidth() {
        var btnw = $('.btn2s').width(), oother = $('#ouser_data').parent().width(), upw = $('#userphotohtml img').outerWidth(true);
        $('#ouser_data').width(oother - upw - btnw - 10)
    }
    $('#arttopfloat').width($(window).width() < 320 ? 320 : $(window).width());
    setOuserDataWidth();
    $(window).resize(function () {
        $('#arttopfloat').width($(window).width() < 320 ? 320 : $(window).width());
        setOuserDataWidth();
    });
    function closecurrentwindow(t) {
        if (t.href != null && t.href.toString().indexOf("history.go") == -1) {

            return;
        }
        if (history.length <= 1) {
            try {

                window.close();
            } catch (err) {
                console.log(err.toLocaleString());
            }
        }
    }
    // $(document).ready(function () {
    //     $(window).scroll(function () {
    //         var str = $(document).scrollTop();
    //         if (str > $(window).height()) {
    //             $('.backtop').show()
    //         } else {
    //             $('.backtop').hide()
    //
    //         }
    //     })
    //
    // });



    <!--- 1111111111111111111111111111111111111111111111111111111111111111111111-->

    function tok() {
        window.location.href = "http://www.360doc.cn/kehuduan.aspx";
    }

    var index = 1;
    var $_picn = $(".pic").length;
    if ($_picn > 1) {

        $(".pic").eq(0).show().siblings(".pic").hide();
    }

    function show(index) {

        $(".pic").eq(index).show().siblings(".pic").hide();
    }


    function setone() {
        var t = setTimeout(function () {
            show(1);
            clearTimeout(t);
            settwo();
        }, 3000);
    }

    function settwo() {
        var t = setTimeout(function () {
            show(0);
            clearTimeout(t);
            setone();
        }, 4000);
    }

    setone();

    function closeartnew() {

        document.getElementById("artnewdiv").style.display = "none";
        setCookie("guanggao", "idx", 1);
    }


</script>
</html>
