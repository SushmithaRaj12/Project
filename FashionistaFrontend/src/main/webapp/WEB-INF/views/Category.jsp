<%@include file="Header.jsp"%>


<form action="addCategory" method="get">
	<table align="center" class="table-bordered">
		<tr>
			<td colspan="2">Category Detail</td>
		</tr>
		<tr>
			<td>Category Name</td>
			<td><input type="text" name="categoryName" /></td>
		</tr>
		<tr>
			<td>Category Descr</td>
			<td><input type="text" name="categoryDescr" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Enter Category" /></td>
		</tr>
	</table>
</form>

<br>

<br>
<table align="center" class="table">
	<tr>
		<td colspan="3"><center>Category Detail</center></td>
	</tr>
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Description</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
		<tr>
			<td>${category.categoryId}</td>
			<td>${category.categoryName}</td>
			<td>${category.categoryDescr}</td>
			<td>
			    <a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
				<a href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
			</td>
	</c:forEach>
	</tr>
</table>








