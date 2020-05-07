<%@ include file="/init.jsp"%>

<portlet:actionURL name="producer" var="producerUrl" >
</portlet:actionURL>
<form action="${producerUrl}" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email" name="<portlet:namespace/>email">
  </div>
  <button type="submit" class="btn btn-success">Submit</button>
</form>