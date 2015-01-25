<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 25/01/2015
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Auto Complete</title>
  <script type="text/javascript" src=${pageContext.request.contextPath}/resources/js/jquery.js></script>
  <script type="text/javascript" src=${pageContext.request.contextPath}/resources/js/jquery-ui.min.js></script>
</head>

<body>
<h2>Spring MVC + jQuery + Autocomplete example</h2>
<!-- Autocomplete -->
<h2 class="demoHeaders">Autocomplete</h2>
<div>
  <input id="country" title="Lang">
</div>
<script>
$(document).ready(function() {

$( "#country" ).autocomplete({
source: '${pageContext. request. contextPath}/getTags'
});})
</script>
</body>
</html>
