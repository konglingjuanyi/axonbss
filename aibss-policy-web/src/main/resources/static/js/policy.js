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
		var url="/policy/createAtomicPolicy/addLeftVariable";
		$.ajax({type: "POST",
				url: url,
				//data: conditionJson,
				contentType: 'application/json; charset=utf-8',
				success: function(html){
					$('#divLeftVariable').html(html);
					$('#divLeftConstValue').html(null);
					$('#divLeftEnumValue').html(null);
					$('#divLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConstantValueLeftType",function(){		
		var url="/policy/createAtomicPolicy/addLeftConstValue";
		var leftType=$("input[name='radioLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divLeftConstValue').html(html);
					$('#divLeftVariable').html(null);
					$('#divLeftEnumValue').html(null);
					$('#divLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioEnumerationValueLeftType",function(){		
		var url="/policy/createAtomicPolicy/addLeftEnumValue";
		var leftType=$("input[name='radioLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divLeftEnumValue').html(html);
					$('#divLeftVariable').html(null);
					$('#divLeftConstValue').html(null);
					$('#divLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioFunctionValueLeftType",function(){		
		var url="/policy/createAtomicPolicy/addLeftFunctionValue";
		var leftType=$("input[name='radioLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divLeftFunctionValue').html(html);
					$('#divLeftVariable').html(null);
					$('#divLeftConstValue').html(null);
					$('#divLeftEnumValue').html(null);
				}
		});
	});
	
		
	$("#divAtomicCondition").on("click","#btnAddLeftPan",function(){		

	});
});