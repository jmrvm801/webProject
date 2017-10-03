module.controller('graphic', function($scope, $rootScope, $http, chartData, indicators) {
	$rootScope.$on("updateChart", function(){
		$scope.updateChart();
	});
	$scope.options = {
		chart: {
			type: 'lineChart',
			height: 550,
			margin : {top: 20, right: 20, bottom: 40, left: 55},
			x: function(d){ return d.x; },
			y: function(d){ return d.y; },
			useInteractiveGuideline: true,
			xAxis: {axisLabel: 'Years'},
			yAxis: {
				axisLabel: 'Points',
				tickFormat: function(d){
					return d3.format('.r')(d);
				},
				axisLabelDistance: -10
			}
		}
	};
	$scope.data = [{values: [],key: ''}];
	$http.get('http://localhost:8888/getDataBank').then(function(response) {
		$scope.data = response.data;
	});
	$scope.updateChart = function(){
		var minValue = chartData.getMinValue();
		var maxValue = chartData.getMaxValue();
		var indicator = chartData.getIndicatorSelected();
		var countries = [];
		for (var i = 0; i < chartData.getCountries().length; i++)
			countries.push(chartData.getCountries()[i].coCode);
		$http.get('http://localhost:8888/getDataBank?minValue='+minValue+'&maxValue='+maxValue+'&countries='+countries.join(',')+'&indicator='+indicator).then(function(response) {
			$scope.data = response.data;
			$scope.options.chart.yAxis.axisLabel = indicators.getIndicatorByCode(indicator);
		});
	};
});