<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:Layout>
		<c:if test="${sessionScope.LoggedIn.username == null}">
			<c:redirect url="/"/>
		</c:if>
	<div class="p-2 flex-grow flex flex-col">
			<div class="flex flex-row grow">
				<div class="flex flex-grow">
					<textarea style="min-height: 650px; max-height: 650px;" name="notepadTextarea" id="notepadTextarea" class="text-black h-96 flex flex-grow border border-black p-4">
						<c:out value="${sessionScope.Notepad.trim()}" />
					</textarea>
				</div>
				<div class="flex flex-grow">
					<pre style="min-height: 650px; max-height: 650px;" id="notepadPre" class="flex flex-col flex-grow overflow-auto prose text-start prose-headings:m-0 prose-p:m-0 prose-hr:m-0 prose-ul:m-0 prose-li:m-0 prose-ol:m-0 prose-sky prose-sm p-6 bg-white h-36 border border-black"></pre>
				</div>
			</div>
			<div class="flex flex-row content-end items-end justify-end">
				<button id="submitNotepad" type="button" class="p-2 mt-4 hover:bg-blue-400 bg-blue-500 text-white rounded-md px-4 border border-blue-700">Update</button>
			</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
	<script>
		let notepad = "";
		$.ajax({
			type: 'post',
			url: 'GetNotepad',
			success: function(response) {
				if(response.success) {
					let newNotepad = response.notepad.trim();
					$('#notepadTextarea').html('');
					$('#notepadTextarea').html(newNotepad);
					$('#notepadPre').html(marked.parse(newNotepad));
					notepad = newNotepad;
				} else {
					console.log('Notepad Error');
				}
			},
			error: function(response) {
				swal({
				  title: "Error",
				  text: "Failed to get Notepad",
				  icon: "error",
				});
			}
		});
		
		$('#submitNotepad').click(function() {
			$.ajax({
				type: 'post',
				url: 'UpdateNotepad',
				data: $('#notepadTextarea').serialize(),
				success: function(response) {
					$.ajax({
						type: 'post',
						url: 'GetNotepad',
						success: function(response) {
							if(response.success) {
								let newNotepad = response.notepad.trim();
								$('#notepadTextarea').html('');
								$('#notepadTextarea').html(newNotepad);
								$('#notepadPre').html(marked.parse(newNotepad));
								notepad = newNotepad;
							} else {
								console.log('Notepad Error');
							}
						},
						error: function(response) {
							swal({
							  title: "Error",
							  text: "Failed to get Notepad",
							  icon: "error",
							});
						}
					})
				},
				error: function(response) {
					swal({
					  title: "Error",
					  text: "Failed to update Notepad",
					  icon: "error",
					});
				}
			})
		})
	</script>
</t:Layout>