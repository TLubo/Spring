describe('book save service', function () {
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
    
    it('save is defined', inject(function (bookSaveService) {
        // then
        expect(bookSaveService.save).toBeDefined();
    }));

    it('save should call bookRestSaveService.save()', inject(function (bookSaveService, bookSaveRestService) {
        // given
        var book = {id: 1, title: 'Title of book', authors: [{firstName:'Anna', lastName:'Kowalska'}]};
        
        spyOn(bookSaveRestService, 'save').and.returnValue(book);
        
        // when
        bookSaveService.save(book);
        
        // then
        expect(bookSaveRestService.save).toHaveBeenCalledWith(book);
    }));

});