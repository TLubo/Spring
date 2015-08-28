describe('author controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.authors');
    });

    var $scope;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));

    it('author search is defined', inject(function ($controller) {
        // when
        $controller('AuthorSearchController', {$scope: $scope});
        // then
        expect($scope.search).toBeDefined();
    }));
  
    it('author check is defined', inject(function ($controller) {
    	// when
    	$controller('AuthorSearchController', {$scope: $scope});
    	// then
    	expect($scope.check).toBeDefined();
    }));
    
    
    it('check should true return', inject(function ($controller, $q, authorService) {
    	// given
    	var searchDeferred = $q.defer();
    	spyOn(authorService, 'search').and.returnValue(searchDeferred.promise);
    	$controller('AuthorSearchController', {$scope: $scope});
    	var author = {fistName: 'adam', lastName: 'kowalski'};
    	    	
    	// then
    	expect($scope.check(author, 'kowa')).toEqual(true);
    }));
 
});