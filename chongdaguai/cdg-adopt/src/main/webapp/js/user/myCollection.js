<<<<<<< HEAD
var app = angular.module('myApp', []);
app.controller("ctrl", function ($scope, $http) {

    $http({
        method: 'post',
        url: baseHost + "user/getMyCollection",
        headers: {'Content-Type': 'application/x-www-form-urlencoded', "token": getToken()}
    }).success(function (response) {
        $scope.petList = response.data.rows;
    }).error(function () {

    });

    $scope.getPetInfo=function(petId){
        window.location.href="adoptPetInfo.html?petId="+ petId;
    }


})
=======
/**
 * Created by zhenghao on 2018/2/6.
 */
var app = angular.module('myApp', []);

app.controller("ctrl", function ($scope, $http) {

    $http({
        method: 'post',
        url: baseHost + "user/getMyCollection",
        headers: {'Content-Type': 'application/x-www-form-urlencoded', "token": getToken()}
    }).success(function (response) {
        $scope.petList = response.data.rows;
    }).error(function () {

    });

    $scope.getPetInfo=function(petId){
        window.location.href="adoptPetInfo.html?petId="+ petId;
    }


})
>>>>>>> 00ba704356d5d55ed4de9fd047119f07f6a0a180
