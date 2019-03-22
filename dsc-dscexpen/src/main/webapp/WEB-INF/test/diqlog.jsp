<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5.4.2/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.2/themes/icon.css">

    <script type="text/javascript">

        $(function () {
           $('#dd').dialog({
                title: 'My Dialog',
                width: 400,
                height: 200,
                closed: false,
                cache: false,
              //  href: "/myWeb/easyui/selectAllUser",
                modal: true
            });
       //     $('#dd').dialog('refresh', 'new_content.php');

        })


    </script>

</head>
<body>

<div id="dd">Dialog Content.</div>

</body>
</html>