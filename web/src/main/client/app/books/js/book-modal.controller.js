angular.module('app.books').controller('BookModalController', function($scope, $modalInstance) {
	'use strict';
	$scope.firstName = '';
	$scope.lastName = '';
	
	$scope.accept = function() {	
		if ($scope.firstName && $scope.lastName) {
			$modalInstance.close({'firstName':$scope.firstName, 'lastName':$scope.lastName});
		}
	};
	
});