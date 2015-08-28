angular.module('app.myCustomFilters', []).filter('authors', function() {
	'use strict';
	return function(authors) {
		var string = ' ';
		for (var i = 0; i < authors.length; i++) {
			string += authors[i].firstName;
			string += ' ';
			string += authors[i].lastName;
			if (i < authors.length - 1) {
				string += ', ';
			}
		}
		return string;
	};
});