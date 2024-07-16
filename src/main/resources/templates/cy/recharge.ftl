
<html>
    <head>
        <script src="/adminlte/themes/v3/plugins/jquery/jquery.min.js"></script>
    </head>
    <body>

        <form action="/recharge" method="post">
            东航卡号：<input type="text" name="muCard" id="muCard" value="">
            <br>
            充值积分：<input type="number" name="points" id="points" value="">
            <br>
            <input type="button" id="submitBtn" value="提交">
        </form>
    </body>

    <script type="application/javascript">
        //点击提交按钮，进行ajax表单提交
        $("#submitBtn").click(function () {
            let muCard = $("#muCard").val();
            let points = $("#points").val();
            console.log(muCard, points)
            $.ajax({
                url: "doRecharge",
                type: "post",
                data: {
                    muCard: muCard,
                    points: points
                },
                success: function (data) {
                    alert(data);
                }
            })
        })



    </script>

</html>