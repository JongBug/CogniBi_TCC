var app = angular.module('appTabela', []);
app.controller("tabelaCtrl", ['$scope', '$http', function ($scope, $http) {

    $scope.getTabela = function () { // Função da cascata de clientes
      $scope.dadosCognibi;
      var baseUrl = 'rest/cognibi/tabela';
      $http.get(baseUrl).then(function(response) {
      $scope.dadosCognibi = response.data;
      }, function(err) {
      console.log(err);
      });
    };
}]);
