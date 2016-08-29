<%@include file="../include.jsp" %>
<%--
  ~ Copyright (c) 2010-2012. Axon Framework
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~     http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  --%>
<meta http-equiv="refresh" content="5">
<html>
<head>
    <title>Parties</title>
    <script type="text/javascript" src="${ctx}/js/jquery.tablesorter.min.js"></script>
    <script>
        $(function () {
            $("table#shopping-cart-list").tablesorter({ sortList:[
                [0, 0]
            ] });
        });
    </script>
</head>
<body>
<content tag="title">Shopping cart list</content>
<content tag="tagline">Choose the party to start</content>
<content tag="breadcrumb">
    <ul class="breadcrumb">
        <li><a href="${ctx}/">Home</a> <span class="divider">/</span></li>
        <li class="active">Shopping cart list</li>
    </ul>
</content>

<p>You can sort the table by clicking on the headers.</p>
<table class="zebra-striped" id="shopping-cart-list">
    <thead>
    <tr>
        <th>Offering Name</th>
        <th>Product Characteristic</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
     	<form:form commandName="item" method="Post">
        <tr>
            <td><spring:message code="item.offerDetail.name"/></td>
            <td>
                <table>               
            	<c:forEach items="${item.offerDetail.productCharacterValues}" var="characterValue">
	                <tr>
	                    <td><c:out value="${characterValue.characteristicSpecName}"/>:</td>
	                    <td><form:input path="characterValue.value" /></td>
	                    <td><form:errors path="characterValue.value" cssClass="errorBox"/></td>
	                </tr>
            	</c:forEach>
            	</table>
            </td>
            <td><c:out value='${item.quantity}'/></td>
            <td><c:out value='${item.price}'/></td>
            <td><a href="${ctx}/shoppingcart/increase">Increase</a></td>
            <td><a href="${ctx}/shoppingcart/decrease">Decrease</a></td>
            <td><a href="${ctx}/shoppingcart/deleteCartItem">DeleteItem</a></td>
        </tr>
    </c:forEach>
    </form:form>
    </tbody>
</table>
</html>
