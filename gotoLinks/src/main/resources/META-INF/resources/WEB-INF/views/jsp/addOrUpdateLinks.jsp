
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>


<div class="container">
	<h3>Enter Link Details</h3>

	<form:form method="post" modelAttribute="links">
		<table>
			<tr>
				<fieldset>
					<td><form:label path="linkName">Link Name</form:label></td>
					<td><form:input type="text" path="linkName"
							required="required" /></td>

				</fieldset>
			</tr>
			<tr>
				<fieldset >
					<td><form:label path="url">Url</form:label></td>
					<td><form:input type="text" path="url" required="required" /></td>

				</fieldset>
			</tr>
			<tr>
				<fieldset >
					<td><form:label path="categoryId">Category</form:label></td>
					<td><form:select path="categoryId" required="required">
							<option  value="${links.categoryId}" selected="selected" disabled="disabled"> Choose Category</option>
							<c:forEach items="${categoriesList}" var="category">
								<option value="${category.categoryId}">${category.categoryName}</option>
							</c:forEach>
						</form:select></td>
				</fieldset>
			</tr>
			<form:input type="hidden" path="linkId" />
			<form:input type="hidden" path="userId" />
			<tr><td colspan="2" align="middle"><input type="submit" class="btn btn-success" value="submit"></td></tr>
		</table>

	</form:form>

</div>


<%@include file="common/footer.jspf"%>