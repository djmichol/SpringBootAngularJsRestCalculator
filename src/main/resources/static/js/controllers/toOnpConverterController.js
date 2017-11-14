app.controller('toOnpConverterController', function($scope, $http) {
    $scope.operation = "";
    $scope.result;

    $scope.submit = function(){
        console.log($scope.operation);
        var postData = {};
        postData.operation =  $scope.operation;
        $http.post('api/converter', postData)
        .then(function successCallback(response) {
            $scope.result = response.data.onp;
        });
    }

    $scope.clear = function(){
        $scope.operation = "";
    }
});