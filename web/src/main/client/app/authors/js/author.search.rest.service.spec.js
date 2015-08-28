describe('author rest service', function () {
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

    it('search is defined', inject(function (authorRestService) {
        expect(authorRestService.search).toBeDefined();
    }));
    
    it('search should send get request', inject(function ($httpBackend, authorRestService) {
        // given
    	var authors = [{firstName:'Jan', lastName:'Kowalski'}];
    	var httpBackend = $httpBackend;
    	httpBackend.expect('GET', '/context.html/rest/authors/authors').respond(200, authors);
    	    	
        // then
    	authorRestService.search().then(function(response) {
    		expect(response.status).toEqual(200);
    		expect(response.data).toEqual(authors);  		
    	});
    	
    	httpBackend.flush();
    }));

});