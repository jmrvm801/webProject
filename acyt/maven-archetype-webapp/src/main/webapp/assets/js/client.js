var module = angular.module('core', ['rzModule','ngDialog', 'multipleSelect', 'nvd3']);

module.config(['ngDialogProvider', function (ngDialogProvider) {
	ngDialogProvider.setDefaults({
		className: 'ngdialog-theme-default',
		plain: false,
		showClose: true,
		closeByDocument: true,
		closeByEscape: true,
		appendTo: false
	});
}]);