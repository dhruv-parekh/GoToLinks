
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>


<div class="container">
	<h3>Enter Link Details</h3>

	<form:form method="post" modelAttribute="category">
		<table>
			<tr>

				<td><form:label path="categoryName">Category Name</form:label></td>
				<td><form:input type="text" path="categoryName"
						required="required" /></td>

			</tr>
			<form:input type="hidden" path="categoryId" />
			<tr>
				<td colspan="2" align="middle"><input type="submit"
					class="btn btn-success" value="submit"></td>
			</tr>
		</table>

	</form:form>

</div>


<%@include file="common/footer.jspf"%>