<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Black Pig
  Date: 13-May-24
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Edit Product</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/product/edit">
    <div class="mb-3">
        <label for="name" class="form-label">Product name</label>
        <input type="text" name="name" class="form-control" id="name" value="${product.name}">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Product price</label>
        <input type="number" name="price" class="form-control" id="price" value="${product.price}">
    </div>
    <div class="mb-3">
        <label for="stock" class="form-label">Product stock</label>
        <input type="number" name="stock" class="form-control" id="stock" value="${product.stock}">
    </div>
    <div class="mb-3">
        <label for="categoryId" class="form-label">Product category</label>
        <select id="categoryId" name="categoryId" class="form-select">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}" ${product.category.id == category.id?"selected":""}>${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <select id="status" name="status" class="form-select">
            <option value="true" ${product.status?"selected":""}>On sale</option>
            <option value="false" ${product.status?"":"selected"}>Not for sale</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Update Product Info</button>
</form>
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
