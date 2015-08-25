<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>${viewModel.title}</title>
        
        <script type="text/javascript" src="<c:url value="/static/jquery-2.1.0.min.js" />"></script>
        
        <script type="text/javascript" src="<c:url value="/static/platformui2/platformui.2.0.min.js" />"></script>
        <link rel="stylesheet" href="<c:url value="/static/platformui2/platformui.2.0.min.css" />" />
        <script type="text/javascript" src="<c:url value="/static/zportal/extensions.js" />"></script>
        
        <script type="text/javascript" src="<c:url value="/static/requirejs.js" />"></script>
        
        <script type="text/javascript" src="<c:url value="/static/shell/shell.js" />"></script>
        <link rel="stylesheet" href="<c:url value="/static/shell/shell.css" />" />
    </head>
    <body>
        <script type="text/javascript">
            $(function () {
                ZP.Shell.init('${viewModel.rootUrl}', '${viewModel.containerName}');
            });
        </script>
    </body>
</html>
