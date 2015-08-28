describe('book save rest service', function () {
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

    it('save is defined', inject(function (bookSaveRestService) {
        // then
        expect(bookSaveRestService.save).toBeDefined();
    }));

    
    it('save should send post', inject(function ($httpBackend, bookSaveRestService) {
        // given
    	var book = {id: 1, title: 'Title of book', authors: [{firstName:'Adam', lastName:'Nowak'}]};
    	var httpBackend = $httpBackend;
    	httpBackend.expect('POST', '/context.html/rest/books/book', book).respond(200, book);

        // then
    	bookSaveRestService.save(book).then(function(response) {
    		console.log(response.status);
    		expect(response.status).toEqual(200);
    		expect(response.data).toEqual(book);  		
    	});
    	
    	httpBackend.flush();
    }));

});