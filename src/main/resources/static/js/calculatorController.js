app.controller('calculatorController', function($scope, $http) {
    $scope.operation;
    $scope.result;

    $scope.submit = function(){
        console.log($scope.operation);
        var postData = {};
        postData.operation =  $scope.operation;
        $http.post('api/calculator', postData)
        .then(function successCallback(response) {
            $scope.result = response.data.result;
        });
    }
});