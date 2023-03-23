<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<table class="table table-sm table-dark">
    <thead>
    <tr>
        <th scope="col">Mã Bệnh Nhân</th>
        <th scope="col">Mã Bệnh Án</th>
        <th scope="col">Tên Bệnh Nhân</th>
        <th scope="col">Ngày Nhập Viện</th>
        <th scope="col">Ngày Ra Viện</th>
        <th scope="col">Lý Do</th>
    </tr>
    </thead>
    <tbody>
   <c:forEach items="listBenhNhan" var="benhNhan">
       <tr>
           <th scope="row">${benhNhan.getMaBenhNhan}</th>
           <th scope="row">${benhNhan.getMaBenhAn}</th>
           <th scope="row">${benhNhan.getTenBenhNhan}</th>
           <th scope="row">${benhNhan.getNgayNhapVien}</th>
           <th scope="row">${benhNhan.getNgayRaVien}</th>
           <th scope="row">${benhNhan.getLyDo}</th>
       </tr>
   </c:forEach>
    </tbody>
</table>
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
</body>
</html>