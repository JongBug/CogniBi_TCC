var app = angular.module('appTabela', []);
console.log("chamndo app")
app.controller("tabelaCtrl", ['$scope', '$http', function ($scope, $http) {

    $scope.getTabela = function () { // Função da cascata de clientes
      $scope.dadosCognibi;
      var baseUrl = '../rest/cognibi/tabela';
      $http.get(baseUrl).then(function(response) {
          console.log(response)
      $scope.dadosCognibi = response.data;
      }, function(err) {
      console.log(err);
      });
    };
}]);
