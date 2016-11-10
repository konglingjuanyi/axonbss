$(document).ready(function(){
	/////////////////AddAtomicCondition//////////////////
	$("#btnAddAtomicCondition").click(function(){
		var policyJson=JSON.stringify(policy);	
		var url="/policy/createAtomicPolicy/addAtomicCondition";
		$.ajax({
			type: "POST",
			url: url,
			data: policyJson,
			contentType: "application/json; charset=utf-8",
			success: function(html){
				$('#divAtomicCondition').html(html);
				
			}
		});
		$("#btnAddAtomicCondition").hide();
	});	
	
	////left
	$("#divAtomicCondition").on("click","#radioConditionLeftVariable",function(){
		$('#divConditionLeftValue').hide();
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addConditionLeftVariable";
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: 'application/json; charset=utf-8',
				success: function(html){
					$('#divConditionLeftVariable').html(html);
					$('#divConditionLeftConstValue').html(null);
					$('#divConditionLeftEnumValue').html(null);
					$('#divConditionLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConditionLeftConstantValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addConditionLeftConstValue";
		var leftType=$("input[name='radioConditionLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionLeftConstValue').html(html);
					$('#divConditionLeftVariable').html(null);
					$('#divConditionLeftEnumValue').html(null);
					$('#divConditionLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConditionLeftEnumerationValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addConditionLeftEnumValue";
		var leftType=$("input[name='radioConditionLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionLeftEnumValue').html(html);
					$('#divConditionLeftVariable').html(null);
					$('#divConditionLeftConstValue').html(null);
					$('#divConditionLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConditionLeftFunctionValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addConditionLeftFunctionValue";
		var leftType=$("input[name='radioConditionLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionLeftFunctionValue').html(html);
					$('#divConditionLeftVariable').html(null);
					$('#divConditionLeftConstValue').html(null);
					$('#divConditionLeftEnumValue').html(null);
				}
		});
	});
	
		
	////right
	$("#divAtomicCondition").on("click","#radioConditionRightVariable",function(){
		var policyJson=JSON.stringify(policy);
		$('#divValueConditionRight').hide();
		//var conditionJson=JSON.stringify(condition);
		var url="/policy/createAtomicPolicy/addConditionRightVariable";
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: 'application/json; charset=utf-8',
				success: function(html){
					$('#divConditionRightVariable').html(html);
					$('#divConditionRightConstValue').html(null);
					$('#divConditionRightEnumValue').html(null);
					$('#divConditionRightFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConditionRightConstantValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addConditionRightConstValue";
		var leftType=$("input[name='radioConditionRightType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionRightConstValue').html(html);
					$('#divConditionRightVariable').html(null);
					$('#divConditionRightEnumValue').html(null);
					$('#divConditionRightFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConditionRightEnumerationValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addConditionRightEnumValue";
		var leftType=$("input[name='radioConditionRightType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionRightEnumValue').html(html);
					$('#divConditionRightVariable').html(null);
					$('#divConditionRightConstValue').html(null);
					$('#divConditionRightFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicCondition").on("click","#radioConditionRightFunctionValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addConditionRightFunctionValue";
		var leftType=$("input[name='radioConditionRightType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divConditionRightFunctionValue').html(html);
					$('#divConditionRightVariable').html(null);
					$('#divConditionRightConstValue').html(null);
					$('#divConditionRightEnumValue').html(null);
				}
		});
	});
	
	/////////////////AddAtomicAction//////////////////
	$("#btnAddAtomicAction").click(function(){
		var policyJson=JSON.stringify(policy);	
		var url="/policy/createAtomicPolicy/addAtomicAction";
		$.ajax({
			type: "POST",
			url: url,
			data: policyJson,
			contentType: "application/json; charset=utf-8",
			success: function(html){
				$('#divAtomicAction').html(html);
				
			}
		});
		$("#btnAddAtomicAction").hide();
	});	
	
	////left
	$("#divAtomicAction").on("click","#radioActionLeftVariable",function(){
		$('#divValueActionLeft').hide();
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addActionLeftVariable";
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: 'application/json; charset=utf-8',
				success: function(html){
					$('#divActionLeftVariable').html(html);
					$('#divActionLeftConstValue').html(null);
					$('#divActionLeftEnumValue').html(null);
					$('#divActionLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicAction").on("click","#radioActionLeftConstantValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addActionLeftConstValue";
		var leftType=$("input[name='radioActionLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divActionLeftConstValue').html(html);
					$('#divActionLeftVariable').html(null);
					$('#divActionLeftEnumValue').html(null);
					$('#divActionLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicAction").on("click","#radioActionLeftEnumerationValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addActionLeftEnumValue";
		var leftType=$("input[name='radioActionLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divActionLeftEnumValue').html(html);
					$('#divActionLeftVariable').html(null);
					$('#divActionLeftConstValue').html(null);
					$('#divActionLeftFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicAction").on("click","#radioActionLeftFunctionValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addActionLeftFunctionValue";
		var leftType=$("input[name='radioActionLeftType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divActionLeftFunctionValue').html(html);
					$('#divActionLeftVariable').html(null);
					$('#divActionLeftConstValue').html(null);
					$('#divActionLeftEnumValue').html(null);
				}
		});
	});
	
		
	////right
	$("#divAtomicAction").on("click","#radioActionRightVariable",function(){
		var policyJson=JSON.stringify(policy);
		$('#divValueActionRight').hide();
		//var conditionJson=JSON.stringify(condition);
		var url="/policy/createAtomicPolicy/addActionRightVariable";
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: 'application/json; charset=utf-8',
				success: function(html){
					$('#divActionRightVariable').html(html);
					$('#divActionRightConstValue').html(null);
					$('#divActionRightEnumValue').html(null);
					$('#divActionRightFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicAction").on("click","#radioActionRightConstantValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addActionRightConstValue";
		var leftType=$("input[name='radioActionRightType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divActionRightConstValue').html(html);
					$('#divActionRightVariable').html(null);
					$('#divActionRightEnumValue').html(null);
					$('#divActionRightFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicAction").on("click","#radioActionRightEnumerationValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addActionRightEnumValue";
		var leftType=$("input[name='radioActionRightType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divActionRightEnumValue').html(html);
					$('#divActionRightVariable').html(null);
					$('#divActionRightConstValue').html(null);
					$('#divActionRightFunctionValue').html(null);
				}
		});
	});
	
	$("#divAtomicAction").on("click","#radioActionRightFunctionValue",function(){
		var policyJson=JSON.stringify(policy);
		var url="/policy/createAtomicPolicy/addActionRightFunctionValue";
		var leftType=$("input[name='radioActionRightType']:checked").val();	
		$.ajax({type: "POST",
				url: url,
				data: policyJson,
				contentType: "application/json; charset=utf-8",
				success: function(html){
					$('#divActionRightFunctionValue').html(html);
					$('#divActionRightVariable').html(null);
					$('#divActionRightConstValue').html(null);
					$('#divActionRightEnumValue').html(null);
				}
		});
	});
});