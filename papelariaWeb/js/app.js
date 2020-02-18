(function () {
    'use strict';

    angular.module('papelariaWeb', [])
        .controller('ProdutoController', function ($scope,$http) {
        	
        	
        	   $scope.cadastrarProdutoNovo = function () {
        		   $http.post('http://localhost:9000/papelaria/produtos/novo',
               			$scope.produto );
                   	    
                   	};
        	
                   	
        	
        	//método para adicionar o produto a lista
            $scope.processar = function () {
            	
            	//if(event.target[7].id==){
            		
            	//$scope.cadastrarProdutoNovo();
                //$scope.produtostodos();
            	
            	
            	//alert(event.explicitOriginalTarget.id);
            	
            	if(event.explicitOriginalTarget.id=='salvar'){
            		$scope.cadastrarProdutoNovo();
                    $scope.produtostodos();
            	}
            	if(event.explicitOriginalTarget.id=='editar'){
            		alert('editar');
            	}
            	if(event.explicitOriginalTarget.id=='excluir'){
            		alert('excluir');
            	}
            	
               
            	
            		
            	
            	
            };
            
             $scope.produtostodos = function () {
            	$http.get('http://localhost:9000/papelaria/produtos/todos').then(function (response) {
                    $scope.produtos = {id: '', nome: '', categoria: '', detalhe: '', codBarras: '',descricao:'',precoMedio:'',quantidade:''};
                    $scope.produtos=response.data;
            	});
            };
            
         
            
            
         
           
            
            
            
            
                        
          
          
            
            
            
        });

})();

