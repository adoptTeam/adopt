// JavaScript Document
/*var intDiff = parseInt(30000);//倒计时总秒数量
function timer(intDiff){
	window.setInterval(function(){
	var day=0,
		hour=0,
		minute=0,
		second=0;//时间默认值		
	if(intDiff > 0){
		day = Math.floor(intDiff / (60 * 60 * 24));
		hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
		minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
		second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
	}
	if (minute <= 9) minute = '0' + minute;
	if (second <= 9) second = '0' + second;
	$('.day_show').html(day+"0");
	$('.hour_show').html('<s id="h"></s>'+hour+'');
	$('.minute_show').html('<s></s>'+minute+'');
	$('.second_show').html('<s></s>'+second+'');
	intDiff--;
	}, 1000);
} 

$(function(){
	timer(intDiff);
});*/


function lxfEndtime(){
	var endtime = new Date($("#time").attr("endtime")).getTime();//取结束日期(毫秒值)
	var nowtime = new Date().getTime();        //今天的日期(毫秒值)
	var youtime = endtime-nowtime;//还有多久(毫秒值)
	var seconds = youtime/1000;
	var minutes = Math.floor(seconds/60);
	var hours = Math.floor(minutes/60);
	var days = Math.floor(hours/24);
	var CDay= days;
	var CHour= hours % 24;
	var CMinute= minutes % 60;
	var CSecond= Math.floor(seconds%60);//"%"是取余运算，可以理解为60进一后取余数，然后只要余数。
	if(endtime<=nowtime){
		$("#time").html("已过期")//如果结束日期小于当前日期就提示过期啦
	}else{
		$("#time").html("下期开始：<span class='hour_show'>"+CHour+"</span> 小时<span class='minute_show'>"+CMinute+"</span> 分<span class='second_show'>"+CSecond+"</span> 秒");
	}
	setTimeout("lxfEndtime()",1000);
};
$(function(){
	lxfEndtime();
});


function lxfEndtimet(){
	var endtime = new Date($("#timet").attr("endtime")).getTime();//取结束日期(毫秒值)
	var nowtime = new Date().getTime();        //今天的日期(毫秒值)
	var youtime = endtime-nowtime;//还有多久(毫秒值)
	var seconds = youtime/1000;
	var minutes = Math.floor(seconds/60);
	var hours = Math.floor(minutes/60);
	var days = Math.floor(hours/24);
	var CDay= days;
	var CHour= hours % 24;
	var CMinute= minutes % 60;
	var CSecond= Math.floor(seconds%60);//"%"是取余运算，可以理解为60进一后取余数，然后只要余数。
	if(endtime<=nowtime){
		$("#timet").html("已过期")//如果结束日期小于当前日期就提示过期啦
	}else{
		$("#timet").html("<span class='hour_show'>"+CHour+"</span> 小时<span class='minute_show'>"+CMinute+"</span> 分<span class='second_show'>"+CSecond+"</span> 秒");
	}
	setTimeout("lxfEndtimet()",1000);
};
$(function(){
	lxfEndtimet();
});