$(document).ready(function(){
	$("#btnAddAtomicCondition").click(function(){
		//var conditionJson=JSON.stringify(condition);		
		var url="/policy/createAtomicPolicy/addAtomicCondition";
		$.ajax({
			type: "POST",
			url: url,
			//data: conditionJson,
			contentType: "application/json; charset=utf-8",
			success: function(html){
				$('#divAtomicCondition').html(html);
				
			}
		});
		$("#btnAddAtomicCondition").hide();
	});	
	
	$("#divAtomicCondition").on("click","#radioVariableLeftType",function(){
		$('#divValueLeft').hide();
		//var conditionJson=JSON.stringify(condition);
		var url="/policy/createAtomicPolicy/addLeftVariablePan";
		url+="?leftPanType=Variable";
		$.ajax({type: "POST",
				url: url,
				//data: conditionJson,
				contentType: 'application/json; charset=utf-8',
				success: function(html){
					$('#divConditionLeft').html(html);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConstantValueLeftType",function(){		
		//var conditionJson=JSON.stringify(condition);
		var url="/policy/createAtomicPolicy/addLeftValuePan";
		var leftType=$("input[name='radioLeftType']:checked").val();	
		url+="?leftPanType=Value";
		url+="&leftValueType=Constant";
		$.ajax({type: "POST",
				url: url,
				//data: conditionJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionLeft').html(html);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioEnumerationValueLeftType",function(){		
		//var conditionJson=JSON.stringify(condition);
		var url="/policy/createAtomicPolicy/addLeftValuePan";
		var leftType=$("input[name='radioLeftType']:checked").val();	
		url+="?leftPanType=Value";
		url+="&leftValueType=Enumeration";
		$.ajax({type: "POST",
				url: url,
				//data: conditionJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionLeft').html(html);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioFunctionValueLeftType",function(){		
		//var conditionJson=JSON.stringify(condition);
		var url="/policy/createAtomicPolicy/addLeftValuePan";
		var leftType=$("input[name='radioLeftType']:checked").val();	
		url+="?leftPanType=Value";
		url+="&leftValueType=Function";
		$.ajax({type: "POST",
				url: url,
				//data: conditionJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionLeft').html(html);
				}
		});
	});
	
		
	$("#divAtomicCondition").on("click","#btnAddLeftPan",function(){		

	});
});