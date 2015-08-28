describe('update modal controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.books');
    });

    var $scope;
    var modalInstance = { close: function() {}, dismiss: function() {} };
    
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));
  
    it('accept is defined', inject(function ($controller) {
    	// when
    	$controller('UpdateModalController', {$scope: $scope, $modalInstance: modalInstance});
    	
    	// then
    	expect($scope.accept).toBeDefined();
    }));

    it('Non-empty title accept should call $modalInstance.close', inject(function ($controller) {
        // given
        $controller('UpdateModalController', {$scope: $scope, $modalInstance: modalInstance});
        $scope.changedTitle='Non-empty title';   
        spyOn(modalInstance, 'close');
        
        // when
        $scope.accept();
        
        // then
        expect(modalInstance.close).toHaveBeenCalledWith('Non-empty title');
    }));
     
});