describe('authors filter test', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.myCustomFilters');
    });

    var $filter;
    
    beforeEach(inject(function (_$filter_) {
        $filter = _$filter_;
    }));
  
    it('filter should change json table to string', inject(function () {
        // given
        var Table=[{firstName:'Jan', lastName:'Kowalski'}, {firstName:'Anna', lastName:'245'}];
        
        // when
        var result=$filter('authors')(Table);     
        
        // then
        expect(result).toEqual(' Jan Kowalski, Anna 245');
    }));

});