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
            $('#mm').menu('show', {
                left: 200,
                top: 100
            });

        })


    </script>

</head>
<body>
<h1>menu</h1>

<div id="mm" class="easyui-menu" style="width:120px;">
    <div>New</div>
    <div>
        <span>Open</span>
        <div style="width:150px;">
            <div><b>Word</b></div>
            <div>Excel</div>
            <div>PowerPoint</div>
        </div>
    </div>
    <div data-options="iconCls:'icon-save'">Save</div>
    <div class="menu-sep"></div>
    <div>Exit</div>
</div>


</body>
</html>