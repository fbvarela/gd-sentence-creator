app.js
'use strict'
var demoApp = angular.module('gd-sentences-creator', ['ui.bootstrap', 'gd-sentences-creator.controllers',
    'gd-sentences-creator.services'
]);

demoApp.constant("CONSTANTS", {
    getAllWords: "/word",

});