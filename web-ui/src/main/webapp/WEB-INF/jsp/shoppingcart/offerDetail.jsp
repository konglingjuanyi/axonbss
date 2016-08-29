<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<html>
<head>
    <title>Offer details</title>
</head>
<body>
<div class="row">
    <div class="span14">
    <form:form commandName="cartItem" action="${ctx}/shoppingcart/addToCart/${cartItem.shoppingCartId}" method="Post">
		<table>
			<tr>
		    	<td><spring:message code="cartItem.offerDetail.name"/>:</td>
		    	<td><c:out value="${cartItem.offerDetail.name}"/></td>
			</tr>
			<tr>
		    	<td><spring:message code="cartItem.offerDetail.price"/>:</td>
		    	<td><c:out value="${cartItem.offerDetail.price}"/></td>
			</tr>
			<tr>
		    	<td>
			    	<table>               
	            	<c:forEach items="${cartItem.offerDetail.productCharacterValues}" var="characterValue">
		                <tr>
		                    <td><c:out value="${characterValue.characteristicSpecName}"/>:</td>
		                    <td><form:input path="characterValue.value" /></td>
		                    <td><form:errors path="characterValue.value" cssClass="errorBox"/></td>
		                </tr>
	            	</c:forEach>
            	</td>
            	</table>
			</tr>
			<tr>
		    	<td><spring:message code="cartItem.quantity"/>:</td>
		    	<td><c:out value="${cartItem.quantity}"/></td>
			</tr>
			<tr>
		    	<td><spring:message code="cartItem.price"/>:</td>
		    	<td><c:out value="${cartItem.price}"/></td>
			</tr>
			<tr>
                    <td colspan="3">
                        <input class="btn primary" type="submit" name="submit" value="Add To Cart"/>
                        <input class="btn" type="reset" name="reset" value="Reset"/>
                    </td>
                </tr>
		</table>
	</form:form>
    </div>
</div>		
</body>
</html>