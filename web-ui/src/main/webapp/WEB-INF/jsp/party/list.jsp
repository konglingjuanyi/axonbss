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
    <title>Parties</title>
    <script type="text/javascript" src="${ctx}/js/jquery.tablesorter.min.js"></script>
    <script>
        $(function () {
            $("table#all-parties").tablesorter({ sortList:[
                [0, 0]
            ] });
        });
    </script>
</head>
<body>
<content tag="title">All parties</content>
<content tag="tagline">Choose the party to start</content>
<content tag="breadcrumb">
    <ul class="breadcrumb">
        <li><a href="${ctx}/">Home</a> <span class="divider">/</span></li>
        <li class="active">Parties</li>
    </ul>
</content>

<p>You can sort the table by clicking on the headers.</p>
<table class="zebra-striped" id="all-parties">
    <thead>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Status</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td><c:out value='${item.name}'/></td>
            <td><c:out value='${item.type}'/></td>
            <td><c:out value='${item.state}'/></td>
            <td><a href="${ctx}/party/<c:out value='${item.partyId}'/>">details</a></td>
            <td><a href="${ctx}/party/rename/<c:out value='${item.partyId}'/>">rename</a></td>
            <td><a href="${ctx}/party/terminate/<c:out value='${item.partyId}'/>">terminate</a></td>
            <td><a href="${ctx}/customer/createCustomerFromParty/<c:out value='${item.partyId}'/>">Create Customer</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="row">
        <div class="span14">
            <p>
                <a class="btn primary"
                   href="${ctx}/party/createIndividual">Create Individual &raquo;</a>
                <a class="btn primary"
                   href="${ctx}/party/createLegal">Create Legal &raquo;</a>
            </p>
        </div>
    </div>
</body>
</html>
