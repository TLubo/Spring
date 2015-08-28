angular.module('app.books').controller('UpdateModalController', function($scope, $modalInstance) {
	'use strict';
	$scope.changedTitle='';
	
	$scope.accept = function() {
		if ($scope.changedTitle) {
			$modalInstance.close($scope.changedTitle);
		}
	};

});