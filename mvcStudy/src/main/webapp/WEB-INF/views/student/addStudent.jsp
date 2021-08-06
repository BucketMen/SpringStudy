<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>추가 학생정보 확인</h2>
		<table>
			<tr>
				<td>
					id
				</td>
				<td>
					${student.id }
				</td>
			</tr>
			
			<tr>
				<td>
					name
				</td>
				<td>
					${student.name}
				</td>
			</tr>
			
			<tr>
				<td>
					phone
				</td>
				<td>
					${student.phone}
				</td>
			</tr>
			
			
		</table>
</body>
</html>