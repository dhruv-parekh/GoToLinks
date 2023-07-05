
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>


<div class="container text-center">

	<div>
		<table class="table">
			<thead>

				<tr>
					<th>Categories</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfCategories}" var="category">
					<tr>
						<td>${category.categoryName}</td>
						<td><a href="updateCategory?categoryId=${category.categoryId}"
							class="btn btn-success" >Update</a>
							<a href="deleteCategory?categoryId=${category.categoryId}" class="btn btn-danger">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>


<%@include file="common/footer.jspf"%>