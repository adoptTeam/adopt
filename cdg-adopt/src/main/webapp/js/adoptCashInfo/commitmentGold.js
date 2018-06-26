/**
 * Created by whp on 2018/2/8.
 */
$(function () {
    var url=baseHost+"weixin/getPersonCashInfo"
    $.ajax({
        url:url,
        headers:{"token":getToken()},
        dataType:"json",
        success:function(res){
            if (res.code == "10000" || res.msg == "ok" || res.data == "true") {
                var data = res.data;
                if (data != null) {
                    var li= "";
                    for(var i=0;i<data.length;i++){
                        if(data[i].amountState==0){
                            li+='<li><i><img src="images/ic_12.png"></i><span>'
                                +'缴纳体验承诺金'
                                +'<em>'+timestampToTime(data[i].createTime)+'</em></span><b class="cur">+300.00</b></li>';
                        }else if(data.amountState==2){
                            li+='<li><i><img src="images/ic_10.png"></i><span>'
                                +'体验退还<em>'+timestampToTime(data[i].createTime)+'</em></span><b>-300.00</b></li>'
                        }
                    }
                    $('#commitmentGold').html(li);
                    /*if(data[0].amountState==0){
                        $('#capitalState').html("已缴纳：");
                    }else{
                        $('#capitalState').html("退款中：");
                    }*/
                    if(data[0].amountState==0){
                        $('#capitalCash').html("300.00");
                    }else{
                        $('#capitalCash').html("0.00");
                    }
                } else {
                    $('#capitalCash').html("0.00");
                    layer.alert("暂无交易信息")
                }
            } else {
                $('#capitalCash').html("0.00");
                layer.alert("系统错误");
            }
        }, error:function(){
            $('#capitalCash').html("0.00");
            layer.alert("出错啦！" + res.msg);
        }
    })
})