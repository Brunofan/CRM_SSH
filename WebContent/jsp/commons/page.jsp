<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function topage(num){
		//1.给表单中的提供的一个隐藏域赋值，用于提供当前页
		document.getElementById("pagenum").value = num;
		//2.提交表单
		document.forms[0].submit();
	}
</script>
<div id = "pagediv">
	<a href="javascript:topage(1)">首页</a>
	<a href="javascript:topage('${page.prePageNum}')">上一页</a>
	<%-- 遍历显示页号 --%>
	<s:iterator begin="%{page.beginPageNum}" end="%{page.endPageNum}" var="snum">
		<a href="javascript:topage('${snum}')">${snum }</a>
	</s:iterator>
	<a href="javascript:topage('${page.nextPageNum}')">下一页</a>
	<a href="javascript:topage('${page.totalPageNum}')">末页</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	第${page.currentPageNum }页/共${page.totalPageNum}页
</div>