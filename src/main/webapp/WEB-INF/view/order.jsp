<%@include file="/WEB-INF/view/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="ISO-8859-1">
<title>Order Food</title>


<script>
	var x = 135;
	var name = "anshu";
	var temp = sel.options[sel.selectedIndex].text;
	;
	function myFunction() {
		x = document.getElementById("mySelect").value;

	}

	function Function() {
		var quantity = document.getElementById("quantity").value;
		document.getElementById("total").innerHTML = "Your total is: "
				+ (parseInt(quantity) * parseInt(x));

	}

	function myNewFunction(sel) {
		alert("Sas");
		temp = sel.options[sel.selectedIndex].text;
		val
		foodId;
		foodId = document.getElementById("mySelect").value;
		var n = foodId.indexOf("/");
		alert(foodId.substring(n + 1));
		document.getElementById("food_name").value = temp;

	}
	function addFunction() {
		//document.getElementById("food_name").value = temp;
		alert("sas");
	}
	function clickFunction() {
		alert("sas");
	}
	function onRowClick() {
		var table = document.getElementById("orderDetailTable");
		var rows = table.getElementsByTagName("tr");
		for (i = 0; i < rows.length; i++) {
			var currentRow = table.rows[i];
			var createClickHandler = function(row) {
				return function() {
					document.getElementById("comment").value = row
							.getElementsByTagName("td")[5].innerHTML;
					document.getElementById("mySelect").value = row
							.getElementsByTagName("td")[1].innerHTML;

				};
			};
			currentRow.onclick = createClickHandler(currentRow);
		}
	}
</script>

<style type="text/css">
body {
	background-image:
		url("https://media.gettyimages.com/photos/pasta-ingredients-picture-id635920906?s=2048x2048");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: auto;
	position: relative;
	background-position: center;
	padding: 200px;
	font-family: Arial, Helvetica;
}

* {
	box-sizing: border-box;
}

.box {
	background-color: white;
	padding: 20px;
}
.fielddesign {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	border-radius:3px;
}
.submit {
	background-color: #2a8742;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 20%;
	opacity: 0.9;
	align-items: center;
	border-radius: 25px;
	margin-left: 40%;
}

.header{
  position: absolute;
  top: 35px;
 left:30%;
  text-align: center;
  color: white;
  font-size: 85px;
  font-weight: bold;
  font-family:Georgia, serif;
  }
  
  .formheader {
	text-align: center;
	font-family: Georgia, serif;
	text-decoration-line: underline;
	text-decoration-style: solid;
	font-size: 20px;
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 2px solid #948f8f;
  text-align: center;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

</head>
<body>
<div class="header">Bon Appetite</div>
<div class="box">
	<form:form action="/BonAppetite/success" method="post"
		modelAttribute="order">
			<div class="formheader">ORDER DETAILS</div><br><br>
			
			<label>Food Name</label><br>
			<select name="foodItemPrice" id="mySelect" placeholder="Select Food Item" class="fielddesign"
					onchange="myNewFunction(this);">
						<c:forEach items="${FoodMenu}" var="FoodMenu">
							<option id="name"
								value="${FoodMenu.foodItemPrice}/${FoodMenu.foodItemId}">${FoodMenu.foodItemName}</option>
						</c:forEach>
				</select>
				<label>Quantity</label><br>
				<form:select path="quantity" id="quantity" cssClass="fielddesign"
						onchange="Function()">
						<%
							for (int i = 1; i < 10; i += 1) {
						%>
						<option value="<%=i%>">
							<%
								out.print(i);
							%>
						</option>
						<%
							}
						%>
					</form:select>
					
					<label>Comments</label><br>
			<form:textarea path="comment" id="comment" placeholder="Any Customization Required"
				cssClass="fielddesign" />
			
				<form:input type="hidden" path="foodItemName"
						id="food_name" />
						<form:input type="hidden" path="foodItemId" id="foodId" />
						
						<input type="submit" value="Add" onclick="addFunction()" class="submit">
	
					
					
		<!--  		
		<table>
			<tr>
				<td>Food name:</td>
				<td><select name="foodItemPrice" id="mySelect"
					onchange="myNewFunction(this);">
						<c:forEach items="${FoodMenu}" var="FoodMenu">
							<option id="name"
								value="${FoodMenu.foodItemPrice}/${FoodMenu.foodItemId}">${FoodMenu.foodItemName}</option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td>Quantity:</td>
				<td><form:select path="quantity" id="quantity"
						onchange="Function()">
						<%
							for (int i = 1; i < 10; i += 1) {
						%>
						<option value="<%=i%>">
							<%
								out.print(i);
							%>
						</option>
						<%
							}
						%>
					</form:select></td>

			</tr>

			<tr>
				<td>Comment:</td>
				<td><form:input path="comment" name="email" id="comment" /></td>
			</tr>
			<tr>
				<td><form:input type="hidden" path="foodItemName"
						id="food_name" /></td>
			</tr>
			<tr>
				<td><form:input type="hidden" path="foodItemId" id="foodId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" onclick="addFunction()"></td>
			</tr>
			<tr>
				<td><input type="button" value="sample"
					onclick="clickFunction()"></td>
			</tr>
		</table>
-->
	</form:form>

	<p id="total"></p>
	<br>
	<br>
	<p id="name"></p>

	<table id="orderDetailTable" align="center" border="1" width=100%>
		<tr>
			<td>Order Id</td>
			<td>Food Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Amount</td>
			<td>Comment</td>
		</tr>
		<c:forEach items="${orderList}" var="orderList">
			<tr>

				<td>${orderList.orderId}</td>
				<td>${orderList.foodItemName}</td>
				<td>${orderList.quantity}</td>
				<td>${orderList.foodItemPrice}</td>
				<td>${orderList.amount}</td>
				<td>${orderList.comment}</td>
				<td onclick="onRowClick()"><a href="">update</a></td>
				<td><a href="<c:url value='/delete/${orderList.id}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
<br><br>

<input type="submit" value="Generate Bill" onclick="window.location.href = '/BonAppetite/bill';" class="submit">

	<!--  <button align="center"
		onclick="window.location.href = '/BonAppetite/bill';" type="button"
		value="submit">submit</button>
		-->

</div>
</body>
</html>
