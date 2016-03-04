'use strict';

/**
 * @ngdoc overview
 * @name litmusUiApp
 * @description
 * # litmusUiApp
 *
 * Main module of the application.
 */
angular
  .module('litmusUiApp', [
    'ngAnimate',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/jobs', {
        templateUrl: 'views/jobsearch.html',
        controller: 'JobSearchCtrl',
        controllerAs: 'jobsearch'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
