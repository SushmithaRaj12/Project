<%@include file="Header.jsp"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="InsertProduct" modelAttribute="product" method="post">
	<table align="center"></table>


	<table>
		<tr>
			<td colspan="2">Product Detail</td>
		</tr>
		<td>Product Name</td>
		<td><form:input path="productName" /></td>
		</tr>
		<tr bgcolor="green">
			<td>Price</td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td><form:input path="stock" /></td>
		</tr>
		<tr bgcolor="green">
			<td><form:select path="categoryId">
					<form:option value="0" label="---Select List---" />
					<form:options items="${categoryList}" />
				</form:select></td>
		</tr>
		<tr>
			<td>Supplier</td>
			<td><form:input path="supplierId" /></td>
		</tr>
		<tr bgcolor="green">
			<td>Product Description</td>
			<td><form:input path="productDescr" /></td>
		</tr>
		<tr>
			<td colspan="2"><center>
					<input type="submit" value=Insert "/>
				</center></td>
		</tr>

	</table>
</form:form>