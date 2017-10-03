module.service('indicators',function(){
	var indicator = [];
	var setIndicator = function(varIndicator){
		indicator = varIndicator;
	};
	var getIndicator = function(){
		return indicator;
	};
	var getIndicatorByCode = function(code){
		var name = '';
		for (var i in indicator){
			if (indicator[i].inCode == code){
				name = indicator[i].inName;
				break;
			}
		}
		return name;
	};
	return {
		setIndicator : setIndicator,
		getIndicator : getIndicator,
		getIndicatorByCode : getIndicatorByCode
	};
});