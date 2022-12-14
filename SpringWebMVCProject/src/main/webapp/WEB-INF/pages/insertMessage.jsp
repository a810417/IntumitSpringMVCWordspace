<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <!-- <link rel="stylesheet" href="${contextRoot}/css/bootstrap.css" />
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
    <script src="https://cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>
    <style>
      #pageBox {
        position: relative;
      }
    </style>
    <title>New Message</title>
  </head>
  <body>
    <div class="d-flex">
      <div class="container" id="pageBox">
        <ul class="list-group">
          <li class="list-group-item"><h3>新增留言</h3></li>
        </ul>
        <form action="message.create" method="GET">
          <div class="mb-3">
            <label for="title" class="form-label">標題 Title</label>
            <input
              type="text"
              class="form-control"
              id="titleInput"
              name="title"
            />
          </div>
          <div class="mb-3">
            <label for="postDate" class="form-label">發布日期 Post Date</label>
            <input
              type="Date"
              class="form-control"
              id="postDateInput"
              name="postDate"
            />
          </div>
          <div class="mb-3">
            <label for="deadLine" class="form-label">截止日期 DeadLine</label>
            <input
              type="Date"
              class="form-control"
              id="deadLineInput"
              name="deadLine"
            />
          </div>
          <div class="mb-3">
            <label for="account" class="form-label">發布者 Post</label>
            <input
              type="text"
              class="form-control"
              id="accountInput"
              name="account"
            />
          </div>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">公布內容 Content</span>
            </div>
            <br/>
            <textarea
              class="form-control"
              name="content"
              id="contentTextArea"
            ></textarea>
            <script>
              CKEDITOR.replace("content"); 
            </script>
          </div>
          <button type="submit" class="btn btn-primary">送出</button>
        </form>
      </div>
    </div>
  </body>
</html>
