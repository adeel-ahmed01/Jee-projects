<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	
	<jsp:body>
		<a class="btn btn-success btn-block" href="livre-ajouter">Ajouter un livre</a>
		
		<table class="table table-striped mt-5">
			<thead>
				<tr>
					<th>Titre</th>
					<th>Auteur</th>
					<th>Prix du livre</th>
					<th>Couverture du livre</th>
					<th>Résumé du livre</th>
			</thead>
			
			<tbody>
				<c:forEach var="livre" items="${ livres }">
					<tr>
						<td>${ livre.titre }</td>
						<td>${ livre.auteur }</td>
						<td>${ livre.prix }</td>
						<td>${ livre.photo }</td>
						<td>${ livre.resume }</td>
						<td>
							<a class="btn btn-warning" href="categorie-modifier?id=${ livre.id }">Modifier</a>
							<a class="btn btn-danger" href="categorie-supprimer?id=${ livre.id }">Supprimer</a>
						</td>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>