(function () {
	'use strict';

	angular.module('papelariaWeb',[])
	.controller('ProdutoController', function ($scope,$http) {

		
		
		$scope.cadastrar = function () {
			var prod =$scope.produto;
			$http.post('http://localhost:9000/papelaria/produtos/cadastrar',prod);
		};

		$scope.excluir = function (id) {
			$http.delete('http://localhost:9000/papelaria/produtos/excluir/'+id);
		};

		$scope.buscar = function (id) {
			$http.get('http://localhost:9000/papelaria/produtos/produto/'+id).then(function (response) {
			$scope.produto=response.data;
			});
			return $scope.produto;
		};
		
		$scope.listarprodutos = function () {
			$http.get('http://localhost:9000/papelaria/produtos').then(function (response) {
			$scope.produtos=response.data;
			});
		};
		
		$scope.reset = function () {
			$scope.produto = {id: '', nome: '', categoria: '', detalhe: '', codBarras: '',descricao:'',precoMedio:'',quantidade:''};
		};

		
		//método para adicionar o produto a lista
		$scope.processar = function (param) {

			if(event.explicitOriginalTarget.id=='salvar'){
				//event.explicitOriginalTarget.disabled=true;
				$scope.cadastrar();	
				$scope.listarprodutos();
				//event.explicitOriginalTarget.disabled=false;
				//alert('sucesso');
				
			
			}
			if(event.explicitOriginalTarget.id=='editar'){
				$scope.produto=$scope.buscar(param);
				document.getElementById("categoria").value=$scope.produto.categoria;
				
				
			}
			if(event.explicitOriginalTarget.id=='excluir'){
				$scope.excluir(param);
				$scope.listarprodutos();
			}
			if(event.explicitOriginalTarget.id=='limpar'){
				$scope.reset();
			}


		};


	});

})();

