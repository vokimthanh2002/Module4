<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="row flex-column align-items-end mr-5">
    <nav class="navbar navbar-light bg-light justify-content-end">
        <button class="btn btn-success" type="submit" onclick="window.location.href='/sanpham?action=create'"> Them moi san pham </button> &emsp;
        <form  class="form-inline" method="get" >
            <input class="form-control mr-sm-2" type="search"  placeholder="Ten benh nhan" aria-label="Search" name="inputSearch">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
        </form>
    </nav>
</div>
<table class="table table-sm table-dark" class="table" id="tableStudent">
    <thead>
    <tr>
        <th scope="col">Id San Pham</th>
        <th scope="col">Ten San Pham</th>
        <th scope="col">Gia</th>
        <th scope="col">So Luong</th>
        <th scope="col">Mau Sac</th>
        <th scope="col">Mo Ta</th>
        <th scope="col">Danh Muc</th>
        <th scope="col">Chuc Nang</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sanPhamList}" var="sanpham">
        <tr>
            <td scope="row"><a href="/sanpham?action=view&id=${sanpham.getIdSanPham()}">${sanpham.getIdSanPham()}</a></td>
            <th scope="row">${sanpham.getTenSanPham()}</th>
            <th scope="row">${sanpham.getGia()}</th>
            <th scope="row">${sanpham.getSoLuong()}</th>
            <th scope="row">${sanpham.getMauSac()}</th>
            <th scope="row">${sanpham.getMoTa()}</th>
            <th scope="row">${sanpham.getTenDanhMuc()}</th>
            <th scope="row">
                <button type="submit" class="btn btn-info" onclick="window.location.href='/sanpham?action=edit&id=${sanpham.getIdSanPham()}'"> Chỉnh Sửa </button>
                <button type="submit" class="btn btn-danger" data-toggle="modal"
                        data-target="#exampleModal" onclick="onDelete(${sanpham.getIdSanPham()})"> Xóa </button>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xóa khách hàng này!</h5>
            </div>
            <form method="post" action="/benhnhan?action=delete">
                <input type="hidden" name="idDelete" id="id">
                <div class="modal-body">
                    <p>Bạn có thật sự muốn xóa</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>

        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            'searching': false,
            'pageLength' : 10
        })
    })
    function onDelete(id) {
        document.getElementById("id").value = id;
    }

</script>

</body>
</html>