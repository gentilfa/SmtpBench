var mainApp = angular.module('MainApp', ['restangular']);

mainApp.config(function(RestangularProvider) {
	  RestangularProvider.setBaseUrl('/SmtpBench/rest');
	});

mainApp.controller('MainController', function($scope, Restangular) {

	$scope.view = {};
	
    var _init = function(){
    	
    	$scope.view.errorMsg = '';
    	$scope.view.isExecute = false;
    	$scope.view = {
    			user:'',
    			pass:'',
    			host:'',
    			port:0,
    			portSSL:0,
    			mailTo:'',
    			mailFrom:'',
    			numThread:1,
    			numMess:1,
    			sizeMessage1: 1,
    			sizeMessage2: '',
    			sizeMessage3: '',
    	};
    	_resetResult
    	
    	
    }
    
    $scope.executeBench = function(){
    	
    	$scope.view.resultSingleList = [];
		$scope.view.mainResult = '';
		$scope.view.result = false;
		$scope.view.errorMsg = '';
		
    	var obj = {user:$scope.view.user,
    			pass:$scope.view.pass,
    			host:$scope.view.host,
    			port:$scope.view.port,
    			portSSL:$scope.view.portSSL,
    			mailTo:$scope.view.mailTo,
    			mailFrom:$scope.view.mailFrom,
    			numThread:$scope.view.numThread,
    			numMess:$scope.view.numMess,
    			sizeMessage: [$scope.view.sizeMessage1]
    	}
    	if($scope.view.numMess){
	    	if($scope.view.sizeMessage2)
	    		obj.sizeMessage.push($scope.view.sizeMessage2);
	    	if($scope.view.sizeMessage3)
	    		obj.sizeMessage.push($scope.view.sizeMessage3);
    	}
    	
    	$scope.view.isExecute = true;
    	Restangular.one('smtpbench').post('main',obj).then(function(res){
		
    		if(res){
    			var res = res.plain();
    			
    			if(res.timesSingleMessage.length > 0){
	    			$scope.view.resultSingleList = res.timesSingleMessage;
	    			$scope.view.mainResult = 'Min. Time: ' + res.minTime + ' - Max. Time: ' + res.maxTime + ' - Avg Time:' + res.avgTime;
	    			$scope.view.result = true;
    			}else
    				$scope.view.errorMsg = 'Errore nell\'esecuzione della procedura';
    		}else{
    			$scope.view.errorMsg = 'Errore nell\'esecuzione della procedura';
    		}
    		$scope.view.isExecute = false;
		},function(err) {
			$scope.view.errorMsg = err;
			$scope.view.isExecute = false;
		});
    	
    }
	
    var _resetResult = function(){
    	$scope.view.resultSingleList = [];
		$scope.view.mainResult = '';
		$scope.view.result = false;
		$scope.view.errorMsg = '';
    }
    
	 _init();
});