<%-- 
    Document   : index
    Created on : Jul 20, 2023, 4:28:07 PM
    Author     : 84355
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <div>
        <a href="<c:url value="/products"/>" class="btn btn-info mt-2"> Thêm sản phẩm</a>
    </div>

    <c:if test="${counter >1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/" var="pageAction">
                        <c:param name="page" value="${i}"/> 
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>

    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Id</th>
                <th>Tên sản phẩm</th>
                <th>giá</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>
                        <img src="${p.image}" alt="${p.name}" width="120">
                    </td>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>
                        
                        <c:url value="/products/${p.id}" var="api" />
                        <a href="${api}" class="btn btn-success">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteProduct('${api}')">Xóa</button>
                        
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
    
        <script src="<c:url value="/js/main.js"/>"></script>
      