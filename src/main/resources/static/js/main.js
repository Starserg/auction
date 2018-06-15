function ajaxBuyOne(productId) {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

    $.ajax({
        method: "GET",
        url: "/buyOne",
        data: {id: productId},
        dataType: 'json',
        success: function (data) {
            alert(data);
        },
        error: function () {
            alert('error!');
        }
    });
}

function ajaxBuy(productId) {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

    $.ajax({
        method: "GET",
        url: "/buy",
        data: {id: productId},
        dataType: 'json',
        success: function (data) {
            alert(data);
            document.location.reload();
        },
        error: function () {
            alert('error!');
        }
    });
}