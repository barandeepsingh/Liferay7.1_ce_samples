<%@ include file="/init.jsp"%>

<portlet:actionURL name="producer" var="producerUrl" >
</portlet:actionURL>
<form action="${producerUrl}" method="post" enctype="multipart/form-data">
 <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email" name="<portlet:namespace/>email">
  </div>
 <div class="custom-file">
    <input type="file" class="custom-file-input" id="uploadFile" name="<portlet:namespace/>uploadFile" aria-describedby="inputGroupFileAddon01">
    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
  </div>
  <button type="submit" class="btn btn-success">Submit</button>
</form>