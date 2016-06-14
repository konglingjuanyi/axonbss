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
    <title>Legal Customer detail</title>
</head>
<body>
<div class="row">
    <div class="span14">
		<table>
			<tr>
		    	<td><spring:message code="legalCustomer.legalName"/>:</td>
		    	<td><c:out value="${legalCustomer.legalName}"/></td>
			</tr>
			<tr>
		    	<td><spring:message code="legalCustomer.parentLegalName"/>:</td>
		    	<td><c:out value="${legalCustomer.parentLegalName}"/></td>
			</tr>
			<tr>
		    	<td><spring:message code="customer.serviceCode"/>:</td>
		    	<td><c:out value="${legalCustomer.serviceCode}"/></td>
			</tr>
			<tr>
		    	<td><spring:message code="customer.serviceLevel"/>:</td>
		    	<td><c:out value="${legalCustomer.serviceLevel}"/></td>
			</tr>
			<tr>
		    	<td><spring:message code="customer.brand"/>:</td>
		    	<td><c:out value="${legalCustomer.brand}"/></td>
			</tr>
			<tr>
		    	<td>State:</td>
		    	<td><c:out value="${legalCustomer.state}"/></td>
			</tr>
		</table>
    </div>
</div>		
<content tag="breadcrumb">
    <ul class="breadcrumb">
        <li><a href="${ctx}/">Home</a> <span class="divider">/</span></li>
        <li><a href="${ctx}/customer">Customers</a> <span class="divider">/</span></li>
    </ul>
</content>

</body>
</html>