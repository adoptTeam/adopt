/**
 * Created by zhenghao on 2018/2/3.
 */
var app = angular.module('myApp', []);

//var token = localStorage.getItem("accessToken");

app.controller("ctrl", function ($scope, $http) {
    var urlList = baseHost + "userAddress/getUserAddressList";
    var token = getToken();
    $http({
        method: 'post',
        url: urlList,
        headers: {'Content-Type': 'application/x-www-form-urlencoded', "token": token}
    }).success(function (response) {
        $scope.addressList = response.data;

    }).error(function () {

    });

    $scope.editAddress = function (addressId) {
        window.location.href = "addAddress.html?addressId=" + addressId;
    }
    //设置默认地址
    $scope.setDefaultAddress = function (addressId) {
        var url = baseHost + "userAddress/setDefaultAddress";
        $http({
            method: 'post',
            url: url,
            data: $.param({"userAddressId": addressId, "addressState": 3}),
            headers: {'Content-Type': 'application/x-www-form-urlencoded', "token": token}
        }).success(function (response) {

        }).error(function () {

        });
    }


    $scope.setAddress = function (addressId) {
        window.location.href = "adoptConfirm.html?addressId=" + addressId;

    }

});
function addAddress() {
    window.location.href = "addAddress.html";
}

//返回
function back() {
    window.history.back(-1);
}
