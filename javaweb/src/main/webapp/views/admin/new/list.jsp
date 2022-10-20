<%-- Created by IntelliJ IDEA. User: hoang Date: 17/09/2022 Time: 17:50 To
change this template use File | Settings | File Templates. --%>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Danh sách bài viết</title>
  </head>
  <body>
    <div class="main-content">
      <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
          <ul class="breadcrumb">
            <li>
              <i class="ace-icon fa fa-home home-icon"></i>
              <a href="#">Trang chủ</a>
            </li>
          </ul>
          <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
          <div class="row">
            <div class="col-xs-12"></div>
            <div class="row">
              <div class="col-xs-12">
                <div class="table-responsive">
<%--                    Bảng liệt kê các bài viết lấy từ css bootstrap--%>
                  <table class="table table-bordered">
                    <thead>
<%--                    thẻ tr là hàng, thẻ td là cột--%>
                      <tr>
                        <th>Tên bài viết</th>
                        <th>Mô tả ngắn</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>John</td>
                        <td>Doe</td>
                      </tr>
                      <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                      </tr>
                      <tr>
                        <td>July</td>
                        <td>Dooley</td>
                      </tr>
                    </tbody>
                  </table>
<%--    Thẻ để có thể phân trang--%>
<%--                  <ul class="pagination" id="pagination"></ul>--%>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
<%--    <script type="text/javascript">--%>
<%--      $(function () {--%>
<%--        window.pagObj = $('#pagination').twbsPagination({--%>
<%--          //  Tổng số trang--%>
<%--          totalPages: 10,--%>
<%--          //  Số trang có thể nhìn thấy--%>
<%--          visiblePages: 5,--%>
<%--          //  Trang bắt đầu--%>
<%--          startPage: 1,--%>
<%--          onPageClick: function (event, page) {--%>
<%--            console.info(page + ' (from options)');--%>
<%--          }--%>
<%--        }).on('page', function (event, page) {--%>
<%--          console.info(page + ' (from event listening)');--%>
<%--        });--%>
<%--      });--%>
<%--    </script>--%>
  </body>
</html>
