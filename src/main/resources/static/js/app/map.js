var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        var container = document.getElementById('map');
        var options = {
            center: new kakao.maps.LatLng(33.450701, 126.570667),
            level: 3
        };

        var map = new kakao.maps.Map(container, options);
    },
    save : function () {
        var data = {
            mapnum: $('#mapnum').val(),
            title: $('#title').val(),
            content: $('#content').val(),
            gps_x: $('#gps_x').val(),
            gps_y: $('#gps_y').val(),
            mapdate: $('#mapdate').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/maps',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();