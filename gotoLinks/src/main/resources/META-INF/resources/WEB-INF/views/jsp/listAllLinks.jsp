
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>


<div class="container text-center">


	<div class="mb-4">
		<a href="addLinks" class="btn btn-info">Add Links</a> <a
			href="addCategory" class="btn btn-warning"> Add Category</a> <a
			href="listAllCategories" class="btn btn-Success"> Manage
			Categories</a>
	</div>

	<div class="mb-1">
		<form:form action="filterLinksByCategory" method="post" modelAttribute="category">
			<form:select path="categoryId">
				<option selected="selected" disabled="disabled">Choose
					Category</option>
				<c:forEach items="${listOfCategories}" var="category">
					<option value="${category.categoryId}">${category.categoryName}</option>
				</c:forEach>
			</form:select>
			<input type="submit" value="filter" class="btn btn-secondary">
		</form:form>
	</div>


	<div>
		<table class="table">
			<thead>

				<tr>
					<th>Page/Website Name</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfLinks}" var="links">
					<tr>
						<td><a href="${links.url}"
							class="link link-success link-opacity-0" target="blank">
								${links.linkName}</a></td>
						<td><a href="updateLinks?linkId=${links.linkId}"
							class="btn btn-success">Update</a> <a
							href="deleteLinks?linkId=${links.linkId}" class="btn btn-danger">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>


<%@include file="common/footer.jspf"%>