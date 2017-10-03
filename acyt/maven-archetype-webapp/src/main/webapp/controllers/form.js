module.controller('form', function($scope, $rootScope, $http, ngDialog, chartData, indicators) {
	$scope.childmethod = function() {
		$rootScope.$emit("updateChart", {});
	};
	$scope.slider = {
        minValue: 1960,
        maxValue: 2016,
        options: { floor: 1960, ceil: 2016, step: 1}
    };
	$scope.indicator = [];
	$scope.indicatorSelected = '';
	$scope.countries = [];
	$scope.country = [];
	$http.get('http://localhost:8888/getIndicator').then(function(response) {
		$scope.indicator = response.data;
		indicators.setIndicator($scope.indicator);
	});
	$http.get('http://localhost:8888/getCountry').then(function(response) {
		$scope.country = response.data;
	});
	$scope.validator = function(){
		if ($scope.countries.length == 0 || $scope.indicatorSelected == ''){
			ngDialog.open({template: 'emptyData',controller: 'form', className: 'ngdialog-theme-default'});
			return false;
		}
		chartData.setCountries($scope.countries);
		chartData.setMinValue($scope.slider.minValue);
		chartData.setMaxValue($scope.slider.maxValue);
		chartData.setIndicatorSelected($scope.indicatorSelected);
		$scope.childmethod();
	};
});