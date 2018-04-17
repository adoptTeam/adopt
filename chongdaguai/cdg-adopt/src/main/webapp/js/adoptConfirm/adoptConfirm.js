var app = angular.module('myApp', []);
var token = getToken();
app.controller("ctrl", function ($scope, $http) {

    var noneAddress = document.getElementById("noneAddress");
    noneAddress.style.display = "block";
    var haveAddress = document.getElementById("haveAddress");
    haveAddress.style.display = "none";

    var pet = location.search.substring(1).split("=");
    if (pet[0] == "petId") {
        localStorage.setItem("petId", pet[1]);
    }
    var petId = localStorage.getItem("petId");

    var urlList = "littlePet/getPetInfoByPetId"
    $http.post(baseHost + urlList + "?petId=" + petId).success(function (response) {
        $scope.petInfo = response.data;
    }).error(function () {

    });

    //从选择地址页面跳转过来的时候传来的addressId
    var addressId = null;
    var address = location.search.substring(1).split("=");
    if (address[0] == "addressId") {
        localStorage.setItem("addressId", address[1]);
    }
    addressId = localStorage.getItem("addressId");

    //获得地址信息
    var addressUrl = "userAddress/getDefaultAddress?addressId=" + addressId;
    $http({
        method: 'post',
        url: baseHost + addressUrl,
        headers: {'Content-Type': 'application/x-www-form-urlencoded', "token": token}
    }).success(function (response) {
        $scope.addressFlag = false;
        $scope.myAddress = response.data;
        if ($scope.myAddress != null) {
            var noneAddress = document.getElementById("noneAddress");
            noneAddress.style.display = "none";
            var haveAddress = document.getElementById("haveAddress");
            haveAddress.style.display = "block";
        }
        localStorage.setItem("addressId", '');
    }).error(function () {

    });

    $scope.remark = localStorage.getItem("remark");

    $scope.$watch('remark', function(newValue, oldValue) {
        if ($scope.remark != oldValue){
            localStorage.setItem("remark", $scope.remark);
        }
    });
    //立即领养
    $scope.nowAdopt = function () {

        if ($scope.myAddress == null || $scope.myAddress == undefined) {
            layer.open({
                title: '提示',
                content: '请先填写领养地址'
            });
        }

        $scope.adopt = {
            "petId": $scope.petInfo.petId,
            "addressId": $scope.myAddress.userAddressId,
            "commentContent":  localStorage.getItem("remark")
        }
        $http({
            method: 'post',
            url: baseHost + "user/nowAdopt",
            data: $.param($scope.adopt),
            headers: {'Content-Type': 'application/x-www-form-urlencoded', "token": token}
        }).success(function (response) {
            localStorage.setItem("remark", '');
            window.location.href = "myAdoptDueToPay.html";
        }).error(function () {
            layer.open({
                title: '提示',
                content: '主人，小乖不能重复领养'
            });
        });

    }
});

function addAddress() {
    window.location.href = "addAddress.html?addFlag=addFlag"
}
//跳转地址列表页面
function selectAddress() {
    window.location.href = "selectAddressList.html?confirmAdopt=confirmAdopt"
}

