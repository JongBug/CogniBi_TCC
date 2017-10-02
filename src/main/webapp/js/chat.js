app.controller("appCogniBiCtrl", ['$scope', '$http', 'socioEconomico', function ($scope, $http, socioEconomico) {
  $scope.valores = socioEconomico;

  $scope.nomeAluno;
  $scope.escolaridadeAluno = $scope.valores.escolaridade.naoInfo;
  $scope.sexoAluno = $scope.valores.sexo.naoInfo;

  $scope.cadastro = function () {
    if($scope.nomeAluno=="" || $scope.nomeAluno == null || $scope.emailAluno=="" || $scope.emailAluno == null
    		|| $scope.escolaridadeAluno == $scope.valores.escolaridade.naoInfo || $scope.sexoAluno == $scope.valores.sexo.naoInfo){
    	
    	$scope.notEmpty = false;
    	alert("Favor preencher todos os campos!");
        return false;
    } else {
      $scope.notEmpty = true;
      $(".chat").show();
    	return true
    }
  }

  var btnEnviaMensagem = document.querySelector("#btn-envia-mensagem");
  btnEnviaMensagem.addEventListener("click", function () {
    event.preventDefault(); // Evita recarregamento da página

    var formularioChat = document.querySelector("#mensagem-conversa");
    var textoPergunta = formularioChat.mensagem.value;

    if (textoPergunta != "") {
      var balaoComMensagemUser = montaBalaoComMensagemUser(textoPergunta);
      var conversa = document.querySelector("#conversa");
      conversa.appendChild(balaoComMensagemUser);
      conversa.scrollTop = conversa.scrollHeight;

      var dataObj = { // Objeto com as informações.
        nome : $scope.nomeAluno,
        escolaridade : $scope.escolaridadeAluno,
        sexo : $scope.sexoAluno,
        email : $scope.emailAluno,
		    textoPergunta: textoPergunta,
        context: $scope.context
      };

      // Comunicao com servidor
      //var baseUrl = 'rest/cognibi/chat/' + textoPergunta;
      var baseUrl = 'rest/cognibi/chat';
      $http.post(baseUrl, dataObj).then(function (response) {
        //AQUI EH A RESPOSTA DO SERVIDOR RESPONSE.DATA.CONVERSA
        //$scope.oi = response.data.conversa;
    	  $scope.context = response.data.context;
        var balaoComMensagemCog = montaBalaoComMensagemCog(response.data.conversa);
        conversa.appendChild(balaoComMensagemCog);
        conversa.scrollTop = conversa.scrollHeight;

      }, function (err) {
        console.log(err);
      });

      formularioChat.reset();
    } else {
      var conversa = document.querySelector("#conversa");
      var balaoComMensagemCog = montaBalaoComMensagemCog('Digite uma mensagem para que eu possa te ajudar');
        conversa.appendChild(balaoComMensagemCog);
        conversa.scrollTop = conversa.scrollHeight;
    }
  });


  function montaBalaoComMensagemUser(mensagem) {
    var balaoComMensagem = document.createElement("div");
    balaoComMensagem.classList.add("row");
    balaoComMensagem.appendChild(montaBalaoUser(mensagem));

    return balaoComMensagem;
  };

  function montaBalaoUser(mensagem) {
    var balao = document.createElement("div");
    balao.classList.add("mensagem-usuario");
    balao.classList.add("right");
    balao.appendChild(montaMensagemUser(mensagem));

    return balao;
  };

  function montaMensagemUser(mensagem) {
    var montaMensagem = document.createElement("p");
    montaMensagem.classList.add("texto-mensagem");
    montaMensagem.classList.add("grey-text");
    montaMensagem.classList.add("text-darken-4")
    montaMensagem.textContent = mensagem;

    return montaMensagem;
  };

  function montaBalaoComMensagemCog(mensagem) {
    var balaoComMensagem = document.createElement("div");
    balaoComMensagem.classList.add("row");
    balaoComMensagem.appendChild(montaBalaoCog(mensagem));

    return balaoComMensagem;
  };

  function montaBalaoCog(mensagem) {
    var balao = document.createElement("div");
    balao.classList.add("balao-mensagem-cognibi");
    balao.classList.add("left");
    balao.appendChild(montaMensagemCog(mensagem));

    return balao;
  };

  function montaMensagemCog(mensagem) {
    var montaMensagem = document.createElement("p");
    montaMensagem.classList.add("texto-mensagem");
    montaMensagem.classList.add("white-text");
    //montaMensagem.classList.add("text-darken-4")
    montaMensagem.textContent = mensagem;

    return montaMensagem;
  };

}]);
