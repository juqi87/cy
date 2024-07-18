
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE管理控台</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">

    <link rel="stylesheet" href="/adminlte/themes/v3/plugins/fontawesome-free/css/all.min.css">

    <link rel="stylesheet" href="/adminlte/themes/v3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">

    <link rel="stylesheet" href="/adminlte/themes/v3/dist/css/adminlte.min.css?v=3.2.0">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="/adminlte/themes/v3/index2.html"><b>畅由</b>管理控台</a>
    </div>

    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">Sign in to start your session</p>
            <form action="/adminlte/themes/v3/index3.html" method="post">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" id="user" name="user" placeholder="账号">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="remember">
                            <label for="remember">
                                记住我
                            </label>
                        </div>
                    </div>

                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">登陆</button>
                    </div>

                </div>
            </form>
            <div class="social-auth-links text-center mb-3">
<#--                <p>- OR -</p>-->
<#--                <a href="#" class="btn btn-block btn-primary">-->
<#--                    <i class="fab fa-facebook mr-2"></i> Sign in using Facebook-->
<#--                </a>-->
<#--                <a href="#" class="btn btn-block btn-danger">-->
<#--                    <i class="fab fa-google-plus mr-2"></i> Sign in using Google+-->
<#--                </a>-->
            </div>

<#--            <p class="mb-1">-->
<#--                <a href="forgot-password.html">I forgot my password</a>-->
<#--            </p>-->
<#--            <p class="mb-0">-->
<#--                <a href="register.html" class="text-center">Register a new membership</a>-->
<#--            </p>-->
        </div>

    </div>
</div>


<script src="/adminlte/themes/v3/plugins/jquery/jquery.min.js"></script>

<script src="/adminlte/themes/v3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="/adminlte/themes/v3/dist/js/adminlte.min.js?v=3.2.0"></script>

<script>
    $(function () {
        $('form').submit(function (e) {
            e.preventDefault();
            var user = $('#user').val();
            var pwd = $('#pwd').val();

            if (user == '' || pwd == ''){
                alert('账号或密码不能为空');
            }

            $.ajax({
                url: '/login',
                type: 'post',
                data: {
                    user: user,
                    pwd: pwd
                },
                success: function (data) {
                    if (data.code == '000') {
                        window.location.href = '/queryCyOrdLogList';
                    } else {
                        alert(data.msg);
                    }
                }
            })



        })
    })

</script>

</body>
</html>
