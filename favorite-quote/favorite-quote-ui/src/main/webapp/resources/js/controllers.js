/**
 * Binay Mishra
 */

var quoteAuthor = angular.module('quoteAuthor', []);

quoteAuthor.controller('Authors',['$scope', '$http', function($scope, $http) {
			$http.get('http://localhost:8080/favorite-quote-service/author').
        		success(function(data) {
            		$scope.authors = data;
        		});
			}]);