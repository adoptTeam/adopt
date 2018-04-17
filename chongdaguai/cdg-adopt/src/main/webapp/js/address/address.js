//var host = "http://localhost:8080/system/"

var token = localStorage.getItem("accessToken");
//var token = "";

$(document).ready(function () {
    //区分是从那个入口 进入添加地址页面
    var addFlag = location.search.substring(1).split("=")[1];
    if (addFlag != null && addFlag != undefined) {
        document.getElementById("addFlag").value = addFlag;
    }

    //var host = "http://localhost:8080/system/"
    var url = baseHost + "system/getAddress";
    var b = $("#province option:first").text();
    $("#province").html('<option>' + b + '</option>');
    var ajax = $.ajax({
        type: "POST",
        headers: {"token": token},
        url: url,
        data: {
            "type": "0"
        },
        success: function (result) {
            console.log(result);
            $.each(result.data, function (i) {
                $("#province").append("<option value='" + i + "'>" + result.data[i] + "</option>");
            });
        }
    });

    //点击编辑进入此页面
    var addressId = location.search.substring(1).split("=")[1];
    if (addressId != null && addressId != 'addFlag') {
        var editUrl = baseHost + "userAddress/getUserAddressInfo?addressId=" + addressId;
        var ajax = $.ajax({
            headers: {"token": token},
            type: "get",
            url: editUrl,
            success: function (result) {
                //填充
                $("#addressId").val(addressId);
                $("#name").val(result.data.consigneeName);
                $("#tel").val(result.data.consigneePhone);
                $("#province").find("option:contains(" + result.data.province + ")").attr("selected", true);
                //getCity();
                $("#city").append("<option selected='selected'>" + result.data.city + "</option>");
                getEityArea(result.data.areas);
                $("#area").append("<option selected='selected'>" + result.data.areas + "</option>");
                $("#addressInfo").val(result.data.address)

            }
        });
    }

});

function getCity() {
    var b = $("#city option:first").text();
    $("#city").html('<option>' + b + '</option>');
    var url = baseHost + "system/getAddress";
    var ajax = $.ajax({
        type: "POST",
        headers: {"token": token},
        url: url,
        data: {
            "type": "1",
            "par": $("#province").find("option:selected").text()
        },
        success: function (result) {
            console.log(result);
            $.each(result.data, function (i) {
                $("#city").append("<option value='" + i + "'>" + result.data[i] + "</option>");
            });
        }
    });
}
function getArea() {

    var url = baseHost + "system/getAddress";

    var b = $("#area option:first").text();

    $("#area").html('<option>' + b + '</option>');

    var ajax = $.ajax({
        type: "POST",
        headers: {"token": token},
        url: url,
        data: {
            "type": "2",
            "par": $("#city").find("option:selected").text()
        },
        success: function (result) {
            console.log(result);
            $.each(result.data, function (i) {
                $("#area").append("<option value='" + i + "'>" + result.data[i] + "</option>");
            });
        }
    });
}
//编辑地址的时候使用
function getEityArea(selectedArea) {

    var url = baseHost + "system/getAddress";

    var b = $("#area option:first").text();

    $("#area").html('<option>' + b + '</option>');

    var ajax = $.ajax({
        type: "POST",
        headers: {"token": token},
        url: url,
        data: {
            "type": "2",
            "par": $("#city").find("option:selected").text()
        },
        success: function (result) {
            var temp = result.data;
            removeByValue(temp, selectedArea)
            $.each(temp, function (i) {
                $("#area").append("<option value='" + i + "'>" + result.data[i] + "</option>");
            });
        }
    });
}
function removeByValue(arr, val) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == val) {
            arr.splice(i, 1);
            break;
        }
    }
}

//增加地址
function addUserAddress() {
    var url = baseHost + "userAddress/";
    var addressId = $("#addressId").val()
    if (addressId != null && addressId != "") {
        url = url + "updateAdoptUserAddress";
    } else {
        url = url + "addUserAddress";
    }
    var addressId = $("#addressId").val()
    var consigneeName = $("#name").val();
    var consigneePhone = $("#tel").val();
    var province = $("#province").find("option:selected").text();
    var city = $("#city").find("option:selected").text();
    var areas = $("#area").find("option:selected").text();
    var address = $("#addressInfo").val()
    //判空
    if (isEmpty(consigneeName)) {
        layer.alert("请输入收货人姓名！");
        return;
    }
    if (isEmpty(consigneePhone)) {
        layer.alert("请输入收货人电话！");
        return;
    }
    if (!saveCheckMobile(consigneePhone)) {
        alert(1);
        layer.open({
            title: '提示',
            content: '请填写正确的电话号码'
        });
        return;
    }
    if (isEmpty(province)) {
        layer.alert("请选择所在省！");
        return;
    }
    if (isEmpty(city)) {
        layer.alert("请选择所在市！");
        return;
    }
    if (isEmpty(areas)) {
        layer.alert("请选择所在区！");
        return;
    }
    if (isEmpty(address)) {
        layer.alert("请输入详细地址！");
        return;
    }


    var ajax = $.ajax({
        type: "POST",
        headers: {"token": token},
        url: url,
        data: {
            "userAddressId": addressId,
            "consigneeName": consigneeName,
            "consigneePhone": consigneePhone,
            "province": province,
            "city": city,
            "areas": areas,
            "address": address
        },
        success: function (result) {
            var addFlag = document.getElementById("addFlag").value;
            if (addFlag == 'addFlag') {
                window.location.href = "adoptConfirm.html?addressId=" + result.data;
            } else {
                window.location.href = "addressList.html";
            }


        }
    });

}
//删除地址
function delUserAddress() {
    var url = baseHost + "userAddress/delUserAddress";
    var ajax = $.ajax({
        type: "POST",
        headers: {"token": token},
        url: url,
        data: {
            "addressId": $("#addressId").val()

        },
        success: function (result) {
            window.location.href = "addressList.html";
        }
    });
}

//返回
function back() {
    window.history.back(-1);
}

//控制输入框的输入长度
function checkLength(filed) {
    var value = filed.value;
    if (value.length < 2 || value.length > 10) {
        layer.open({
            title: '提示',
            content: '字符长度为2-10'
        });
    }
}

function addressInfoCheckLength(field) {
    var value = field.value;
    if (value.length < 10 || value.length > 100) {
        layer.open({
            title: '提示',
            content: '字符长度为10-100'
        });
    }
}
//验证手机号码
function checkMobile(field) {
    var str = field.value;
    var re = /^1\d{10}$/
    if (re.test(str)) {
    } else {
        layer.open({
            title: '提示',
            content: '请填写正确的电话号码'
        });
    }
}

//验证手机号码
function saveCheckMobile(field) {
    var re = /^1\d{10}$/
    if (re.test(field)) {
        return true;
    } else {
        return false;
    }
}


function isEmpty(value) {
    if (value == null || value == "" || value == "null" || value == '' || value == "请选择") {
        return true;
    }
    return false;
}