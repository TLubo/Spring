describe('book controller', function () {
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

    it('search is defined', inject(function ($controller) {
        // when
        $controller('BookSearchController', {$scope: $scope});
        // then
        expect($scope.search).toBeDefined();
    }));
  
    it('deleteBook is defined', inject(function ($controller) {
    	// when
    	$controller('BookSearchController', {$scope: $scope});
    	// then
    	expect($scope.deleteBook).toBeDefined();
    }));
  
    it('update is defined', inject(function ($controller) {
    	// when
    	$controller('BookSearchController', {$scope: $scope});
    	// then
    	expect($scope.update).toBeDefined();
    }));
 
    it('addBook is defined', inject(function ($controller) {
    	// when
    	$controller('BookSearchController', {$scope: $scope});
    	// then
    	expect($scope.addBook).toBeDefined();
    }));

    it('delete book should call bookService.deleteBook()', inject(function ($controller, $q, bookService) {
        // given
        $controller('BookSearchController', {$scope: $scope});

        var bookId = 1;
        $scope.books = [{id: bookId, title: 'something'}];
        var deleteDeferred = $q.defer();
        
        spyOn(bookService, 'deleteBook').and.returnValue(deleteDeferred.promise);
        
        // when
        $scope.deleteBook(bookId);
        deleteDeferred.resolve();
        $scope.$digest();
        
        
        // then
        expect(bookService.deleteBook).toHaveBeenCalledWith(bookId);
        expect($scope.books.length).toBe(0);
    }));
     
    it('search should call bookService.search()', inject(function ($controller, $q, bookService) {
    	// given
    	$controller('BookSearchController', {$scope: $scope});
    	var booksToReturn = [{id:3, title:'book', authors:[{id:2, firstName:'nameOfAuthor', lastName:'SurnameOfAuthor'}]}];
    	var searchDeferred = $q.defer();
    	$scope.books=[];
    	$scope.prefix='nam';
    	
    	spyOn(bookService, 'search').and.returnValue(searchDeferred.promise);
    	
    	// when
    	$scope.search();
    	searchDeferred.resolve({data: booksToReturn});
    	$scope.$digest();
    	
    	// then
    	expect(bookService.search).toHaveBeenCalledWith('nam');
    	expect($scope.books.length).toBe(1);
    }));
});