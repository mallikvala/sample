'use strict';

/**
 * @ngdoc function
 * @name litmusUiApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the litmusUiApp
 */
angular.module('litmusUiApp')
  .controller('MainCtrl' , ['$scope','$location',function ($scope, $location) {
    $scope.go = function ( path ) {
    $location.path( path );
    };

    $scope.search = "Search for a job";
  }]);
