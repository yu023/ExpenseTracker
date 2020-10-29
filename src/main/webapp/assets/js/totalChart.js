$(document).ready(function(){

	var now = new Date();
	var nowYear = now.getFullYear();
	var nowMonth = now.getMonth() + 1; 
	
	createList(nowYear, nowMonth);
	createCal();
	
})

var selectCategory, moneyInput, inputRadio, myMLLength, searchMonth, searchYear, yearMonth;
var colors = ["red", "orange", "gold", "green", "blue","skyblue", "pink","gray","brown"];

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
		createGraph : function(){
			searchYear = $(".ui-datepicker-year").val();
			searchMonth = parseInt($(".ui-datepicker-month").val()) + 1;
			createList(searchYear, searchMonth);
		}
	}
})

function createCal(){
	$( "#datepicker" ).datepicker({
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        dateFormat: 'yy-mm',
        onClose: function(dateText, inst) { 
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        },
        beforeShow : function(input, inst) {
            if ((datestr = $(this).val()).length > 0) {
                actDate = datestr.split('-');
                year = actDate[0];
                month = actDate[1]-1;
                $(this).datepicker('option', 'defaultDate', new Date(year, month));
                $(this).datepicker('setDate', new Date(year, month));
            }
        }
    });
}

function makeNewList(selectM){
	for(var i = 0; i < selectM.length; i++ ){
		insertBox.myMoneyList.push({
			"selectCategory":selectM[i].bb_category,
			"moneyInput":selectM[i].bb_money,
			"inputRadio":selectM[i].bb_type, 
			"listNumber": selectM[i].bb_id,
			"amount": selectM[i].bb_amount,
			"date": selectM[i].bb_create_date
		});
	}
}

var yearChart, chartData;
var chartCate = [];

function createChart(result) {

	chartData = {backgroundColor : [], data : []};
	chartCate = [];
	
	for(var i = 0; i < result.length; i++){
		chartCate.push(result[i].bb_category);
		chartData.backgroundColor.push(colors[i]);
		chartData.data.push(result[i].bb_money);
	}
	
	$("#pie-wrap *").remove();
	$("#pie-wrap").append('<canvas id="pie-chart" height="150"></canvas>');
	
	yearChart = new Chart(document.getElementById("pie-chart"), {
		type: 'pie',
		data: {
		  labels: chartCate,
		  datasets: [chartData]
		},
		options: {
		  title: {
			display: true,
			text: 'Predicted world population (millions) in 2050'
		  }
		}
	});
}

function createList(ny, nm) {
	insertBox.myList = [];
	insertBox.myMoneyList = [];
	
	yearMonth = JSON.parse($("input[name='timeBtn']:checked").val());
	
	$.ajax({
		url : "createList",
		method: 'post',
		data : JSON.stringify({'year' : yearMonth, 'searchYear':ny, 'searchMonth':nm }),
		contentType: "application/json"
	}).done(function(result){
		createChart(result.selectGBCategory);
		makeNewList(result.selectMoney);
	})
}


