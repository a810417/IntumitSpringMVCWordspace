<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <!-- <link rel="stylesheet" href="${contextRoot}/css/bootstrap.css">
<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
<script src="${contextRoot}/js/bootstrap.bundle.js"></script> -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    <script
      src="https://code.jquery.com/jquery-3.6.2.min.js"
      integrity="sha256-2krYZKh//PcchRtd+H+VyyQoZ/e3EcrkxhM8ycwASPA="
      crossorigin="anonymous"
    ></script>
    <style>
      #pageBox {
        position: relative;
      }
    </style>
    <title>MessageBoard</title>
  </head>
  <body>
    <div class="d-flex">
      <div class="container" id="pageBox">
        <ul class="list-group">
          <li class="list-group-item"><h3>瀏覽公布事項</h3></li>
        </ul>

        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">編號</th>
              <th scope="col">標題</th>
              <th scope="col">發布日期</th>
              <th scope="col">截止日期</th>
              <th scope="col">修改</th>
              <th scope="col">刪除</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${list}" var="message">
              <tr>
                <th scope="row">${message.id}</th>
                <td>${message.title}</td>
                <td>${message.postDate}</td>
                <td>${message.deadLine}</td>
                <td>
                  <button type="button" class="btn btn-primary">
                    <a
                      href="${contextRoot}/message.update/${message.id}"
                      style="text-decoration: none; color:white"
                      >修改</a
                    >
                  </button>
                </td>
                <td>
                  <button type="button" class="btn btn-danger">
                    <a
                      href="${contextRoot}/message.delete/${message.id}"
                      style="text-decoration: none; color:white"
                      >刪除</a
                    >
                  </button>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <button type="button" class="btn btn-primary btn-sm"><a
                      href="${contextRoot}/message.new"
                      style="text-decoration: none; color:white"
                      >新增</a
                    ></button>
      </div>
    </div>
  </body>
</html>
