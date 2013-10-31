<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />

<table>
	<tr>
		<td style="width: 45%"><div id="<portlet:namespace />tree"
				style="min-height: 100px; min-width: 300px;'"></div></td>
		<td style="width: 5%"></td>
		<td style="width: 50%"><div id="<portlet:namespace />nodeDetails"></div></td>
	</tr>
</table>

<script type="text/javascript">
	AUI().ready('aui-tree-view', function(A) {
		var root = {
			cache : true,
			expanded : false,
			io : "<portlet:resourceURL id='loadChildren' />&uid=root&id=root&type=ROOT_COMMUNITIES",
			label : 'ROOT_COMMUNITIES',
			type : 'io'
		};
		new A.TreeView({
			boundingBox : '#<portlet:namespace />tree',
			children : [ root ],
		}).render();
	});
</script>
