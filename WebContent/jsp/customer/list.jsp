﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
	function delOne(custId){
		var sure = window.confirm("确定删除吗？");
		if(sure){
			window.location.href="${pageContext.request.contextPath}/customer/removeCustomer.action?custId="+custId;
		}
	}
</SCRIPT>

<style type="text/css">
	td div{
		margin-top:15px;
	}
	
	div a{
		border:1px solid lightblue;
		padding:3px 3px 3px 3px;
		border-radius:25%;
	}
	
	a:active{
		border-left:3px solid lightblue;
		border-top:3px solid lightblue;
		border-right:0px solid white;
		border-bottom:0px solid white;
	}
</style>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<s:debug></s:debug>
	<s:form action="findAllCustomer" namespace="/customer">
		<s:hidden name="num" value="" id="pagenum"></s:hidden>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<td>客户名称：</td>
														<td>
															<s:textfield name="custName" class="textbox" id="sChannel2" style="WIDTH: 80px" maxLength="50" />
														</td>
														<td>所属行业 ：</td>
														<td>
															<s:textfield name="custIndustry" class="textbox" id="sChannel2" style="WIDTH: 80px" maxLength="50" />
														</td>								
														<td>信息来源 ：</td>
														<td>
															<s:select name="custSource.dictId" list="custSources" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="---请选择---"  
															class="textbox" id="sChannel2" style="WIDTH: 140px"></s:select>
														</td>
														<td>客户级别：</td>
														<td>
															<s:select name="custLevel.dictId" list="custLevels" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="---请选择---"  
															class="textbox" id="sChannel2" style="WIDTH: 140px"></s:select>
														</td>
													<TD><s:submit value="筛选"/></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=grid style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>所属行业</TD>
													<TD>联系地址</TD>
													<TD>联系电话</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="page.records">
												<TR style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${custName }</TD>
													<TD>${custLevel.dictItemName }</TD>
													<TD>${custSource.dictItemName }</TD>
													<TD>${custIndustry }</TD>
													<TD>${custAddress }</TD>
													<TD>${custPhone }</TD>
													<TD>
													<s:a action="editUICustomer" namespace="/customer">
														<s:param name="custId" value="%{custId}"></s:param>
														修改
													</s:a>
													&nbsp;&nbsp;
													<s:a href="javascript:delOne('%{custId}')">删除</s:a>
													</TD>
												</TR>	
												</s:iterator>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<td align="center">
										<%-- 分页的开始 --%>
											<%@ include file="/jsp/commons/page.jsp" %>
										<%-- 分页的结束 --%>
									</td>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
					<TD align=middle width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</s:form>
</BODY>
</HTML>
