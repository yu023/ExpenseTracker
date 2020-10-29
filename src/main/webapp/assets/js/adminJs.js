$(document).ready(function(){
	initSet();
})

var cateList = new Vue({
  el: '#categoryList',
  data: function() {
		return {
		  myList: []
		}
	},
   methods: {
   
   	  doCreate : function(){
   	  	    
   	  		var cateStr = $("input[name='addCate']").val();
   	  		
			$.ajax({
				method: "post",
				url: "addCateForm",
				data: JSON.stringify({addCate:cateStr}),
				contentType : "application/json"
			}).done(function(categoryList){
		  	  	 updateList(categoryList);
		  	 })
		},
		
	  doDelete : function(delStr){
	  	  var result = confirm("'" + delStr + "' 카테고리에서 삭제하시겠습니까?");
	  	  
			if(result){
		  	  $.ajax({
		  	  	 method: "post",
		  	  	 url: "removeCate",
		  	  	 data: JSON.stringify({removeCate : delStr}),
		  	  	 contentType : "application/json"
		  	  }).done(function(categoryList){
		  	  	 updateList(categoryList);
		  	  })
			}
	  }
	  
   }
})

function initSet(){
	createList();
}

function createList(){

	$.ajax({
		method: "post",
		url: "cateList",
		contentType : "application/json"
	}).done(function(categoryList){
	
		cateList.myList = [];
		
		updateList(categoryList);
	})

}

function updateList(categoryList){
	cateList.myList = [];
	for(var i = 0; i < categoryList.length; i++){
		cateList.myList.push(categoryList[i]);
	}
}