<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page
	import="com.liferay.portal.kernel.service.PortalPreferencesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.PortalPreferences"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<%@ include file="/init.jsp"%>
<portlet:resourceURL var="createBookmarkUrl" id="createBookmark"></portlet:resourceURL>
<portlet:resourceURL var="listBookmarksUrl" id="listBookmarks"></portlet:resourceURL>
<portlet:resourceURL var="deleteBookmarkUrl" id="deleteBookmark"></portlet:resourceURL>


<h1>Bookmarks List</h1>
<div id="bookmarksList"></div>


<h1>Create a new bookmark</h1>


<form class="form-horizontal" id="bookmarksForm">

	<div class="form-group">
		<label>Folder id</label> <input class="form-control" id="folderId"
			name="<portlet:namespace/>folderId" placeholder="Folder Id"
			type="text">
	</div>
	<div class="form-group">
		<label>Parent folder id</label> <input class="form-control"
			id="parentFolderId" name="<portlet:namespace/>parentFolderId"
			placeholder="Parent folder id" type="text">
	</div>
	<div class="form-group">
		<label>Tree path</label> <input class="form-control" id="treePath"
			name="<portlet:namespace/>treePath" placeholder="Tree Path"
			type="text">
	</div>
	<div class="form-group">
		<label>Name</label> <input class="form-control" id="entryName"
			name="<portlet:namespace/>entryName" placeholder="Entry Name"
			type="text">
	</div>
	<div class="form-group">
		<label>URL</label> <input class="form-control" id="url"
			name="<portlet:namespace/>url" placeholder="URL" type="text">
	</div>
	<div class="form-group">
		<label>Description</label>
		<textarea class="form-control" id="description"
			name="<portlet:namespace/>description" placeholder="Description"></textarea>
	</div>
	<div class="form-group">
		<label>Last published date</label> <input class="form-control"
			id="lastPublishedDate" name="<portlet:namespace/>lastPublishedDate"
			placeholder="Last published date" type="text">
	</div>
	<div class="form-group col-md-4">
		<label for="status">Priority</label> <select id="priority"
			name="<portlet:namespace/>priority" class="form-control">
			<option selected>Choose...</option>
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
	</div>


	<div class="form-group col-md-4">
		<label for="status">Status</label> <select id="status"
			name="<portlet:namespace/>status" class="form-control">
			<option selected>Choose...</option>
			<option value="0">Started</option>
			<option value="1">In progress</option>
			<option value="2">Deferred</option>
			<option value="3">Completed</option>
		</select>

	</div>

	<div class="control-group">
		<div class="controls">
			<button id="btnSubmit" type="button" class="btn btn-primary">Create
				Bookmark</button>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<div class="alert alert-success" role="alert" id="msgSuccess"></div>
		</div>
		<div class="controls">
			<div class="alert alert-danger" role="alert" id="msgFailure"></div>
		</div>
	</div>
</form>


<script>
	$(function() {
		$("#lastPublishedDate").datepicker();
	});
</script>
<script>
function deleteBookmarkEntry(entryId){
	$.post('${deleteBookmarkUrl}', {<portlet:namespace/>entryId:entryId},function(result) {
		alert(entryId+" deleted");
	});

}
	$(document).ready(function() {

		$.post('${listBookmarksUrl}', function(result) {
			$("#bookmarksList").html(result);
		});

		$("#btnSubmit").click(function() {
			/* var taskName = $("#taskName").val();
			var taskDescription = $("#taskDescription").val();
			var deadLine = $("#deadLine").val();
			 */
			var data = $('#bookmarksForm').serialize();

			$.post('${createBookmarkUrl}', data, function(result) {
				$("#msgSuccess").html(result);
			});
		});
	});
	

</script>