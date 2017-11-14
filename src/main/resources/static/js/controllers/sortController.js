app.controller('sortController', function($scope, $http) {
    $scope.arrayToSort = "";
    $scope.result;
    $scope.time

    $scope.sort = function(algorithm){
        var postData = {};
        postData.array =  $scope.arrayToSort.split(",");
        $http.post('api/sort/'+algorithm, postData)
        .then(function successCallback(response) {
            $scope.result = response.data.result;
            $scope.time = response.data.time;
        });
    }

    $scope.clear = function(){
        $scope.operation = "";
    }
});