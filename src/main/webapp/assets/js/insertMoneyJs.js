$(document).ready(function(){
	createList();
	getAmount();
})

var selectCategory;
var moneyInput;
var inputRadio;
var myMLLength;

var insertBox = new Vue({
	el: "#insertBox",
	data: function() {
		return {
			myList: [],
			myMoneyList: [],
			totalList: [],
			amount: 0
		}
	},
	methods: {
		insertMoney : function(){
			insertBox.totalList = [];
			$("#moneyTable td label input:checked").each(function() {
				insertBox.totalList.push(insertBox.myMoneyList[$(this).data("index")]);
			});
			if(insertBox.totalList.length > 0){
				$.ajax({
					url: "insertMoney",
					method: "post",
					data: JSON.stringify(insertBox.totalList),
					contentType: "application/json;charset=UTF-8"
				}).done(function(result){
					var myNumList = result.myNumList;
					for(var i = 0; i < myNumList.length; i++){
						$("#myCategory" + myNumList[i]).parent().parent().parent().remove();
					}
					insertBox.amount = result.amount;
					alert(result.msg);
				})
			}else{
				alert("선택된 행이 없습니다.")
			}
		},
		insertRow : function(){
			
			moneyInput = $("input[name='moneyInput']").val().trim();
			moneyInput = moneyInput.replaceAll(",","");
			selectCategory = $("select[name='category']").val();
			inputRadio = JSON.parse($("input[name='inoutPut']:checked").val());
			
			makeNewList(insertBox.myMoneyList, selectCategory, moneyInput, inputRadio);

			myMLLength = insertBox.myMoneyList.length-1;
			
			if(selectCategory == null){
				$("select[name='category']").focus();
				alert("카테고리 선택은 필수항목입니다.");
			}else if(moneyInput == ""){
				$("input[name='moneyInput']").focus();
				alert("금액 입력은 필수항목입니다.");
			}
			
		},
		deleteRow : function(){
			$("#moneyTable input:checked").each(function(){
				$(this).parent().parent().parent().remove();
			})
		}
	}
})

function makeNewList(lists, cate, money, bool){
	lists.push({"selectCategory":cate,"moneyInput":money,"inputRadio":bool, "listNumber": insertBox.myMoneyList.length});
}

function createList() {
	insertBox.myList = [];
	insertBox.myMoneyList = [];
	$.ajax({
		url : "cateList",
		method: "post",
		contentType: "application/json"
	}).done(function(categoryList){
		for(var i = 0; i < categoryList.length; i++){
			insertBox.myList.push(categoryList[i]);
		}
	})
}

function getAmount(){
	$.ajax({
		url : "getAmount",
		contentType: "application/json"
	}).done(function(totalAmount){
		insertBox.amount = totalAmount;
	})
}

var money;
var myMoney;

$("input[name='moneyInput']").keyup(function () {
	money = $(this).val()
	money = money.replaceAll("," , "");
	myMoney = money.replace(/[^0-9\,]/g, "");
	myMoney = myMoney.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	$("input[name='moneyInput']").val(myMoney);
});


