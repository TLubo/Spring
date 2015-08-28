describe('book save controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.books');
    });

    var $scope;
    
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));

    it('save is defined', inject(function ($controller) {
        // when
        $controller('BookSaveController', {$scope: $scope});
        
        // then
        expect($scope.save).toBeDefined();
    }));
   
    it('addAuthor is defined', inject(function ($controller) {
    	// when
    	$controller('BookSaveController', {$scope: $scope});
    	// then
    	expect($scope.addAuthor).toBeDefined();
    }));
   
    it('removeAuthor is defined', inject(function ($controller) {
    	// when
    	$controller('BookSaveController', {$scope: $scope});
    	// then
    	expect($scope.removeAuthor).toBeDefined();
    }));
    
    it('save should call bookSaveService.save()', inject(function ($controller, $q, bookSaveService, Flash) {
        // given
        $controller('BookSaveController', {$scope: $scope});
        var saveDeferred = $q.defer();
        $scope.title='test';
        $scope.authors=[{firstName:'Jan', lastName:'Nowak'}];
        
        spyOn(bookSaveService, 'save').and.returnValue(saveDeferred.promise);
        spyOn(Flash, 'create');
        
        // when
        $scope.save();
        saveDeferred.resolve();
        $scope.$digest();
        
        // then
        expect(bookSaveService.save).toHaveBeenCalledWith({title:$scope.title, authors:$scope.authors});
    }));

    it('addAuthor should add new author', inject(function ($controller, $q, $modal) {
    	// given
    	$controller('BookSaveController', {$scope: $scope}); 	
    	var author = {firstName:'Adam', lastName:'Nowak'};
    	var modalDeferred = $q.defer();
    	$scope.authors=[];
    	spyOn($modal, 'open').and.returnValue({result: modalDeferred.promise });
    	
    	// when
    	$scope.addAuthor();
    	modalDeferred.resolve(author);
    	$scope.$digest();
    	
    	// then
    	expect($scope.authors.length).toBe(1);
    }));
 
});