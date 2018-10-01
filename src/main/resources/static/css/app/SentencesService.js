'use strict'

angular.module('gd-sentences-creator.services', []).factory('SentencesServices', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};

    service.getAllWords = function() {
        return $http.get(CONSTANTS.getAllWords);
    }
    return service;
}]);