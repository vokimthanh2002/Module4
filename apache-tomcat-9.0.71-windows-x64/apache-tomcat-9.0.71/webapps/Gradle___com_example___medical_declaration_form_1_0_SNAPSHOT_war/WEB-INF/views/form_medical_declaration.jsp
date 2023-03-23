<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/03/2023
  Time: 12:45 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form>
  <h1>TỜ KHAI Y TẾ</h1>
  <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CHO CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
  <p>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
  <label>Họ tên(ghi chữ in HOA)</label>
  <br>
  <input type="text">
  <br>
  <label>Năm sinh</label>
  <select>
    <option>1990</option>
    <option>1991</option>
    <option>1992</option>
    <option>1993</option>
  </select>
  <label>Giới tính</label>
  <select>
    <option>Nam</option>
    <option>Nữ</option>
    <option>Khác</option>
  </select>
  <label>Quốc tịch</label>
  <select>
    <option>Việt Nam</option>
    <option>Lào</option>
    <option>Campuchia</option>
    <option>Thái Lan</option>
  </select>
  <br>
  <label>Số hộ chiếu hoặc CMND hoặc giấy thông hành hợp pháp</label>
  <br>
  <input type="text">
  <br>
  <label>Thông tin đi lại</label>
  <input type="radio" name="tt" value="Tàu bay">Tàu bay
  <input type="radio" name="tt" value="Tàu thuyền">Tàu thuyền
  <input type="radio" name="tt" value="Ô tô">Ô tô
  <input type="radio" name="tt" value="Khác(ghi rõ)">Khác(ghi rõ)
  <br>
  <lable>Số hiệu phương tiện</lable>
  <input type="text" placeholder="VD: VN123">
  <lable>Số ghế</lable>
  <input type=" text">
  <br>
  <lable>Ngày khởi hành</lable>
  <input type="date">
  <lable>Ngày kết thúc</lable>
  <input type="date">
  <br>
  <lable>Trong vòng 14 ngày anh/chị có đến tỉnh/thành phố nào</lable>
  <br>
  <textarea></textarea>
  <br>
  <lable>Địa chỉ liên lạc</lable>
  <label>Tình/thành</label>
  <select>
    <option>-Chọn-</option>
    <option>Quảng Nam</option>
    <option>Đà Nẵng</option>
    <option>Huế</option>
    <option>Hải Phòng</option>
  </select>
  <label>Quận/huyện</label>
  <select>
    <option>-Chọn-</option>
    <option>Quảng Nam</option>
    <option>Đà Nẵng</option>
    <option>Huế</option>
    <option>Hải Phòng</option>
  </select>
  <label>Phường/xạ</label>
  <select>
    <option>-Chọn-</option>
    <option>Quảng Nam</option>
    <option>Đà Nẵng</option>
    <option>Huế</option>
    <option>Hải Phòng</option>
  </select>
  <br>
  <label>Địa chỉ nơi ở</label>
  <br>
  <input type="text">
  <br>
  <label>Điện thoại</label>
  <input type="text">
  <label>Email</label>
  <input type="text">
  <br>
  <lable>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?</lable>
  <table style="border: 1px solid;">
    <tr>
      <th>Triệu chứng</th>
      <th>Có</th>
      <th>Không</th>
      <th>Triệu chứng</th>
      <th>Có</th>
      <th>Không</th>
    </tr>
    <tr>
      <td>Sốt</td>
      <td><input type="radio" name="sot"></td>
      <td><input type="radio" name="sot"></td>
      <td>Nôn/Buồn nôn</td>
      <td><input type="radio" name="non"></td>
      <td><input type="radio" name="non"></td>
    </tr>
    <tr>
      <td>Ho</td>
      <td><input type="radio" name="ho"></td>
      <td><input type="radio" name="ho"></td>
      <td>Tiêu chảy</td>
      <td><input type="radio" name="tc"></td>
      <td><input type="radio" name="tc"></td>
    </tr>
    <tr>
      <td>Khó thở</td>
      <td><input type="radio" name="kt"></td>
      <td><input type="radio" name="kt"></td>
      <td>Xuất huyết ngoài da</td>
      <td><input type="radio" name="xh"></td>
      <td><input type="radio" name="xh"></td>
    </tr>
    <tr>
      <td>Đau họng</td>
      <td><input type="radio" name="dh"></td>
      <td><input type="radio" name="dh"></td>
      <td>Nổi ban ngoài da</td>
      <td><input type="radio" name="nb"></td>
      <td><input type="radio" name="nb"></td>
    </tr>
  </table>
  <br>
  <label>Lich su phoi nhiem trong vong 14 ngay qua Anh/Chi co</label>
  <table  style="border: 1px solid;" >
    <tr>
      <th></th>
      <th>Co</th>
      <th>Khong</th>
    </tr>
    <tr>
      <td>Den trang trai chan nuoi giet mo dong vat</td>
      <td><input type="radio" name="d"></td>
      <td><input type="radio" name="d"></td>
    </tr>
    <tr>
      <td>Tiep xuc gan 2m</td>
      <td><input type="radio" name="t"></td>
      <td><input type="radio" name="t"></td>
    </tr>
  </table>
</form>


</body>
</html>

