
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@page isELIgnored="false" %>
<title>IFIS | Vendor</title>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<script src="<c:url value="/resources/js/jquery-1.7.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/superfish.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.easing.1.3.js"/>"></script>
<script src="<c:url value="/resources/js/tms-0.4.1.js"/>"></script>
<script src="<c:url value="/resources/js/slider.js"/>" ></script>

<script type="text/javascript">
function calculatePrice(){
    var price = $("#fId").val();
    var qty = $("#fQty").val();
    var total = qty*price;
    $("#fRate").val(price);
    $("#totalPrice").val(total);
}
</script>
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<link rel="stylesheet" href="css/ie.css"> 
<![endif]-->
</head>
<body>
<div class="main-bg">
  <!-- Header -->
  <header>
    <div class="inner">
      <h1 ><a href="home">IFIS</a></h1>
      <nav>
        <ul class="sf-menu">
          <li><a href="home">Home</a></li>
          
            <!-- <li><a href="farmerstock">Farmer Stock</a></li> -->
             <li><a href="order">Order</a></li>
              <li><a href="home">LogOut</a></li>
        </ul>
      </nav>
      <div class="clear"></div>
    </div>
  </header>
  <!-- Content -->
  <section id="content">
    <div class="container_24">
      <div class="wrapper">
        <div class="grid_24 content-bg">
        <%-- <div class="grid_7 suffix_1 alpha">
          <h2>Farmer Stock:</h2>
                <c:forEach var="b" items="${li}">
                
                  <ul class="price-list">
                    <li><a href="#" class="price-item"><c:out value="${b.productname}" /></a><span class="price"><c:out value="${b.price}" />&nbsp;/kg</span>
                    <span class="price"><c:out value="${b.stock}" />kg</span><span class="filler">&nbsp;</span></li>
     
                  </ul>
                  
                  </c:forEach>
                </div> --%>
          <div >
            <article class="grid_22 suffix_1 prefix_1 alpha omega">
            <h2>Add Stock:</h2>
              <div class="wrapper indent-bot">
             
             <form action="registersavevendorproduct" method="post">
<font  color="white">
		<table>
		
			<tr><td>
			Vendor Id:</td>
			<td><input type="text" readonly="readonly" value="<c:out value="${vendor.vendorid }"/>" name="vendorid" placeholder="VendorId" ></td></tr>
<tr>
				<td><b>Product Name:<b></td>
				<td><select id="fId" onchange="calculatePrice()" name="productname">
				<c:forEach var="b" items="${product}">
						<option ><c:out value="${b.productname}" /></option>
						</c:forEach>
						</select></td>
			</tr>
			<tr>
				<td><b>Stock Available:<b></td>
				<td><input type="text" name="stock" placeholder="in KG">
				
						</td>
			</tr>
			<tr>
				<td><b>Product Price:<b></td>
				<td><input type="text" name="price" placeholder="price"></td>
			</tr>
		</table></font>
		<br>
		<br>
		<br>
		
			<input type="submit" value="Add to Stock">
		
	</form>
	 </article>
          </div>
          <div  >
            <article class="grid_22 suffix_1 prefix_1 alpha omega">
            <marquee direction="down" behavior="slide">
            <h2>Farmer Stock:</h2>
              <div class="wrapper indent-bot">
             <c:forEach var="b" items="${product}">
                
                  <ul class="price-list">
                    <li><a href="#" class="price-item"><c:out value="${b.productname}" /></a><span class="price"><c:out value="${b.price}" />&nbsp;/kg</span>
                    <span class="price"><c:out value="${b.stock}" />kg</span><span class="filler">&nbsp;</span></li>
     
                  </ul>
                  
                  </c:forEach>
           </div></marquee>
	 </article>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- Footer -->
  <footer>
    <div class="container_24">
      <div class="wrapper">
        <div class="grid_24 footer-bg">
          <div class="hr-border-2"></div>
          <div class="wrapper">
            <div class="grid_7 suffix_1 prefix_1 alpha">
              <div class="copyright"> &copy; 2012 <strong class="footer-logo">IFIS</strong>
               
              </div>
            </div>
            <div class="grid_4">
              <h5 class="heading-1">Archives:</h5>
              <ul class="footer-list">
                <li><a href="#">October 2012</a></li>
                <li><a href="#">September 2012</a></li>
                <li><a href="#">August 2012</a></li>
                <li><a href="#">July 2012</a></li>
              </ul>
            </div>
            <div class="grid_4">
              <h5 class="heading-1">Links:</h5>
              <ul class="footer-list">
                <li><a href="#">Documentation</a></li>
                <li><a href="#">Plugins</a></li>
                <li><a href="#">Suggest Ideas</a></li>
                <li><a href="#">Support Forum</a></li>
              </ul>
            </div>
            <div class="grid_4">
              <h5 class="heading-1">Support:</h5>
              <ul class="footer-list">
                <li><a href="#">Special Proposition</a></li>
                <li><a href="#">Free Phone</a></li>
                <li><a href="#">Solutions</a></li>
              </ul>
            </div>
            <div class="grid_2 suffix_1 omega">
              <ul class="social-list">
                 <li><a href="#"><img src="<c:url value="/resources/images/social-icon-1.png"/>" alt=""></a></li>
                <li><a href="#"><img src="<c:url value="/resources/images/social-icon-2.png"/>" alt=""></a></li>
                <li><a href="#"><img src="<c:url value="/resources/images/social-icon-3.png"/>" alt=""></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</div>
</body>
</html>
            