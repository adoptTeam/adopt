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
