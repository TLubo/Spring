describe('book modal controller', function () {
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
    	$controller('BookModalController', {$scope: $scope, $modalInstance: modalInstance});
    	
    	// then
    	expect($scope.accept).toBeDefined();
    }));

    it('accept with non-empty names should call $modalInstance.close()', inject(function ($controller) {
        // given
        $controller('BookModalController', {$scope: $scope, $modalInstance: modalInstance});
        $scope.firstName= 'Jan';
        $scope.lastName= 'Kowalski';    
        
        spyOn(modalInstance, 'close');
        
        // when
        $scope.accept();
        
        // then
        expect(modalInstance.close).toHaveBeenCalledWith({firstName: 'Jan', lastName: 'Kowalski'});
    }));
     
});