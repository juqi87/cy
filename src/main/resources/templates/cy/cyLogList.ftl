<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理控台</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">

    <link rel="stylesheet" href="/adminlte/themes/v3/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="/adminlte/themes/v3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="/adminlte/themes/v3/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <link rel="stylesheet" href="/adminlte/themes/v3/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
    <link rel="stylesheet" href="/adminlte/themes/v3/dist/css/adminlte.min.css?v=3.2.0">

    <style>
        .text-center {
            text-align: center;
            white-space: nowrap;
        }
    </style>

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <nav class="main-header navbar navbar-expand navbar-white navbar-light">

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="/adminlte/themes/v3/index3.html" class="nav-link">Home1</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">

            <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline">
                        <div class="input-group input-group-sm">
                            <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">

                        <div class="media">
                            <img src="/adminlte/themes/v3/dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>

                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">

                        <div class="media">
                            <img src="/adminlte/themes/v3/dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>

                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">

                        <div class="media">
                            <img src="/adminlte/themes/v3/dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">The subject goes here</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>

                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 new messages
                        <span class="float-right text-muted text-sm">3 mins</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 friend requests
                        <span class="float-right text-muted text-sm">12 hours</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 new reports
                        <span class="float-right text-muted text-sm">2 days</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>


    <aside class="main-sidebar sidebar-dark-primary elevation-4">

        <a href="/adminlte/themes/v3/index3.html" class="brand-link">
            <img src="/adminlte/themes/v3/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">管理控台</span>
        </a>

        <div class="sidebar">

            <#--            <div class="user-panel mt-3 pb-3 mb-3 d-flex">-->
            <#--                <div class="image">-->
            <#--                    <img src="/adminlte/themes/v3/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">-->
            <#--                </div>-->
            <#--                <div class="info">-->
            <#--                    <a href="#" class="d-block">Alexander Pierce</a>-->
            <#--                </div>-->
            <#--            </div>-->

            <div class="form-inline">
                <div class="input-group" data-widget="sidebar-search">
                    <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-sidebar">
                            <i class="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>

            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">


                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                订单管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/recharge" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>积分充值</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>畅由订单查询</p>
                                </a>
                            </li>

                        </ul>
                    </li>

                </ul>
            </nav>

        </div>

    </aside>

    <div class="content-wrapper">

        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>订单查询</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">订单查询</li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>

        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
<#--                            <div class="card-header">-->
<#--                                <h3 class="card-title">DataTable with minimal features & hover style</h3>-->
<#--                            </div>-->

                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                </table>
                            </div>

                        </div>



                    </div>

                </div>

            </div>

        </section>

    </div>

    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.2.0
        </div>
        <strong>Copyright &copy; 2024 <a href="#">河北臻辰信息</a>.</strong> All rights reserved.
    </footer>

    <aside class="control-sidebar control-sidebar-dark">

    </aside>

</div>


<script src="/adminlte/themes/v3/plugins/jquery/jquery.min.js"></script>

<script src="/adminlte/themes/v3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="/adminlte/themes/v3/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="/adminlte/themes/v3/plugins/jszip/jszip.min.js"></script>
<script src="/adminlte/themes/v3/plugins/pdfmake/pdfmake.min.js"></script>
<script src="/adminlte/themes/v3/plugins/pdfmake/vfs_fonts.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="/adminlte/themes/v3/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>

<script src="/adminlte/themes/v3/dist/js/adminlte.min.js?v=3.2.0"></script>

<#--<script src="/adminlte/themes/v3/dist/js/demo.js"></script>-->
<script>
    $(function () {
        let draw;
        let pageNum = 1;
        let pageSize = 10;

        let table = $('#example2').DataTable({
            "paging": true,
            "pageLength": 10,
            "lengthMenu": [ 10, 25, 50, 100 ],
            "pagingType": "full_numbers",
            "lengthChange": false,

            "searching": false,
            "ordering": false,
            "info": true,
            "autoWidth": false,
            "responsive": true,
            "processing": true,
            "serverSide": true,
            <#--"data": ${vos!''},-->
            "columns": [
                { "title": "日期", "data": "transDate", "className": "text-center" },
                { "title": "流水号", "data": "transSeqId", "className": "text-center" },
                { "title": "东航卡号", "data": "muCard", "className": "text-center" },
                { "title": "积分", "data": "points", "className": "text-center" },
                { "title": "IP地址", "data": "ipAddress", "className": "text-center" },
                { "title": "状态", "data": "statDesc", "className": "text-center" },
                { "title": "商户号", "data": "partnerId", "className": "text-center" },
                { "title": "订单号", "data": "ordId" , "className": "text-center" },
                { "title": "充值时间", "data": "createAtDesc", "className": "text-center" },
                { "title": "上次更新", "data": "updateAtDesc", "className": "text-center" },
                { "title": "响应码", "data": "respCode", "className": "text-center" },
                { "title": "畅由响应信息", "data": "respMsg", "className": "text-center" }
            ],
            "ajax": {
                "url": '/queryCyOrdLogList',
                "type": 'POST',
                "data": function(d){
                    console.log('d===>'+ JSON.stringify(d));
                    console.log('start'+d.start);
                    console.log('lenngth'+d.length);
                    d.pageNum = Math.ceil(d.start / d.length) + 1; // 计算页码（注意：DataTables的页码是从0开始的，但通常我们习惯从1开始）
                    d.pageSize = d.length;
                    return d;
                }
            },
            "language": //把文字变为中文
                {
                    "sProcessing": "加载中...",
                    "sLengthMenu": "显示条数： _MENU_ ",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页", //首页
                        "sPrevious": "<", //上一页
                        "sNext": ">", //下一页
                        "sLast": "尾页" //尾页
                    },
                },
        });

        $('#example2').on('page.dt', function(){
            console.log('翻页');
            var pageNum = $(this).data('dt-idx') - 1; // 获取页码，从1开始，需减1
            if (pageNum >= 0) {
                table.page(pageNum).draw(false); // 跳转到指定页码并刷新表格
            }
            // table.ajax.reload();
        }).dataTable();
    });
</script>
</body>
</html>
