'use strict';

/**
* @ngdoc function
* @name litmusUiApp.controller:AboutCtrl
* @description
* # AboutCtrl
* Controller of the litmusUiApp
*/
angular.module('litmusUiApp')
.controller('JobSearchCtrl', ['$scope','$location',function ($scope, $location) {
  $scope.go = function ( path ) {
    $location.path( path );
  };
}]);
