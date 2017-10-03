module.service('chartData', function() {
	var indicatorSelected = '';
	var countries = [];
	var minValue = '';
	var maxValue = '';
	var setIndicatorSelected = function(varIndicatorSelected){
		indicatorSelected = varIndicatorSelected;
	};
	var setCountries = function(varCountries){
		countries = varCountries;
	};
	var setMinValue = function(varMinValue){
		minValue = varMinValue;
	};
	var setMaxValue = function(varMaxValue){
		maxValue = varMaxValue;
	};
	var getIndicatorSelected = function(){
		return indicatorSelected;
	};
	var getCountries = function(){
		return countries;
	};
	var getMinValue = function(){
		return minValue;
	};
	var getMaxValue = function(){
		return maxValue;
	};
	return {
		setIndicatorSelected : setIndicatorSelected,
		setCountries : setCountries,
		setMinValue : setMinValue,
		setMaxValue : setMaxValue,
		getIndicatorSelected : getIndicatorSelected,
		getCountries : getCountries,
		getMinValue : getMinValue,
		getMaxValue : getMaxValue
	};
});