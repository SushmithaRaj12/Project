<%@ include file="Header.jsp"%>

<form action="<c:url value="/updateCategory"/>" method="post">
	<table align="center" class="table-bordered">
		<tr>
			<td colspan="2">Category Detail</td>
		</tr>
		<tr>
			<td>Category ID</td>
			<td><input type="text" name="categoryId" value="${cat.categoryId}"/></td>
		</tr>
		<tr>
			<td>Category Name</td>
			<td><input type="text" name="categoryName" value="${cat.categoryName}"/></td>
		</tr>
		<tr>
			<td>Category Description</td>
			<td><input type="text" name="categoryDescr" value="${cat.categoryDescr}"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="Update Category" />
			</td>
		</tr>
	</table>
</form>