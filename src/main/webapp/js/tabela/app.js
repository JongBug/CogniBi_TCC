var app = angular.module('appTabela', []);

app.controller("tabelaCtrl", ['$scope', '$http', function ($scope, $http) {

    $scope.getTabela = function () { // Função da cascata de clientes
      $scope.dadosCognibi;
      $scope.taxa1 = 0;
      $scope.taxa2 = 0;
      $scope.taxa3 = 0;
      $scope.taxa4 = 0;
      var baseUrl = 'rest/cognibi/tabela';
      $http.get(baseUrl).then(function(response) {
          
      $scope.dadosCognibi = response.data;
          
          for(i=0; i< $scope.dadosCognibi.length; i++){
        	  console.log(parseFloat($scope.dadosCognibi[i].taxaNayveBayes))
        	  $scope.taxa1 += parseFloat($scope.dadosCognibi[i].taxaNayveBayes);
        	  $scope.taxa2 += parseFloat($scope.dadosCognibi[i].taxaOneVsOne);
        	  $scope.taxa3 += parseFloat($scope.dadosCognibi[i].taxaOneVsRest);
        	  $scope.taxa4 += parseFloat($scope.dadosCognibi[i].taxaAdaboost);
          }
          
          $scope.taxa1 = ($scope.taxa1/$scope.dadosCognibi.length);
          $scope.taxa2 = ($scope.taxa2/$scope.dadosCognibi.length);
          $scope.taxa3 = ($scope.taxa3/$scope.dadosCognibi.length);
          $scope.taxa4 = ($scope.taxa4/$scope.dadosCognibi.length);
          
          
          Highcharts.chart('container', {

        		chart: {
        				type: 'column'
        		},
        		title: {
        				text: 'Taxa de Acerto dos Algoritmos de Inteligencia'
        		},
        		xAxis: {
        				type: 'category'
        		},
        		yAxis: {
        				title: {
        						text: 'Taxas de Acerto'
        				}

        		},
        		legend: {
        				enabled: false
        		},
        		plotOptions: {
        				series: {
        						borderWidth: 0,
        						dataLabels: {
        								enabled: true,
        								format: '{point.y:.1f}%'
        						}
        				}
        		},

        		tooltip: {
        				headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        				pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
        		},

        		series: [{
        				name: 'Brands',
        				colorByPoint: true,
        				data: [{
        						name: 'OneVsOne',
        						y: $scope.taxa1, //AQUIIIIIIIIIIIIIIIIIIIIIIII
        						drilldown: 'OneVsOne'
        				}, {
        						name: 'OneVsRest',
        						y: $scope.taxa2, //AQUIIIIIIIIIIIIIIIIIIIIIIII
        						drilldown: 'OneVsRest'
        				}, {
        						name: 'Adaboostclassifier',
        						y: $scope.taxa3, //AQUIIIIIIIIIIIIIIIIIIIIIIII
        						drilldown: 'Adaboostclassifier'
        				}, {
        						name: 'NaiveBayes',
        						y: $scope.taxa4, //AQUIIIIIIIIIIIIIIIIIIIIIIII
        						drilldown: 'NaiveBayes'
        				}]
        		}],
        		drilldown: {
        				series: [{
        						name: 'Microsoft Internet Explorer',
        						id: 'Microsoft Internet Explorer',
        						data: [
        								[
        										'v11.0',
        										24.13
        								],
        								[
        										'v8.0',
        										17.2
        								],
        								[
        										'v9.0',
        										8.11
        								],
        								[
        										'v10.0',
        										5.33
        								],
        								[
        										'v6.0',
        										1.06
        								],
        								[
        										'v7.0',
        										0.5
        								]
        						]
        				}, {
        						name: 'Chrome',
        						id: 'Chrome',
        						data: [
        								[
        										'v40.0',
        										5
        								],
        								[
        										'v41.0',
        										4.32
        								],
        								[
        										'v42.0',
        										3.68
        								],
        								[
        										'v39.0',
        										2.96
        								],
        								[
        										'v36.0',
        										2.53
        								],
        								[
        										'v43.0',
        										1.45
        								],
        								[
        										'v31.0',
        										1.24
        								],
        								[
        										'v35.0',
        										0.85
        								],
        								[
        										'v38.0',
        										0.6
        								],
        								[
        										'v32.0',
        										0.55
        								],
        								[
        										'v37.0',
        										0.38
        								],
        								[
        										'v33.0',
        										0.19
        								],
        								[
        										'v34.0',
        										0.14
        								],
        								[
        										'v30.0',
        										0.14
        								]
        						]
        				}, {
        						name: 'Firefox',
        						id: 'Firefox',
        						data: [
        								[
        										'v35',
        										2.76
        								],
        								[
        										'v36',
        										2.32
        								],
        								[
        										'v37',
        										2.31
        								],
        								[
        										'v34',
        										1.27
        								],
        								[
        										'v38',
        										1.02
        								],
        								[
        										'v31',
        										0.33
        								],
        								[
        										'v33',
        										0.22
        								],
        								[
        										'v32',
        										0.15
        								]
        						]
        				}, {
        						name: 'Safari',
        						id: 'Safari',
        						data: [
        								[
        										'v8.0',
        										2.56
        								],
        								[
        										'v7.1',
        										0.77
        								],
        								[
        										'v5.1',
        										0.42
        								],
        								[
        										'v5.0',
        										0.3
        								],
        								[
        										'v6.1',
        										0.29
        								],
        								[
        										'v7.0',
        										0.26
        								],
        								[
        										'v6.2',
        										0.17
        								]
        						]
        				}, {
        						name: 'Opera',
        						id: 'Opera',
        						data: [
        								[
        										'v12.x',
        										0.34
        								],
        								[
        										'v28',
        										0.24
        								],
        								[
        										'v27',
        										0.17
        								],
        								[
        										'v29',
        										0.16
        								]
        						]
        				}]
        		}
        	});
      }, function(err) {
      console.log(err);
      });
    };
}]);
