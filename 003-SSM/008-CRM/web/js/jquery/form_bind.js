function loadData(formId,json){
		//var obj = eval("("+jsonStr+")");
		var obj = json;
		var key,value,tagName,type,arr;
		for(x in obj){
			key = x;
			value = obj[x];

			$("#" + formId + " [name='"+key+"']," + "#" + formId + " [name='"+key+"[]']").each(function(){
				tagName = $(this)[0].tagName;
				type = $(this).attr('type');
				if(tagName=='INPUT'){
					if(type=='radio'){
						$(this).attr('checked',$(this).val()==value);
					}else if(type=='checkbox'){
						arr = value.split(',');
						for(var i =0;i<arr.length;i++){
							if($(this).val()==arr[i]){
								$(this).attr('checked',true);
								break;
							}
						}
					}else{
						$(this).val(value);
					}
				}else if(tagName=='SELECT' || tagName=='TEXTAREA'){
					$(this).val(value);
				}

			});
		}
	}