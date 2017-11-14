'use strict';
var app = angular.module('calculatorApp', ['ngRoute']);

app.config(function($routeProvider, $locationProvider){
    $routeProvider
        .when('/home',{
            templateUrl: 'static/view/home.html',
            controller: 'homeController'
        })
        .when('/calculator',{
                    templateUrl: 'static/view/calculator.html',
                    controller: 'calculatorController'
                })
        .when('/toOnpConverter',{
                    templateUrl: 'static/view/toOnpConverter.html',
                    controller: 'toOnpConverterController'
                })
        .when('/sort',{
                    templateUrl: 'static/view/sort.html',
                    controller: 'sortController'
                })
        .otherwise(
            { redirectTo: '/home'}
        );
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('');
});


angular.element(function(){
    angular.bootstrap(document, ['calculatorApp']);
});