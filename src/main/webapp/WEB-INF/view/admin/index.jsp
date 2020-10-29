<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<div id="categoryList" class="row">
	<ul class="col-md-4">
		<template v-if="myList.length != 0">
			<li v-for="value in myList">
				{{value}} <span v-on:click="doDelete(value)"><i class="far fa-times-circle"></i></span>
			</li>
		</template>
		<template v-else>
			<li>등록된 카테고리가 없습니다.</li>
		</template>
	</ul>
	<div class="col-md-4">
		<div class="col-md-9">
			<input name="addCate" class="w100" type="text" />
		</div>
		<div class="col-md-3">
			<a class="w100" v-on:click="doCreate()">입력</a>
		</div>
	</div>
</div>
<script src="assets/js/adminJs.js"></script>
<%@ include file="../include/footer.jsp" %>
