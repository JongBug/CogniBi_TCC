var appCogniBi = angular.module('appCogniBi', []);
  appCogniBi.controller('appCogniBiCtrl',['$scope','$http', function($scope, $http){

    // $scope.init = function () { // Função da cascata de clientes
    //     $scope.oi;
    //     var baseUrl = 'rest/cognibi/clientes';
    //     $http.get(baseUrl).then(function(response) {
    //     $scope.oi = response.data;
    //     console.log($scope.oi);
    //     }, function(err) {
    //     console.log(err);
    //     });
    // };

      var btnEnviaMensagem = document.querySelector("#btn-envia-mensagem");
      btnEnviaMensagem.addEventListener("click", function () {
        event.preventDefault(); // Evita recarregamento da página

        var formularioChat = document.querySelector("#mensagem-conversa");
        var textoPergunta = formularioChat.mensagem.value;

        if (textoPergunta != "") {
            var balaoComMensagem = montaBalaoComMensagem(textoPergunta);

            // Comunicao com servidor
            var baseUrl = 'rest/cognibi/chat/' + textoPergunta;
            $http.get(baseUrl).then(function(response) {
              console.log(response);
              $scope.oi = response.data.conversa;
              console.log($scope.oi);
            }, function(err) {
            console.log(err);
            });
            //

            var conversa = document.querySelector("#conversa");
            conversa.appendChild(balaoComMensagem);
            conversa.scrollTop = conversa.scrollHeight;

            formularioChat.reset();
        } else {
            return alert("Digite uma mensagem para que eu possa te ajudar");
        }
      });


      function montaBalaoComMensagem(mensagem) {
        var balaoComMensagem = document.createElement("div");
        balaoComMensagem.classList.add("row");
        balaoComMensagem.appendChild(montaBalao(mensagem));

        return balaoComMensagem;
      };

      function montaBalao(mensagem) {
        var balao = document.createElement("div");
        balao.classList.add("mensagem-usuario");
        balao.classList.add("right");
        balao.appendChild(montaMensagem(mensagem));

        return balao;
      };

      function montaMensagem(mensagem) {
        var montaMensagem = document.createElement("p");
        montaMensagem.classList.add("texto-mensagem");
        montaMensagem.classList.add("grey-text");
        montaMensagem.classList.add("text-darken-4")
        montaMensagem.textContent = mensagem;

        return montaMensagem;
      };

}]);
