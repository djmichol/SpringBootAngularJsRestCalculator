app.controller('calculatorController', function($scope) {
    $scope.operation;

    $scope.submit = function(){
        console.log( $scope.operation);
    }
});