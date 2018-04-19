var app = angular.module('myApp', []);

app.controller("ctrl", function ($scope, $http, $location) {
 
    $scope.offset = 0;
    $scope.$watch('$viewContentLoaded', function () {
        $scope.loadPet();
    });

    $scope.loadPet = function () {
        $scope.offset = $scope.offset + 1;
        $scope.total = 0;
        $scope.contentShow = false;
        var urlList = "littlePet/getLittlePetList?offset=" + $scope.offset + "&limit=10"
        $http.post(baseHost + urlList).success(function (response) {
            $scope.total = response.data.total;
            if ($scope.total > 0) {
                $scope.contentShow = true;
            }
            if($scope.offset >1){
                $scope.petList =$scope.petList.concat(response.data.rows) ;
            }else {
                $scope.petList = response.data.rows;
            }

        }).error(function () {

        });
    };
    $scope.selectInfo = '';

    $scope.searchPet = function (selectInfo) {
        $http.post(baseHost + urlList + "?content=" + $scope.selectInfo).success(function (response) {
            $scope.total = response.data.total;
            if ($scope.total > 0) {
                $scope.contentShow = true;
            }
            $scope.petList = response.data.rows;
        }).error(function () {

        });
    }

    $scope.getPetInfo = function (petId) {
        window.location.href = "adoptPetInfo.html?petId=" + petId;
    }
});

function func1() {
    var appElement = document.querySelector('[ng-controller=ctrl]');
    var $scope = angular.element(appElement).scope();
    $scope.loadPet();
}




