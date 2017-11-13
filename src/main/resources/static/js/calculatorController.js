app.controller('calculatorController', function($scope, $http) {
    $scope.operation = "";
    $scope.result;

    $scope.submit = function(){
        console.log($scope.operation);
        var postData = {};
        postData.operation =  $scope.operation;
        $http.post('api/calculator', postData)
        .then(function successCallback(response) {
            $scope.result = response.data.result;
            $scope.operation = response.data.result;
        });
    }

    $scope.addToOperation = function(cos){
        $scope.operation += cos;
    }

    $scope.clear = function(){
        $scope.operation = "";
    }
});