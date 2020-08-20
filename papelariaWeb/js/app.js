(function () {
	'use strict';

	angular.module('papelariaWeb',[])
	.controller('ProdutoController', function ($scope,$http) {
		
		$scope.salvar = function () {
		
			if($scope.produto.id==''){
				$http.post('http://localhost:9000/PapelariaAPI/produtos/cadastrar',$scope.produto);
		}else{
				$http.put('http://localhost:9000/PapelariaAPI/produtos/atualizar',$scope.produto);
			}
			$scope.reset();
			$scope.listarprodutos();
				event.submitter.disabled=false;
		};

		$scope.excluir = function (id) {
			$http.delete('http://localhost:9000/PapelariaAPI/produtos/excluir/'+id);
			$scope.reset();
			$scope.listarprodutos();
		};

		$scope.buscar = function (id) {
			$http.get('http://localhost:9000/PapelariaAPI/produtos/produto/'+id).then(function (response) {
			$scope.produto=response.data;
			});
			return $scope.produto;
		};
		
		$scope.listarprodutos = function () {
			$http.get('http://localhost:9000/PapelariaAPI/produtos').then(function (response) {
			$scope.produtos=response.data;
			});
		};
		
		$scope.listarcategorias = function () {
			$http.get('http://localhost:9000/PapelariaAPI/categorias').then(function (response) {
			$scope.categorias=response.data;
			});
		};
		
		$scope.reset = function () {
			$scope.produto    = {id: '', nome: '', categoriaId: '', detalhe: '', codBarras: '',descricao:'',preco:'',precoDesconto:'',descontoPercentual:'',quantidade:''};
		};

		$scope.editar=function(id){
				$scope.produto=$scope.buscar(id);
				document.getElementsByName("categoria").value=$scope.produto.categoriaId;
		};
		
		//método para adicionar o produto a lista
		$scope.processar = function () {

			if(event.submitter.id=='salvar'){
				event.submitter.disabled=true;
				$scope.salvar(false);	
				
			}
	
			if(event.submitter.id=='limpar'){
				$scope.reset();
			}
		
		};

	});

})();

