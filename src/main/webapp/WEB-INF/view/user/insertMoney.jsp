<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<div class="row" id="insertBox">
	<div class="col-md-5">
		<div class="row mb30">
			<div class="col-md-6 calendar"></div>
			<div class="col-md-6 tar">
				<label for="inputRadio" class="mr10">
					<input name="inoutPut" id="inputRadio" type="radio" checked="checked" value="true" />
					입금
				</label>
				<label for="outputRadio">
					<input name="inoutPut" id="outputRadio" type="radio" value="false" />
					출금
				</label>
			</div>
		</div>
		<div class="row h30 pr10">
			<select name="category" class="col-md-4">
				<option disabled="disabled" selected="selected">선택하세요</option>
				<template v-if="myList.length > 0">
					<option v-for="value in myList">
						{{value}}
					</option>
				</template>
			</select>
			<div class="col-md-6">
				<input name="moneyInput" class="w100" type="text" placeholder="금액을 입력하세요" />
			</div>
			<a @click="insertRow">입력</a>
		</div>
	</div>
	<div class="col-md-7">
		<p class="tar mb15">계좌총액 : {{amount}}</p>
		<table id="moneyTable" class="myTable w100">
			<colgroup>
				<col width="*"/>
				<col width="33%"/>
				<col width="33%"/>
			</colgroup>
			<thead>
				<tr>
					<th class="tac">항목</th>
					<th class="tac">분류</th>
					<th class="tac">입금</th>
					<th class="tac">출금</th>
				</tr>
			</thead>
			<tbody>
				<template v-if="myMoneyList.length > 0">
					<tr v-for="(list, index) in myMoneyList">
						<td>{{index}}</td>
						<td>
							<label :for="'myCategory' + index">
								<input :data-index="index" :id="'myCategory' + index" class="mr10" type="checkbox" />
								{{list.selectCategory}}
							</label>
						</td>
						<template v-if="list.inputRadio">
							<td class="tac">{{list.moneyInput}}</td>
							<td class="tac"></td>
						</template>
						<template v-if="!list.inputRadio">
							<td class="tac"></td>
							<td class="tac">{{list.moneyInput}}</td>
						</template>
					</tr>
				</template>
				<template v-else>
					<tr>
						<td colspan="4">입력된 내역이 없습니다.</td>
					<tr>
				</template>
			</tbody>
		</table>
		<div class="tar mt25 pl20 pr20 pt10 pb10">
			<a class="pl10 pr10 pr05 pb05" @click="insertMoney">선택입력</a>
			<a class="pl10 pr10 pr05 pb05" @click="deleteRow">선택삭제</a>
		</div>
	</div>
</div>

<script src="assets/js/insertMoneyJs.js"> </script>
<%@ include file="../include/footer.jsp" %>



