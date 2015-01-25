<html>
<head>
	<title>Some Header</title>
	<script type="text/javascript" src=${pageContext.request.contextPath}/resources/js/jquery.js></script>
	<script type="text/javascript" src=${pageContext.request.contextPath}/resources/js/jquery-ui.min.js></script>

</head>
<body>

	<h1>${message}</h1>

	<script type="text/javascript">

		$(document).ready(function(){
			$("#msgid").html("This is Hello World by JQuery");
		});

	</script>
	<div id="msgid">
	</div>
</body>
</html>