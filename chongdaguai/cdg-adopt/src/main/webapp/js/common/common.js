/**
 * Created by zhenghao on 2018/2/3.
 */
// var baseHost = "http://adopt.chongxiaoguai.com/adopt/";
var baseHost = "http://localhost:8080/";
//var baseHost = "http://adopt.chongxiaoguai.com/adopt/";

//公共变量token
var commonToken ="";


function footer() {
    var footer = document.getElementById("footer");
    var footerContent = "<div class='footer'> <ul id='footer_ul'>"
        + "<li class='cur'><a href='homepage.html'><i><img id='foot1' src='images/foot_01.png'></i><span>首页</span></a></li>"
        + "<li><a href='#'><i><img id='foot2' src='images/foot_2.png'></i><span>消息</span></a></li>"
        + "<li><a href='#'><i><img id='foot3' src='images/foot_3.png'></i><span>发现</span></a></li>"
        + "<li><a href='#'><i><img id='foot4' src='images/foot_4.png'></i><span>圈儿</span></a></li>"
        + "<li id='mine_footer'><a href='mine.html'><i><img id='foot5' src='images/foot_5.png'></i><span>我的</span></a></li> </ul> </div>"
    footer.innerHTML = footerContent;
}

function setToken(token){
    // sessionStorage.setItem("userKey1","liweizhongTest1");
    commonToken = token;
    localStorage.setItem("accessToken", token);
}

function getToken(){
    // var site = localStorage.getItem("userKey2");
    var site = localStorage.getItem("accessToken");
    return site;
}
