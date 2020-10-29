<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
.ui-datepicker .ui-datepicker-buttonpane button.ui-datepicker-current,
.ui-datepicker table{
    display: none;
}
.ui-widget.ui-widget-content{
	border: none;
}
</style>
<div id="insertBox" class="row">
	<div class="col-md-6">
		<div id="pie-wrap">
			<canvas id="pie-chart" height="150"></canvas>		
		</div>
		<div id="datepicker">
		</div>
		<a @click="createGraph" class="inblock mt15 pl15 pr15">통계보기</a>
	</div>
	<div class="col-md-6">
		<div class="mb15">
			<label class="inblock mr15" for="yearBtn">
				<input id="yearBtn" name="timeBtn" value="false" checked="checked" type="radio"/>
				월별 그래프
			</label>
			<label class="inblock" for="monthBtn">
				<input id="monthBtn" name="timeBtn" value="true" type="radio"/>
				연도별 그래프
			</label>
		</div>
		<table id="moneyTable" class="myTable w100">
			<colgroup>
				<col width="25%"/>
				<col width="25%"/>
				<col width="25%"/>
				<col width="25%"/>
			</colgroup>
			<thead>
				<tr>
					<th class="tac">분류</th>
					<th class="tac">입금</th>
					<th class="tac">출금</th>
					<th class="tac">총액</th>
				</tr>
			</thead>
			<tbody>
				<template v-if="myMoneyList.length > 0">
					<tr v-for="(list, index) in myMoneyList">
						<td>
							{{list.selectCategory}}
							<br>{{list.date}}
						</td>
						<template v-if="list.inputRadio">
							<td class="tac">{{list.moneyInput}}</td>
							<td class="tac"></td>
						</template>
						<template v-if="!list.inputRadio">
							<td class="tac"></td>
							<td class="tac">{{list.moneyInput}}</td>
						</template>
						<td class="tac">{{list.amount}}</td>
					</tr>
				</template>
				<template v-else>
					<tr>
						<td colspan="5">입력된 내역이 없습니다.</td>
					<tr>
				</template>
			</tbody>
		</table>
	</div>
</div>

<script src="assets/plugin/chart/bootstrap.min.js"></script>
<script src="assets/plugin/chart/feather.min.js"></script>
<script src="assets/plugin/chart/perfect-scrollbar.jquery.min.js"></script>
<script src="assets/plugin/chart/custom.min.js"></script>
<script src="assets/plugin/chart/Chart.min.js"></script>
<script src="assets/js/totalChart.js"></script>
<%@ include file="../include/footer.jsp" %>



