$(document).ready(function(){
	$("#btnAddAtomicCondition").click(function(){
		$.post("/policy/createAtomicPolicy",
			{addAtomicCondition:"addAtomicCondition"},
			function(data,status) {
			    alert(status);
			}
		);
	});
});